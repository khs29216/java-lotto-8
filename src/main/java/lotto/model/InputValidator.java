package lotto.model;

public class InputValidator {
    private static final String REGEX_NUMERIC_ONLY = "\\d+";

    private InputValidator() {
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY);
        }
    }

    public static void validateWithWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.WITH_WHITE_SPACE);
        }
    }

    public static void validateNumericOnly(String input) {
        if (!input.matches(REGEX_NUMERIC_ONLY)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ONLY);
        }
    }

    public static void validatePositiveAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_AMOUNT);
        }
    }
}
