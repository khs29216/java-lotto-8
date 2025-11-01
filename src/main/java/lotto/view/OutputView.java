package lotto.view;

import lotto.model.Lotto;
import lotto.model.lottoTicket.LottoTicket;

import java.util.List;

public class OutputView {

    public void printLottoTickets(List<LottoTicket> lottoTickets, int purchaseAmount) {
        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다");
        for (LottoTicket lottoTicket : lottoTickets) {
            printLotto(lottoTicket.getLotto());
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers().stream()
                .sorted()
                .toList();
        System.out.println(numbers);
    }
}
