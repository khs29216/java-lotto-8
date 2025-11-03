package lotto.dto;

import lotto.model.LottoWinningStatistics;
import lotto.model.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public record LottoWinningStatisticsDto(
        Map<Rank, Integer> winningCounts,
        double profitRate
) {
    public static LottoWinningStatisticsDto from(LottoWinningStatistics statistics) {
        Map<Rank, Integer> winningCounts = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparingInt(Rank::getRank).reversed())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> statistics.getWinningCount().getOrDefault(rank, 0),
                        (a, b) -> a,
                        LinkedHashMap::new // 순서 유지
                ));
        return new LottoWinningStatisticsDto(winningCounts, statistics.calculateProfitRate());
    }
}
