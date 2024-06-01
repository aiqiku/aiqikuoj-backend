package com.aiqiku.aiqikuoj.controller;

import com.aiqiku.aiqikuoj.common.BaseResponse;
import com.aiqiku.aiqikuoj.common.ErrorCode;
import com.aiqiku.aiqikuoj.common.ResultUtils;
import com.aiqiku.aiqikuoj.exception.BusinessException;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.aiqiku.aiqikuoj.model.entity.User;
import com.aiqiku.aiqikuoj.service.QuestionSubmitService;
import com.aiqiku.aiqikuoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交
 *
 * @author <a href="https://github.com/aiqiku">程序员艾琪苦</a>
 * 
 */
@RestController
@RequestMapping("/post_thumb")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 新增结果
     */
    @PostMapping("/")
    public BaseResponse<Integer> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionId = questionSubmitAddRequest.getQuestionId();
        int result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }

}
