package lotto.view;

import lotto.dto.LottoPurchaserDto;
import lotto.dto.LottoWinningStatisticsDto;
import lotto.model.Rank;

public class OutputView {
    private static final String FORMAT_PURCHASE_COUNT = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String FORMAT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.\n";
    private static final String FORMAT_WINNING_DETAIL = "%s (%,d원) - %d개\n";
    private static final String FORMAT_MATCH_COUNT = "%d개 일치";
    private static final String BONUS_BALL_SUFFIX = ", 보너스 볼 일치";

    public void printLottoTickets(LottoPurchaserDto dto) {
        System.out.printf(FORMAT_PURCHASE_COUNT, dto.purchaseCount());
        dto.lottoNumbers().forEach(System.out::println);
    }

    public void printWinningStatistics(LottoWinningStatisticsDto dto) {
        System.out.println(WINNING_STATISTICS_HEADER);
        printWinningDetail(dto);

        System.out.printf(FORMAT_PROFIT_RATE, dto.profitRate());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printWinningDetail(LottoWinningStatisticsDto dto) {
        for (Rank rank : dto.winningCounts().keySet()) {
            String matchCount = String.format(FORMAT_MATCH_COUNT, rank.getMatchCount());
            if (rank == Rank.SECOND_PLACE) {
                matchCount += BONUS_BALL_SUFFIX;
            }

            int count = dto.winningCounts().getOrDefault(rank, 0);
            System.out.printf(FORMAT_WINNING_DETAIL, matchCount, rank.getPrize(), count);
        }
    }
}
