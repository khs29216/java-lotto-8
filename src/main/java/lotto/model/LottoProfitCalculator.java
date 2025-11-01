package lotto.model;

import lotto.model.lottoTicket.LottoTicket;

import java.util.List;

public class LottoProfitCalculator {

    public static double calculateProfitRate(LottoPurchaser lottoPurchaser) {
        int totalPrize = calculateTotalPrize(lottoPurchaser.getLottoTickets());
        return (double) totalPrize / lottoPurchaser.getPurchaseAmount() * 100;
    }

    private static int calculateTotalPrize(List<LottoTicket> lottoTickets) {
        int totalPrize = 0;
        for (LottoTicket lottoTicket : lottoTickets) {
            validLottoRank(lottoTicket);
            totalPrize += lottoTicket.getRank().getPrize();
        }
        return totalPrize;
    }

    private static void validLottoRank(LottoTicket lottoTicket) {
        if (lottoTicket.getRank() == null) {
            throw new IllegalArgumentException("[ERROR] 등수 체크를 하지 않은 로또가 있습니다.");
        }
    }
}
