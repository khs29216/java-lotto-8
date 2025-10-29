package lotto.model;

public class InputValidator {
    private static final String REGEX_NUMERIC_ONLY = "\\d+";
    private static final String ERROR_NULL_OR_EMPTY = "[ERROR] 입력값이 비어있습니다.";
    private static final String ERROR_WITH_WHITE_SPACE = "[ERROR] 입력값에 공백이 포함되어 있습니다.";
    private static final String ERROR_NUMERIC_ONLY = "[ERROR] 입력값으로 숫자만 입력할 수 있습니다.";
    private static final String ERROR_DIVISIBLE_BY_THOUSAND = "[ERROR] 입력값으로 숫자만 입력할 수 있습니다.";

    private InputValidator() {
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
        }
    }

    public static void validateWithWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_WITH_WHITE_SPACE);
        }
    }

    public static void validateNumericOnly(String input) {
        if (!input.matches(REGEX_NUMERIC_ONLY)) {
            throw new IllegalArgumentException(ERROR_NUMERIC_ONLY);
        }
    }

    public static void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_DIVISIBLE_BY_THOUSAND);
        }
    }
}
