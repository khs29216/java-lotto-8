package lotto.util;

import java.util.Arrays;
import java.util.List;

public class NumberParser {
    private static final String DELIMITER = ",";

    private NumberParser() {
    }

    public static int parseAndValidateInt(String input) {
        InputValidator.validateNullOrEmpty(input);
        InputValidator.validateWithWhiteSpace(input);
        InputValidator.validateNumericOnly(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> parseAndValidateNumbers(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER, -1))
                .map(NumberParser::parseAndValidateInt)
                .toList();
    }
}
