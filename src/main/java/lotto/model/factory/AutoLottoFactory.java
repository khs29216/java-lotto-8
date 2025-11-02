package lotto.model.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoFactory implements LottoFactory {
    @Override
    public Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    @Override
    public List<Lotto> createMultiple(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(create());
        }
        return lottos;
    }
}
