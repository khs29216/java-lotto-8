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
        return rank;
    }

    void updateRank(Rank rank) {
        this.rank = rank;
    }
}
