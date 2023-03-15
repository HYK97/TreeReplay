package hanteo.test.project.coin;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinServiceTest {
    private final CoinService service = new CoinService();

    @Test
    @DisplayName("combinationCoins 테스트")
    public void combinationCoins() {
        assertThat(service.combinationCoins(4, new int[] {1, 2, 3})).isEqualTo(4);
        assertThat(service.combinationCoins(10, new int[] {2, 5, 3, 6})).isEqualTo(5);
    }

}