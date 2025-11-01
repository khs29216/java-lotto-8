package lotto.model.lottoTicket;

import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoTicket {
    private final Lotto lotto;
    private Rank rank;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return new Lotto(lotto.getNumbers());
    }

    public Rank getRank() {
        validLottoRank();
        return rank;
    }

    void updateRank(Rank rank) {
        this.rank = rank;
    }

    private void validLottoRank() {
        if (rank == null) {
            throw new IllegalArgumentException("[ERROR] 현재 로또의 등수 체크를 하지 않았습니다");
        }
    }
}
