package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", })
    public void 입력값이_비어있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateNullOrEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000", "2 000", "3000 ", "  4000  "})
    public void 입력값에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWithWhiteSpace(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10a", "abb", "109b0"})
    public void 입력값에_숫자가_아닌_문자가_포함되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumericOnly(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -22, -300})
    public void 구매_금액이_0이하면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> InputValidator.validatePositiveAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1234, 34001})
    public void 구매_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> InputValidator.validateDivisibleByThousand(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
