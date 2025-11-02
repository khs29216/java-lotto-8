package lotto.model;

public class LottoNumberValidator {
    private static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 " + Lotto.MIN_NUMBER + "부터 " + Lotto.MAX_NUMBER + "사이의 숫자여야 합니다.";
    private static final String ERROR_DIVISIBLE_BY_THOUSAND = "[ERROR] 구매 금액은 " + Lotto.UNIT_PRICE + "원으로 나누어 떨어져야합니다.";

    private LottoNumberValidator() {
    }

    public static void validateLottoNumberRange(int number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % Lotto.UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_DIVISIBLE_BY_THOUSAND);
        }
    }
}
