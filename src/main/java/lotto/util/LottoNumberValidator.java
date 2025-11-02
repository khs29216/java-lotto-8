package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.model.Lotto;

public class LottoNumberValidator {

    private LottoNumberValidator() {
    }

    public static void validateLottoNumberRange(int number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % Lotto.UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVISIBLE_BY_THOUSAND);
        }
    }
}
