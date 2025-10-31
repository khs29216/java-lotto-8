package lotto.model;

import java.util.List;

public interface LottoFactory {
    Lotto create();
    List<Lotto> createMultiple(int count);
}
