package com.aiqiku.aiqikuoj.service;

import com.aiqiku.aiqikuoj.model.dto.question.QuestionQueryRequest;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.aiqiku.aiqikuoj.model.entity.Question;
import com.aiqiku.aiqikuoj.model.entity.QuestionSubmit;
import com.aiqiku.aiqikuoj.model.entity.User;
import com.aiqiku.aiqikuoj.model.vo.QuestionSubmitVO;
import com.aiqiku.aiqikuoj.model.vo.QuestionVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

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

    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);
}
