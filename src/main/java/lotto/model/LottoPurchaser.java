package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {
    private final int purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();
    private LottoFactory lottoFactory;

    public LottoPurchaser(int purchaseAmount, LottoFactory lottoFactory) {
        InputValidator.validatePositiveAmount(purchaseAmount);
        LottoNumberValidator.validateDivisibleByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoFactory = lottoFactory;
    }

    public void purchaseLotto() {
        lottos.addAll(lottoFactory.createMultiple(purchaseAmount / 1000));
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
