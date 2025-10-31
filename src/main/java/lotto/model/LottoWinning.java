package lotto.model;

public class LottoWinning {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoWinning(Lotto winningNumbers, int bonusNumber) {
        LottoNumberValidator.validateLottoNumberRange(bonusNumber);
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotInWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
