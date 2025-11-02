package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {
    private final Map<Rank, Integer> winningCount = new EnumMap<>(Rank.class);
    private LottoPurchaser lottoPurchaser;

    public LottoWinningStatistics(LottoPurchaser lottoPurchaser) {
        this.lottoPurchaser = lottoPurchaser;
    }

    public void updateWinningCount() {
        List<LottoTicket> lottoTickets = lottoPurchaser.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = lottoTicket.getRank();
            winningCount.put(rank, winningCount.getOrDefault(rank, 0) + 1);
        }
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / lottoPurchaser.getPurchaseAmount() * 100;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : winningCount.keySet()) {
            totalPrize += (long) rank.getPrize() * winningCount.put(rank, winningCount.getOrDefault(rank, 0));
        }
        return totalPrize;
    }

    public Map<Rank, Integer> getWinningCount() {
        return Collections.unmodifiableMap(winningCount);
    }
}
