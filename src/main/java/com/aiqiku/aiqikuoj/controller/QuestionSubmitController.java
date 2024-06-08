package com.aiqiku.aiqikuoj.controller;

import com.aiqiku.aiqikuoj.common.BaseResponse;
import com.aiqiku.aiqikuoj.common.ErrorCode;
import com.aiqiku.aiqikuoj.common.ResultUtils;
import com.aiqiku.aiqikuoj.exception.BusinessException;
import com.aiqiku.aiqikuoj.model.dto.question.QuestionQueryRequest;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.aiqiku.aiqikuoj.model.entity.Question;
import com.aiqiku.aiqikuoj.model.entity.QuestionSubmit;
import com.aiqiku.aiqikuoj.model.entity.User;
import com.aiqiku.aiqikuoj.model.vo.QuestionSubmitVO;
import com.aiqiku.aiqikuoj.service.QuestionSubmitService;
import com.aiqiku.aiqikuoj.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 */
@RestController
@RequestMapping("/question_submit")
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
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        final User loginUser = userService.getLoginUser(request);
        long questionId = questionSubmitAddRequest.getQuestionId();
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 获取题目提交列表(除了管理员外，普通用户只能看到非答案，提交代码等公开信息)
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        if (questionSubmitQueryRequest == null || questionSubmitQueryRequest.getCurrent() <= 0 || questionSubmitQueryRequest.getPageSize() <= 0) {

            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数错误");
        }
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        //返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }
}
