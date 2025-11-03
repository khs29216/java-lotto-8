package lotto.controller;

import lotto.dto.LottoPurchaserDto;
import lotto.dto.LottoWinningStatisticsDto;
import lotto.model.Lotto;
import lotto.model.LottoPurchaser;
import lotto.model.LottoWinningNumber;
import lotto.model.LottoWinningStatistics;
import lotto.model.factory.AutoLottoFactory;
import lotto.util.NumberParser;
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
        LottoPurchaserDto lottoPurchaserDto = LottoPurchaserDto.from(lottoPurchaser);
        outputView.printLottoTickets(lottoPurchaserDto);

        Lotto winningMainNumbers = createWinningMainNumbers();
        LottoWinningNumber lottoWinningNumber = createLottoWinningNumberWithBonus(winningMainNumbers);

        lottoPurchaser.checkLottoTickets(lottoWinningNumber);

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoPurchaser);
        lottoWinningStatistics.updateWinningCount();
        LottoWinningStatisticsDto lottoWinningStatisticsDto = LottoWinningStatisticsDto.from(lottoWinningStatistics);
        outputView.printWinningStatistics(lottoWinningStatisticsDto);
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

    private Lotto createWinningMainNumbers() {
        while (true) {
            try {
                List<Integer> winningMainNumbers = inputWinningMainNumbers();
                Lotto lotto = new Lotto(winningMainNumbers);
                return lotto;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoWinningNumber createLottoWinningNumberWithBonus(Lotto winningMainNumbers) {
        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningMainNumbers, bonusNumber);
                return lottoWinningNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int inputPurchaseAmount() {
        return NumberParser.parseAndValidateInt(inputView.inputPurchaseAmount());
    }

    private List<Integer> inputWinningMainNumbers() {
        return NumberParser.parseAndValidateNumbers(inputView.inputWinningNumbers());
    }

    private int inputBonusNumber() {
        return NumberParser.parseAndValidateInt(inputView.inputBonusNumber());
    }
}
