package com.aiqiku.aiqikuoj.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/aiqiku">程序员艾琪苦</a>
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 提交代码
     */
    private String code;


    /**
     * 语言：C/C++/Java/Python/Go/JavaScript/C#/PHP/Ruby/Swift/Kotlin/Rust/R/Julia/Perl/Lua/Verilog/MinecraftScript/Other
     */
    private String language;


    private static final long serialVersionUID = 1L;
}