package lotto.controller;

import lotto.model.*;
import lotto.model.lottoTicket.LottoTicket;
import lotto.model.lottoTicket.LottoTicketChecker;
import lotto.view.InputView;

import java.util.List;

public class Controller {
    private InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int purchaseAmount = NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmount, new AutoLottoFactory());
        lottoPurchaser.purchaseLottoTickets();

        List<Integer> winningNumbers = NumberParser.parseAndValidateNumbers(inputView.inputWinningNumbers());
        int bonusNumber = NumberParser.parseAndValidateInt(inputView.inputBonusNumber());
        LottoWinning lottoWinning = new LottoWinning(new Lotto(winningNumbers), bonusNumber);

        LottoTicketChecker lottoChecker = new LottoTicketChecker(lottoWinning);
        for (LottoTicket lottoTicket : lottoPurchaser.getLottoTickets()) {
            lottoChecker.checkLottoTicket(lottoTicket);
        }

        double profitRate = LottoProfitCalculator.calculateProfitRate(lottoPurchaser);
    }
}
