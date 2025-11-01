package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPurchaser;
import lotto.model.LottoWinningStatistics;
import lotto.model.lottoTicket.LottoTicket;
import lotto.model.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    public void printLottoTickets(List<LottoTicket> lottoTickets, int purchaseAmount) {
        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다");
        for (LottoTicket lottoTicket : lottoTickets) {
            printLotto(lottoTicket.getLotto());
        }
    }

    public void printWinningStatistics(LottoPurchaser lottoPurchaser, LottoWinningStatistics lottoWinningStatistics) {
        System.out.println("당첨 통계\n---");
        List<Rank> ranks = Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getRank).reversed())
                .filter(rank -> rank.getRank() != 0)
                .toList();

        for (Rank rank : ranks) {
            String matchCount = rank.getMatchCount() + "개 일치";
            if (rank == Rank.SECOND_PLACE) {
                matchCount += ", 보너스";
            }
            String prize = String.format("%,d원", rank.getPrize());
            int count = lottoWinningStatistics.getWinningCount().getOrDefault(rank, 0);
            System.out.printf("%s (%s) - %d개\n", matchCount, prize, count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoWinningStatistics.calculateProfitRate());
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers().stream()
                .sorted()
                .toList();
        System.out.println(numbers);
    }
}
