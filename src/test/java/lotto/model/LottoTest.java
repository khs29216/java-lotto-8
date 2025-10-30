package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static Stream<List<Integer>> provideOutOfRangeNumbers() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(0, 1, 2, 3, 4, 47),
                List.of(1, 2, 3, 4, 5, 100)
        );
    }

    @Test
    void 로또_번호를_정상_입력했을_때_Lotto_객체를_생성한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto expected = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lotto actual = new Lotto(numbers);

        // then
        assertThat(actual.getNumbers())
                .isEqualTo(expected.getNumbers());
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideOutOfRangeNumbers")
    void 로또_번호에_범위를_넘은_숫자가_있으면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
