package com.aiqiku.aiqikuoj.model.vo;

import cn.hutool.json.JSONUtil;
import com.aiqiku.aiqikuoj.model.dto.question.JudgeConfig;
import com.aiqiku.aiqikuoj.model.entity.Post;
import com.aiqiku.aiqikuoj.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目封装类
 * @TableName question
 */

@Data
public class QuestionVO implements Serializable {
    /**
     * id
     */

    private Long id;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题目标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 提交次数
     */
    private Integer submitNum;

    /**
     * 通过数
     */
    private Integer acceptedNum;

    /**
     * 判题配置
     */
    private JudgeConfig judgeConfig;


    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人信息
     */
    private UserVO userVO;
    private static final long serialVersionUID = 1L;

    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (tagList != null){
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if (voJudgeConfig != null){
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tagList = JSONUtil.toList(question.getTags(), String.class);

        questionVO.setTags(tagList);
        String judgeConfig = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfig,JudgeConfig.class));
        return questionVO;
    }
}