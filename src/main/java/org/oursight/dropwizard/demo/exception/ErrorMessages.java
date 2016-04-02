package org.oursight.dropwizard.demo.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jackson.JsonSnakeCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao@github.com on 2016/3/24.
 */
@JsonSnakeCase
public class ErrorMessages {

    private List<ErrorMessage> errors = new ArrayList<ErrorMessage>();

    @JsonProperty
    public ErrorMessage[] getErrors() {
        return errors.toArray(new ErrorMessage[errors.size()]);
    }



    public void addError(ErrorMessage error) {
        errors.add(error);
    }

}
