package lotto.dto;

import lotto.model.Lotto;
import lotto.model.LottoPurchaser;
import lotto.model.LottoTicket;

import java.util.List;

public record LottoPurchaserDto(
        int purchaseCount,
        List<List<Integer>> lottoNumbers
) {
    public static LottoPurchaserDto from(LottoPurchaser purchaser) {
        List<List<Integer>> lottoNumbers = purchaser.getLottoTickets().stream()
                .map(LottoTicket::getLotto)
                .map(Lotto::getNumbers)
                .map(numbers -> numbers.stream().sorted().toList())
                .toList();

        return new LottoPurchaserDto(purchaser.getPurchaseAmount() / Lotto.UNIT_PRICE, lottoNumbers);
    }
}
