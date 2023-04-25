package com.project.personDemo.infrastructure.exception;

import lombok.Data;

@Data
public class DateException extends RuntimeException {
    private final String title;
    private final String detail;

    public DateException(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}
