package org.deodev.LibrarySystem.validation;

import jdk.jfr.Description;
import org.deodev.LibrarySystem.exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    static Stream<Arguments> provideArgumentsStringInputTests() {
        return Stream.of(Arguments.of((Object) null),
                Arguments.of(""));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsStringInputTests")
    @Description("throw error custom InvalidInputException for null, empty string input")
    void checkForNullOrBlank(String input) {
        assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNotNullOrBlank(input);
        });
    }

    @Test
    @Description("throw error custom InvalidInputException integer input less than zero")
    void checkForNegative() {
        int input = -1;
        assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNonNegative(input);
        });
    }



}