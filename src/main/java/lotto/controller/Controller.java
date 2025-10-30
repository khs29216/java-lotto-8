package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchaser;
import lotto.model.LottoWinning;
import lotto.model.NumberParser;
import lotto.view.InputView;

import java.util.List;

public class Controller {
    private InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int purchaseAmount = NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount);

        List<Integer> winningNumbers = NumberParser.parseAndValidateNumbers(inputView.inputWinningNumbers());
        LottoWinning lottoWinning = new LottoWinning(new Lotto(winningNumbers));
    }

}
