package org.deodev.LibrarySystem.validation;

import jdk.jfr.Description;
import org.deodev.LibrarySystem.exception.InvalidInputException;
import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.model.Member;
import org.deodev.LibrarySystem.repository.Library;
import org.deodev.LibrarySystem.util.BaseQueue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    static Stream<Arguments> provideArgumentsStringInputTests() {
        return Stream.of(Arguments.of((String) null),
                Arguments.of(""));
    }

    static Stream<Arguments> provideArgumentsObjectsInputTests() {
        return Stream.of(Arguments.of((String) null),
                Arguments.of((Book) null),
                Arguments.of((Library) null),
                Arguments.of((Member) null),
                Arguments.of((BaseQueue) null),
                Arguments.of((Integer) null)
                );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsStringInputTests")
    @Description("throw custom InvalidInputException error for null, empty string input")
    void checkForNullOrBlank(String input) {
        assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNotNullOrBlank(input);
        });
    }

    @Test
    @Description("throw custom InvalidInputException error integer input less than zero")
    void checkForNegative() {
        assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNonNegative(-1);
        });
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsObjectsInputTests")
    @Description("throw custom InvalidInputException error if Object is null")
    void validateNotNull(Object obj) {
        assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNotNull(obj);
        });
    }


}