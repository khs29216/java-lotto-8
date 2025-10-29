package lotto.model;

public class InputValidator {
    private static final String REGEX_NUMERIC_ONLY = "\\d+";

    private InputValidator() {
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    public static void validateWithWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 입력값에 공백이 포함되어 있습니다.");
        }
    }

    public static void validateNumericOnly(String input) {
        if (!input.matches(REGEX_NUMERIC_ONLY)) {
            throw new IllegalArgumentException("[ERROR] 입력값으로 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원으로 나누어 떨어져야합니다.");
        }
    }
}
