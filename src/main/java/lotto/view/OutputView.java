package lotto.view;

import lotto.model.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputView {
    private static final String FORMAT_PURCHASE_COUNT = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String FORMAT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.\n";
    private static final String FORMAT_WINNING_DETAIL = "%s (%,d원) - %d개\n";
    private static final String FORMAT_MATCH_COUNT = "%d개 일치";
    private static final String BONUS_BALL_SUFFIX = ", 보너스 볼 일치";

    public void printLottoTickets(List<LottoTicket> lottoTickets, int purchaseAmount) {
        System.out.printf(FORMAT_PURCHASE_COUNT, purchaseAmount / Lotto.UNIT_PRICE);
        for (LottoTicket lottoTicket : lottoTickets) {
            printLotto(lottoTicket.getLotto());
        }
    }

    public void printWinningStatistics(LottoWinningStatistics lottoWinningStatistics) {
        System.out.println(WINNING_STATISTICS_HEADER);
        List<Rank> ranks = Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getRank).reversed())
                .filter(rank -> rank != Rank.MISS)
                .toList();

        printWinningDetail(lottoWinningStatistics, ranks);
        System.out.printf(FORMAT_PROFIT_RATE, lottoWinningStatistics.calculateProfitRate());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers().stream()
                .sorted()
                .toList();
        System.out.println(numbers);
    }

    private void printWinningDetail(LottoWinningStatistics lottoWinningStatistics, List<Rank> ranks) {
        for (Rank rank : ranks) {
            String matchCount = String.format(FORMAT_MATCH_COUNT, rank.getMatchCount());
            if (rank == Rank.SECOND_PLACE) {
                matchCount += BONUS_BALL_SUFFIX;
            }

            int count = lottoWinningStatistics.getWinningCount().getOrDefault(rank, 0);
            System.out.printf(FORMAT_WINNING_DETAIL, matchCount, rank.getPrize(), count);
        }
    }
}
