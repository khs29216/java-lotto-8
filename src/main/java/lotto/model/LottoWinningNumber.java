package lotto.model;

public class LottoWinningNumber {
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public LottoWinningNumber(Lotto winningMainNumbers, int bonusNumber) {
        LottoNumberValidator.validateLottoNumberRange(bonusNumber);
        validateBonusNumberNotInWinningMainNumbers(winningMainNumbers, bonusNumber);
        this.mainNumbers = winningMainNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotInWinningMainNumbers(Lotto winningMainNumbers, int bonusNumber) {
        if (winningMainNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_MAIN_NUMBERS);
        }
    }

    public Lotto getMainNumbers() {
        return new Lotto(mainNumbers.getNumbers());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}