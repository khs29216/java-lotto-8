package lotto.model;

public class NumberParser {

    public static int parseAndValidateInt(String input) {
        InputValidator.validateNullOrEmpty(input);
        InputValidator.validateWithWhiteSpace(input);
        InputValidator.validateNumericOnly(input);

        return Integer.parseInt(input);
    }
}
