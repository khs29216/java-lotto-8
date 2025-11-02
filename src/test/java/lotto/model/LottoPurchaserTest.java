package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.model.factory.AutoLottoFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaserTest {
    @Test
    public void 정상적인_입력값일_경우_구매_금액으로_LottoPurchaser_객체를_생성한다() {
        // given
        int purchaseAmount = 14000;
        LottoPurchaser expected = new LottoPurchaser(14000, new AutoLottoFactory());

        // when
        LottoPurchaser actual = new LottoPurchaser(purchaseAmount, new AutoLottoFactory());

        // then
        assertThat(actual.getPurchaseAmount())
                .isEqualTo(expected.getPurchaseAmount());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 입력값이_0이하의_숫자일_경우_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> new LottoPurchaser(purchaseAmount, new AutoLottoFactory()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.POSITIVE_AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(ints = {14001, 12345})
    public void 입력값이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> new LottoPurchaser(purchaseAmount, new AutoLottoFactory()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DIVISIBLE_BY_THOUSAND);
    }

    @Test
    public void 로또_구입_금액_만큼_로또를_발행한다() {
        // given
        int purchaseAmount = 14000;
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount, new AutoLottoFactory());
        int expectedLottoCount = purchaseAmount / Lotto.UNIT_PRICE;

        // when
        lottoPurchaser.purchaseLottoTickets();

        // then
        int actualLottoCount = lottoPurchaser.getLottoTickets().size();
        assertThat(actualLottoCount).isEqualTo(expectedLottoCount);
    }
}
