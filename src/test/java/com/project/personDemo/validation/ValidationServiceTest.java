package com.project.personDemo.validation;

import com.project.personDemo.infrastructure.exception.DateException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    @Test
    void validateBirthDateWithCorrectDate() {
        LocalDate birthdate = LocalDate.of(2000, 1, 1);

        assertDoesNotThrow(() -> ValidationService.validateBirthDate(birthdate));
    }

    @Test
    void validateBirthDateWithTooFarDate() {
        LocalDate birthdate = LocalDate.of(1986, 9, 25);

        DateException dateException = assertThrows(DateException.class, ()
                -> ValidationService.validateBirthDate(birthdate));
        assertTrue(dateException.getMessage()
                .contentEquals("Sünnikuupäev on liiga kaugel. Palun sisesta sünnikuupäev alates 01.01.2000"));
    }
}