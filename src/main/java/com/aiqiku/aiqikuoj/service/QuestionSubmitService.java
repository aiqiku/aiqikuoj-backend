package com.aiqiku.aiqikuoj.service;

import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.aiqiku.aiqikuoj.model.entity.QuestionSubmit;
import com.aiqiku.aiqikuoj.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author aiqiku
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2024-06-01 10:13:21
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 题目提交（内部服务）
     *
     * @param userId
     * @param questionId
     * @return
     */
    int doQuestionSubmitInner(long userId, long questionId);
}
