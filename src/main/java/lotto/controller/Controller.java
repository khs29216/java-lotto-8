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
        outputView.printLottoTickets(lottoPurchaser.getLottoTickets(), lottoPurchaser.getPurchaseAmount());

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        LottoWinning lottoWinning = new LottoWinning(new Lotto(winningNumbers), bonusNumber);
        checkLottoTickets(lottoWinning, lottoPurchaser);

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoPurchaser);
        lottoWinningStatistics.updateWinningCount();
        outputView.printWinningStatistics(lottoPurchaser, lottoWinningStatistics);
    }

    private LottoPurchaser createLottoPurchaser() {
        int purchaseAmount = NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount, new AutoLottoFactory());
        lottoPurchaser.purchaseLottoTickets();
        return lottoPurchaser;
    }

    private List<Integer> inputWinningNumbers() {
        return NumberParser.parseAndValidateNumbers(inputView.inputWinningNumbers());
    }

    private int inputBonusNumber() {
        return NumberParser.parseAndValidateInt(inputView.inputBonusNumber());
    }

    private void checkLottoTickets(LottoWinning lottoWinning, LottoPurchaser lottoPurchaser) {
        for (LottoTicket lottoTicket : lottoPurchaser.getLottoTickets()) {
            lottoTicket.checkLottoTicket(lottoWinning);
        }
    }
}
