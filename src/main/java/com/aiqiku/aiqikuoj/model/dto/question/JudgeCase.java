package com.aiqiku.aiqikuoj.model.dto.question;

import lombok.Data;

/** 题目用例
 * @author aiqiku
 * @create 2024/6/1 10:35
 */
@Data
public class JudgeCase {
    //输入用例
    private String input;

    //期望输出
    private String output;
}
