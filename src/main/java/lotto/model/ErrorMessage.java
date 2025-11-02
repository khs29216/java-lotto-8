package lotto.model;

public class ErrorMessage {
    public static final String NULL_OR_EMPTY = "[ERROR] 입력값이 비어있습니다.";
    public static final String WITH_WHITE_SPACE = "[ERROR] 입력값에 공백이 포함되어 있습니다.";
    public static final String NUMERIC_ONLY = "[ERROR] 입력값으로 숫자만 입력할 수 있습니다.";
    public static final String POSITIVE_AMOUNT = "[ERROR] 구매 금액은 0보다 커야 합니다.";
    public static final String LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 " + Lotto.MIN_NUMBER + "부터 " + Lotto.MAX_NUMBER + "사이의 숫자여야 합니다.";
    public static final String DIVISIBLE_BY_THOUSAND = "[ERROR] 구매 금액은 " + Lotto.UNIT_PRICE + "원으로 나누어 떨어져야합니다.";
    public static final String BONUS_NUMBER_NOT_IN_WINNING_MAIN_NUMBERS = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String UNIQUE_NUMBER = "[ERROR] 중복되는 번호가 있습니다.";
    public static final String LOTTO_RANK_UNCHECKED = "[ERROR] 현재 로또의 등수 체크를 하지 않았습니다";

    private ErrorMessage() {
    }
}
