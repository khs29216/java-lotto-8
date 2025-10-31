package lotto.model.lottoTicket;

import lotto.model.Lotto;
import lotto.model.LottoWinning;
import lotto.model.Rank;

import java.util.List;

public class LottoTicketChecker {
    private final LottoWinning lottoWinning;

    public LottoTicketChecker(LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

    public void checkLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.updateRank(matchLotto(lottoTicket.getLotto()));
    }

    private Rank matchLotto(Lotto lotto) {
        List<Integer> matchingNumbers = lotto.getNumbers().stream()
                .filter(number -> lottoWinning.getWinningNumbers().getNumbers().contains(number))
                .toList();

        int matchingCount = matchingNumbers.size();
        boolean bonusMatched = lotto.getNumbers().contains(lottoWinning.getBonusNumber());

        return Rank.of(matchingCount, bonusMatched);
    }
}
