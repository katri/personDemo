package com.project.personDemo.infrastructure.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper=false)
@Data
public class IdWrongFormatException extends RuntimeException {
    private final String title;
    private final  String detail;

    public IdWrongFormatException(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}