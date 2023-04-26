package com.project.personDemo.validation;

import com.project.personDemo.infrastructure.exception.DateException;
import com.project.personDemo.infrastructure.exception.IdWrongFormatException;
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

    @Test
    void validateIdWithCorrectData() {
        String idAsString = "2";
        Integer idAsInteger = ValidationService.validateId(idAsString);

        assertEquals(idAsInteger, 2);
    }

    @Test
    void validateIdWithStringAsData() {
        String idAsString = "foo";

        IdWrongFormatException formatException = assertThrows(IdWrongFormatException.class, ()
                -> ValidationService.validateId(idAsString));
        assertTrue(formatException.getMessage().contentEquals("ID on vales formaadis"));
        assertTrue(formatException.getDetail().contentEquals("foo"));
    }

    @Test
    void validateNullId() {
        String idAsString = null;

        IdWrongFormatException formatException = assertThrows(IdWrongFormatException.class, ()
                -> ValidationService.validateId(idAsString));
        assertTrue(formatException.getMessage().contentEquals("ID on vales formaadis"));
        assertTrue(formatException.getDetail().contentEquals("id on puudu"));
    }

    @Test
    void validateEmptyId() {
        String idAsString = "";

        IdWrongFormatException formatException = assertThrows(IdWrongFormatException.class, ()
                -> ValidationService.validateId(idAsString));
        assertTrue(formatException.getMessage().contentEquals("ID on vales formaadis"));
        assertTrue(formatException.getDetail().contentEquals(""));
    }
}