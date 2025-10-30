package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 47})
    public void 로또_번호의_범위를_벗어나면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
