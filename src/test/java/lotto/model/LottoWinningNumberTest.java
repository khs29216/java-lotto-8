package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumberTest {
    @Test
    public void 정상적인_입력값일_경우_보너스_번호로_LottoWinningNumber_객체를_생성한다() {
        // given
        Lotto winningMainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoWinningNumber expected = new LottoWinningNumber(winningMainNumbers, 7);

        // when
        LottoWinningNumber actual = new LottoWinningNumber(winningMainNumbers, bonusNumber);

        // then
        assertThat(actual.getBonusNumber()).isEqualTo(expected.getBonusNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 46, 100})
    public void 보너스_번호가_로또_번호의_범위를_벗어난_경우_예외가_발생한다(int bonusNumber) {
        Lotto winningMainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoWinningNumber(winningMainNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다(int bonusNumber) {
        Lotto winningMainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoWinningNumber(winningMainNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_MAIN_NUMBERS);
    }
}
