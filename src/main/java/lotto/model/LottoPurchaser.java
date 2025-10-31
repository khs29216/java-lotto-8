package lotto.model;

public class LottoPurchaser {
    private final int purchaseAmount;

    public LottoPurchaser(int purchaseAmount) {
        InputValidator.validatePositiveAmount(purchaseAmount);
        LottoNumberValidator.validateDivisibleByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
