package lotto.model;

public class LottoNumberValidator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 " + MIN + "부터 " + MAX + "사이의 숫자여야 합니다.";

    public static void validateLottoNumberRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
