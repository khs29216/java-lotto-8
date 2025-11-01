package lotto.model;

import lotto.model.lottoTicket.LottoTicket;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {
    private final Map<Rank, Integer> winningCount = new EnumMap<>(Rank.class);

    public void updateWinningCount(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = lottoTicket.getRank();
            winningCount.put(rank, winningCount.getOrDefault(rank, 0) + 1);
        }
    }

    public double calculateProfitRate(LottoPurchaser lottoPurchaser) {
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / lottoPurchaser.getPurchaseAmount() * 100;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : winningCount.keySet()) {
            totalPrize += rank.getPrize() * winningCount.put(rank, winningCount.getOrDefault(rank, 0));
        }
        return totalPrize;
    }

}
