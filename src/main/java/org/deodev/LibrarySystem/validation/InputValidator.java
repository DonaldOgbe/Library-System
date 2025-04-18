package org.deodev.LibrarySystem.validation;

import org.deodev.LibrarySystem.exception.InvalidInputException;

public class InputValidator {
    private InputValidator() {}

    public static void validateNotNullOrBlank(String title) {
        if (title == null) throw new InvalidInputException("String input cannot be Null");
        if (title.isEmpty()) throw new InvalidInputException("String input cannot be Blank");
    }

    public static void validateNonNegative(int copies) {
        if (copies < 0) throw new InvalidInputException("Integer input cannot be less than Zero");
    }

    public static  void validateNotNull(Object obj) {
        if (obj == null) throw new InvalidInputException("Object input cannot be Null");
    }
}
