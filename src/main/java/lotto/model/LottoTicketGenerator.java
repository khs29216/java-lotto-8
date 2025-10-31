package lotto.model;

import lotto.model.lottoTicket.LottoTicket;

public class LottoTicketGenerator {
    public static LottoTicket generateLottoTicket(Lotto lotto) {
        return new LottoTicket(lotto);
    }
}
