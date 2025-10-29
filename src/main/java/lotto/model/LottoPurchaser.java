package lotto.model;

public class LottoPurchaser {
    private final int purchaseAmount;

    public LottoPurchaser(int purchaseAmount) {
        InputValidator.validateDivisibleByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }
}
