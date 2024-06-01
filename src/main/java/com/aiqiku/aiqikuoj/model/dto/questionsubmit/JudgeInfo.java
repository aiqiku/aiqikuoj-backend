package com.aiqiku.aiqikuoj.model.dto.questionsubmit;

/**
 * @author aiqiku
 * @create 2024/6/1 10:42
 */

import lombok.Data;

/**
 * 判题信息
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 内存消耗
     */
    private Long memoryCost;

    /**
     * 消耗时间
     */
    private Long timeCost;

}
