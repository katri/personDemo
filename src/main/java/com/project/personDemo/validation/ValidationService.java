package com.project.personDemo.validation;

import com.project.personDemo.infrastructure.exception.IdWrongFormat;
import com.project.personDemo.infrastructure.exception.DateException;

import java.time.LocalDate;

public class ValidationService {
    public static final String DATE_TOO_FAR = "Sünnikuupäev on liiga kaugel. Palun sisesta sünnikuupäev alates 01.01.2000";
    public static final String ID_WRONG_FORMAT = "ID on vales formaadis";

    public static void validateBirthDate(LocalDate date) {
        LocalDate dateLimit = LocalDate.of(2000, 1, 1);
        if (date.isBefore(dateLimit)) {
            throw new DateException(DATE_TOO_FAR, "Sa kasutasid kuupäeva: " + date);
        }
    }

    public static Integer validateId(String id) {
        if (id == null) {
            throw new IdWrongFormat(ID_WRONG_FORMAT, id);
        }
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
            throw new IdWrongFormat(ID_WRONG_FORMAT, id);
        }
    }
}
