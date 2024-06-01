package com.aiqiku.aiqikuoj.model.dto.question;

import lombok.Data;

/**
 * @author aiqiku
 * @create 2024/6/1 10:37
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private Long timeLimit;
    /**
     * 内存限制 (kb)
     */
    private Long memoryLimit;
    /**
     * 输入限制限制(2000B)
     */
    private String inputFile;
    /**
     * 输出限制
     */
    private String outputFile;
    /**
     * 堆栈限制
     */
    private Long stackLimit;
}
