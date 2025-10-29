package lotto.controller;

import lotto.model.LottoPurchaser;
import lotto.model.NumberParser;
import lotto.view.InputView;

public class Controller {
    private InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int purchaseAmount = NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount);
    }

}
