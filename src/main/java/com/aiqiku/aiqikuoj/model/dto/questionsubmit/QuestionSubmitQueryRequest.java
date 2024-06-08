package com.aiqiku.aiqikuoj.model.dto.questionsubmit;

import com.aiqiku.aiqikuoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/aiqiku">程序员艾琪苦</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable{

    private Long id;
    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 语言：C/C++/Java/Python/Go/JavaScript/C#/PHP/Ruby/Swift/Kotlin/Rust/R/Julia/Perl/Lua/Verilog/MinecraftScript/Other
     */
    private String language;
    /**
     * 提交状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}