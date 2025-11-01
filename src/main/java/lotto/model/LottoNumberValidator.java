package lotto.model;

public class LottoNumberValidator {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 " + MIN + "부터 " + MAX + "사이의 숫자여야 합니다.";
    private static final String ERROR_DIVISIBLE_BY_THOUSAND = "[ERROR] 구매 금액은 " + LOTTO_PRICE + "원으로 나누어 떨어져야합니다.";

    private LottoNumberValidator() {
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_DIVISIBLE_BY_THOUSAND);
        }
    }
}
