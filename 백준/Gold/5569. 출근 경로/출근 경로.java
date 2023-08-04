//깃헙제출용
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int w = Integer.parseInt(strings[0]);
        int h = Integer.parseInt(strings[1]);
        int[][][][] dp = new int[w + 1][h + 1][2][2];
        int MOD = 100000;
// 파스칼 삼각형 깔기 (어차피 다 1임)
        for (int i = 1; i <= w; i++) {
            dp[i][1][0][0] = 1;
        }
        for (int i = 1; i <= h; i++) {
            dp[1][i][1][0] = 1;
        }

        for (int i = 2; i <= w; i++) {
            for (int j = 2; j <= h; j++) {
                //[0 오른쪽 1 위쪽][0 안 꺾임 1 꺾임]
                // 직접 그려보며 하는걸 추천(이해하는데 한참 걸림.. 블로그 정리할것)
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1])%MOD;
                dp[i][j][0][1] = dp[i-1][j][1][0] % MOD;
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1])%MOD;
                dp[i][j][1][1] = dp[i][j-1][0][0] % MOD;
            }
        }
       int sum = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1])%MOD;
        System.out.println(sum);
    }
}