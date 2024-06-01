package com.aiqiku.aiqikuoj.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 管理员用编辑请求
 *
 * @author <a href="https://github.com/aiqiku">程序员艾琪苦</a>
 * 
 */
@Data
public class QuestionEditRequest implements Serializable {

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
     * 判题配置
     */
    private List<JudgeConfig> judgeConfig;

    /**
     * 判题用例
     */
    private List<JudgeCase> judgeCase;


    private static final long serialVersionUID = 1L;
}