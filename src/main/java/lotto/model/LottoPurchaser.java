package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {
    private final int purchaseAmount;
    private List<LottoTicket> lottoTickets = new ArrayList<>();
    private LottoFactory lottoFactory;

    public LottoPurchaser(int purchaseAmount, LottoFactory lottoFactory) {
        InputValidator.validatePositiveAmount(purchaseAmount);
        LottoNumberValidator.validateDivisibleByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoFactory = lottoFactory;
    }

    public void purchaseLottoTickets() {
        List<Lotto> lottos = lottoFactory.createMultiple(purchaseAmount / 1000);
        for (Lotto lotto : lottos) {
            lottoTickets.add(new LottoTicket(lotto));
        }
    }

    public void checkLottoTickets(LottoWinningNumber lottoWinningNumber) {
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoTicket.checkLottoTicket(lottoWinningNumber);
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return List.copyOf(lottoTickets);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
