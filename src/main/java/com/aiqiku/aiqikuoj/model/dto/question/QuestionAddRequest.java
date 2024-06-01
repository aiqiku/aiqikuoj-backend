package com.aiqiku.aiqikuoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/aiqiku">程序员艾琪苦</a>
 * 
 */
@Data
public class QuestionAddRequest implements Serializable {



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
    private String judgeConfig;

    /**
     * 判题用例
     */
    private String judgeCase;






    private static final long serialVersionUID = 1L;
}