package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinngingStatisticsTest {

    private static class FixedLottoFactory implements LottoFactory {
        private final List<Lotto> fixedLottos;

        public FixedLottoFactory(List<Lotto> fixedLottos) {
            this.fixedLottos = fixedLottos;
        }

        @Override
        public Lotto create() {
            return null; // 테스트에서 사용하지 않음
        }

        @Override
        public List<Lotto> createMultiple(int count) {
            return fixedLottos.subList(0, count);
        }
    }

    @Test
    public void 등수별_당첨_횟수가_올바르게_계산되는지_테스트() {
        // given
        List<Lotto> fixedLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,7,8)),
                new Lotto(List.of(1,2,3,9,10,11)),
                new Lotto(List.of(1,2,12,13,14,15))
        );
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(new Lotto(List.of(1,2,3,4,5,6)), 7);

        LottoPurchaser lottoPurchaser = new LottoPurchaser(4000, new FixedLottoFactory(fixedLottos));
        lottoPurchaser.purchaseLottoTickets();
        lottoPurchaser.checkLottoTickets(lottoWinningNumber);
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoPurchaser);

        Map<Rank, Integer> expectedWinningCount = new EnumMap<>(Rank.class);
        expectedWinningCount.put(Rank.FIRST_PLACE, 1);
        expectedWinningCount.put(Rank.FOURTH_PLACE, 1);
        expectedWinningCount.put(Rank.FIFTH_PLACE, 1);
        expectedWinningCount.put(Rank.MISS, 1);

        // when
        lottoWinningStatistics.updateWinningCount();

        // then
        Map<Rank, Integer> actualWinningCount = lottoWinningStatistics.getWinningCount();
        assertThat(actualWinningCount).isEqualTo(expectedWinningCount);
    }

    @Test
    public void 총_수익률_올바르게_계산되는지_테스트() {
        // given
        List<Lotto> fixedLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,7,8)),
                new Lotto(List.of(1,2,3,9,10,11)),
                new Lotto(List.of(1,2,12,13,14,15))
        );
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(new Lotto(List.of(1,2,3,4,5,6)), 7);

        LottoPurchaser lottoPurchaser = new LottoPurchaser(4000, new FixedLottoFactory(fixedLottos));
        lottoPurchaser.purchaseLottoTickets();
        lottoPurchaser.checkLottoTickets(lottoWinningNumber);
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoPurchaser);
        lottoWinningStatistics.updateWinningCount();

        long expectedTotalPrize = Rank.FIRST_PLACE.getPrize() + Rank.FOURTH_PLACE.getPrize() + Rank.FIFTH_PLACE.getPrize();
        double expectedProfitRate = (double) expectedTotalPrize / lottoPurchaser.getPurchaseAmount() * 100;

        // when
        double actualProfitRate = lottoWinningStatistics.calculateProfitRate();

        // then
        assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }
}
