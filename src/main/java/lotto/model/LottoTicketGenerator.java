package lotto.model;

public class LottoTicketGenerator {
    public static LottoTicket generateLottoTicket(Lotto lotto) {
        return new LottoTicket(lotto);
    }
}
