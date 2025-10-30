package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberParserTest {
    private static List<String> provideInvalidInput() {
        return List.of(
                "",         // 빈 문자열
                " 1000",    // 공백 포함
                "1000a"     // 문자 포함
        );
    }

    private static List<String> provideInvalidNumbers() {
        return List.of(
                "1,a,3,4,5,6",
                "1,,3,4,5,6",
                "1.2.3.4.5.6"
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidInput")
    public void 숫자가_아닌_다른_값이_입력값에_포함되어_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> NumberParser.parseAndValidateInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    public void 숫자와_쉼표_이외의_문자가_입력값에_포함되어_있으면_예외가_발생한다(String numbers) {
        assertThatThrownBy(() -> NumberParser.parseAndValidateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
