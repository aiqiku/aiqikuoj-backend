package com.aiqiku.aiqikuoj.service;

import com.aiqiku.aiqikuoj.model.dto.post.PostQueryRequest;
import com.aiqiku.aiqikuoj.model.dto.question.QuestionQueryRequest;
import com.aiqiku.aiqikuoj.model.entity.Post;
import com.aiqiku.aiqikuoj.model.entity.Question;
import com.aiqiku.aiqikuoj.model.vo.PostVO;
import com.aiqiku.aiqikuoj.model.vo.QuestionVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author aiqiku
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-06-01 10:11:56
*/
public interface QuestionService extends IService<Question> {
    /**
     * 参数校验
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取脱敏题目内容
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 获取脱敏题目分页内容
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);

    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);
}
