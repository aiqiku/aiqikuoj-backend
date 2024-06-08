package com.aiqiku.aiqikuoj.model.vo;

import cn.hutool.json.JSONUtil;
import com.aiqiku.aiqikuoj.model.dto.question.JudgeConfig;
import com.aiqiku.aiqikuoj.model.dto.questionsubmit.JudgeInfo;
import com.aiqiku.aiqikuoj.model.entity.Question;
import com.aiqiku.aiqikuoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目提交表
 * @TableName question_submit
 */

@Data
public class QuestionSubmitVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 提交用户 id
     */
    private Long userId;

    /**
     * 提交内容
     */
    private String code;

    /**
     * 提交标识：AC/TLE/MLE/WA/RE/OLE/CE/PE/SE/UE/VE/CE/JUDGING/JUDGED
     */
    private Integer status;

    /**
     * 语言：C/C++/Java/Python/Go/JavaScript/C#/PHP/Ruby/Swift/Kotlin/Rust/R/Julia/Perl/Lua/Verilog/MinecraftScript/Other
     */
    private String language;

    /**
     * 判题信息{json对象}
     */
    private JudgeInfo judgeInfo;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 提交用户信息
     */
    private UserVO userVO;

    /**
     * 题目信息
     */
    private QuestionVO questionVO;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public static QuestionSubmit voToObj(QuestionSubmitVO questionSubmitVO) {
        if (questionSubmitVO == null) {
            return null;
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitVO, questionSubmit);
        JudgeInfo judgeInfo1 = questionSubmitVO.getJudgeInfo();
        if (judgeInfo1 != null) {
            questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo1));
        }

        return questionSubmit;
    }
    public static QuestionSubmitVO objToVo(QuestionSubmit questionSubmit) {
        if (questionSubmit == null) {
            return null;
        }
        QuestionSubmitVO questionSubmitVO = new QuestionSubmitVO();
        BeanUtils.copyProperties(questionSubmit, questionSubmitVO);
        String judgeInfo1 = questionSubmit.getJudgeInfo();
        if (judgeInfo1 != null) {
            questionSubmitVO.setJudgeInfo(JSONUtil.toBean(judgeInfo1, JudgeInfo.class));
        }
        return questionSubmitVO;
    }
}