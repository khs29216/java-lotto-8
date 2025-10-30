package lotto.model;

import java.util.Arrays;
import java.util.List;

public class NumberParser {

    public static int parseAndValidateInt(String input) {
        InputValidator.validateNullOrEmpty(input);
        InputValidator.validateWithWhiteSpace(input);
        InputValidator.validateNumericOnly(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> parseAndValidateNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(NumberParser::parseAndValidateInt)
                .toList();
    }
}
