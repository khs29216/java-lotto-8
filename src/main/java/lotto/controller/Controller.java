package lotto.controller;

import lotto.model.*;
import lotto.model.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoPurchaser lottoPurchaser = createLottoPurchaser();
        lottoPurchaser.purchaseLottoTickets();
        outputView.printLottoTickets(lottoPurchaser.getLottoTickets(), lottoPurchaser.getPurchaseAmount());

        Lotto winningNumbers = createWinningNumbers();
        LottoWinning lottoWinning = createLottoWinningWithBonus(winningNumbers);

        lottoPurchaser.checkLottoTickets(lottoWinning);

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoPurchaser);
        lottoWinningStatistics.updateWinningCount();
        outputView.printWinningStatistics(lottoPurchaser, lottoWinningStatistics);
    }

    private LottoPurchaser createLottoPurchaser() {
        while (true) {
            try {
                int purchaseAmount = inputPurchaseAmount();
                LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount, new AutoLottoFactory());
                return lottoPurchaser;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto createWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputWinningNumbers();
                Lotto lotto = new Lotto(winningNumbers);
                return lotto;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoWinning createLottoWinningWithBonus(Lotto winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                LottoWinning lottoWinning = new LottoWinning(winningNumbers, bonusNumber);
                return lottoWinning;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int inputPurchaseAmount() {
        return NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
    }

    private List<Integer> inputWinningNumbers() {
        return NumberParser.parseAndValidateNumbers(inputView.inputWinningNumbers());
    }

    private int inputBonusNumber() {
        return NumberParser.parseAndValidateInt(inputView.inputBonusNumber());
    }
}
