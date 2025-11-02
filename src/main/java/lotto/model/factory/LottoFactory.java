package lotto.model.factory;

import lotto.model.Lotto;

import java.util.List;

public interface LottoFactory {
    Lotto create();
    List<Lotto> createMultiple(int count);
}
