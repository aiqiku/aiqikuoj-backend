package com.aiqiku.aiqikuoj.model.enums.questionsubmit;

import com.aiqiku.aiqikuoj.model.enums.FileUploadBizEnum;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**判题信息消息枚举
 * @author aiqiku
 * @create 2024/6/1 12:12
 */
public enum JudgeInfoMessageEnum {
    ACCEPTED("Accepted","答案正确"), // 答案正确
    WRONG_ANSWER("Wrong Answer","答案错误"), // 答案错误
    TIME_LIMIT_EXCEEDED("Time Limit Exceeded","超时"), // 超时
    MEMORY_LIMIT_EXCEEDED("Memory Limit Exceeded","内存超限"), // 内存超限
    OUTPUT_LIMIT_EXCEEDED("Output Limit Exceeded","输出超限"), // 输出超限
    RUNTIME_ERROR("Runtime Error","运行时错误"), // 运行时错误
    COMPILATION_ERROR("Compilation Error","编译错误"), // 编译错误
    SYSTEM_ERROR("System Error","系统错误"), // 系统错误
    UNKNOWN_ERROR("Unknown Error","未知错误"); // 未知错误


    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
