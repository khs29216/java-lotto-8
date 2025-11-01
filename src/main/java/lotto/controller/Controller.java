package lotto.controller;

import lotto.model.*;
import lotto.model.lottoTicket.LottoTicket;
import lotto.model.lottoTicket.LottoTicketChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private InputView inputView;
    private OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount, new AutoLottoFactory());
        lottoPurchaser.purchaseLottoTickets();
        outputView.printLottoTickets(lottoPurchaser.getLottoTickets(), lottoPurchaser.getPurchaseAmount());

        List<Integer> winningNumbers = NumberParser.parseAndValidateNumbers(inputView.inputWinningNumbers());
        int bonusNumber = NumberParser.parseAndValidateInt(inputView.inputBonusNumber());
        LottoWinning lottoWinning = new LottoWinning(new Lotto(winningNumbers), bonusNumber);

        LottoTicketChecker lottoChecker = new LottoTicketChecker(lottoWinning);
        for (LottoTicket lottoTicket : lottoPurchaser.getLottoTickets()) {
            lottoChecker.checkLottoTicket(lottoTicket);
        }

        LottoWinningStatistics lottoWinningStatisitcs = new LottoWinningStatistics();
        lottoWinningStatisitcs.updateWinningCount(lottoPurchaser.getLottoTickets());
    }
}
