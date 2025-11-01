package lotto.model;

import java.util.List;

public class LottoTicket {
    private final Lotto lotto;
    private Rank rank;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public void checkLottoTicket(LottoWinning lottoWinning) {
        rank = matchLotto(lottoWinning);
    }

    public Lotto getLotto() {
        return new Lotto(lotto.getNumbers());
    }

    public Rank getRank() {
        validLottoRank();
        return rank;
    }

    private Rank matchLotto(LottoWinning lottoWinning) {
        List<Integer> matchingNumbers = lotto.getNumbers().stream()
                .filter(number -> lottoWinning.getWinningNumbers().getNumbers().contains(number))
                .toList();

        int matchingCount = matchingNumbers.size();
        boolean bonusMatched = lotto.getNumbers().contains(lottoWinning.getBonusNumber());

        return Rank.of(matchingCount, bonusMatched);
    }

    private void validLottoRank() {
        if (rank == null) {
            throw new IllegalArgumentException("[ERROR] 현재 로또의 등수 체크를 하지 않았습니다");
        }
    }
}
