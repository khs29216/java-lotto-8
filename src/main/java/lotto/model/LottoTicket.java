package lotto.model;

import lotto.constant.ErrorMessage;

import java.util.List;

public class LottoTicket {
    private final Lotto lotto;
    private Rank rank;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public void checkLottoTicket(LottoWinningNumber winningNumber) {
        rank = matchLotto(winningNumber);
    }

    public Lotto getLotto() {
        return new Lotto(lotto.getNumbers());
    }

    public Rank getRank() {
        validLottoRank();
        return rank;
    }

    private Rank matchLotto(LottoWinningNumber lottoWinningNumber) {
        List<Integer> matchingNumbers = lotto.getNumbers().stream()
                .filter(number -> lottoWinningNumber.getMainNumbers().getNumbers().contains(number))
                .toList();

        int matchingCount = matchingNumbers.size();
        boolean bonusMatched = lotto.getNumbers().contains(lottoWinningNumber.getBonusNumber());

        return Rank.of(matchingCount, bonusMatched);
    }

    private void validLottoRank() {
        if (rank == null) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANK_UNCHECKED);
        }
    }
}
