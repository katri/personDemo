package com.project.personDemo.infrastructure.exception;

import lombok.Data;

@Data
public class IdWrongFormat extends RuntimeException {
    private final String title;
    private final  String detail;

    public IdWrongFormat(String title, String detail) {
        super(title);
        this.title = title;
        this.detail = detail;
    }
}