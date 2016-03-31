package cn.com.deepdata.frontend.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jackson.JsonSnakeCase;

/**
 * Created by neyao@github.com on 2016/3/24.
 */
@JsonSnakeCase
public class ErrorMessage {

    public static ErrorMessage PARAMETER_SHOULD_NOT_BE_NULL = new ErrorMessage("parameter_should_not_be_null");
    public static ErrorMessage RESULT_IS_EMPTY = new ErrorMessage("result_is_empty");

    /**
     * 错误的简要描述
     */
    private String message;
    /**
     * 错误的具体信息
     */
    private String detail;

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public String getDetail() {
        return detail;
    }


    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }
}
