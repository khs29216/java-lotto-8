package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', 7, FIRST_PLACE",
            "'1,2,3,4,5,7', 7, SECOND_PLACE",
            "'1,2,3,4,5,8', 7, THIRD_PLACE",
            "'1,2,3,4,20,30', 7, FOURTH_PLACE",
            "'1,2,3,20,30,40', 7, FIFTH_PLACE",
            "'1,2,20,30,40,41', 7, MISS"
    })
    public void 로또_번호와_당첨_번호를_비교한_후_올바른_등수와_매칭한다(String inputNumbers, int bonusNumber, Rank expectedRank) {
        // given
        List<Integer> numbers = NumberParser.parseAndValidateNumbers(inputNumbers);

        LottoTicket lottoTicket = new LottoTicket(new Lotto(numbers));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonusNumber
        );

        // when
        lottoTicket.checkLottoTicket(lottoWinningNumber);

        // then
        assertThat(lottoTicket.getRank()).isEqualTo(expectedRank);
    }
}
