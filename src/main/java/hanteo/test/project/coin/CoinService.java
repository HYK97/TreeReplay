
package hanteo.test.project.coin;

import org.springframework.stereotype.Service;

@Service
public class CoinService {

    /**
     * 입력: sum = 4, coins[] = {1,2,3},
     * 출력: 4
     * 설명: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}의 네 가지 솔루션이 있습니다.
     * 결과 예시)
     * 입력: 합계 = 10, coins[] = {2, 5, 3, 6}
     * 출력: 5
     * 설명: 다섯 가지 솔루션이 있습니다.
     * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 및 {5,5}
     *
     *    1  2  3  4
     * 1  1  1  1  1
     * 2  0  1  1  2
     * 3  0  0  0  1
     *    1  2  2  4 -> 답 4
     * */
    public int combinationCoins(int sum, int[] coins) {
        int[] DPTable = new int[sum + 1];
        DPTable[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                DPTable[j] += DPTable[j - coin];
            }
        }
        return DPTable[sum];
    }

}