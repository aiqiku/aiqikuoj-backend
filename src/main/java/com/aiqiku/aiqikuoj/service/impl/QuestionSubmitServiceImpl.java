package com.aiqiku.aiqikuoj.service.impl;

import com.aiqiku.aiqikuoj.common.ErrorCode;
import com.aiqiku.aiqikuoj.exception.BusinessException;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.aiqiku.aiqikuoj.model.entity.*;
import com.aiqiku.aiqikuoj.model.entity.QuestionSubmit;
import com.aiqiku.aiqikuoj.model.enums.questionsubmit.QuestionSubmitStatusEnum;
import com.aiqiku.aiqikuoj.service.QuestionService;
import com.aiqiku.aiqikuoj.service.QuestionSubmitService;
import com.aiqiku.aiqikuoj.service.QuestionSubmitService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aiqiku.aiqikuoj.model.entity.QuestionSubmit;
import com.aiqiku.aiqikuoj.service.QuestionSubmitService;
import com.aiqiku.aiqikuoj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author 张路路
* @description 针对表【question_submit(题目提交表)】的数据库操作Service实现
* @createDate 2024-06-01 10:13:21
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
     Long questionId = questionSubmitAddRequest.getQuestionId();
     String code = questionSubmitAddRequest.getCode();
     String language = questionSubmitAddRequest.getLanguage();

        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否提交题目
        long userId = loginUser.getId();
        // 每个用户串行提交题目
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setLanguage(language);
        questionSubmit.setCode(code);
        //设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        questionSubmit.setQuestionId(questionId);
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"数据插入异常");
        }
        return questionSubmit.getId();
    }

    /**
     * 封装了事务的方法
     *
     * @param userId
     * @param questionId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int doQuestionSubmitInner(long userId, long questionId) {
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        QueryWrapper<QuestionSubmit> thumbQueryWrapper = new QueryWrapper<>(questionSubmit);
        QuestionSubmit oldQuestionSubmit = this.getOne(thumbQueryWrapper);
        boolean result;
        // 已点赞
        if (oldQuestionSubmit != null) {
            result = this.remove(thumbQueryWrapper);
            if (result) {
                // 点赞数 - 1
                result = questionSubmitService.update()
                        .eq("id", questionId)
                        .gt("thumbNum", 0)
                        .setSql("thumbNum = thumbNum - 1")
                        .update();
                return result ? -1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        } else {
            // 未点赞
            result = this.save(questionSubmit);
            if (result) {
                // 点赞数 + 1
                result = questionSubmitService.update()
                        .eq("id", questionId)
                        .setSql("thumbNum = thumbNum + 1")
                        .update();
                return result ? 1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        }
    }
}




