import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        // dp[i][j]: i번째 숫자까지 사용하여 합이 j인 등식의 개수
        long[][] dp = new long[N - 1][21];

        // 초기값 설정
        dp[0][numbers[0]] = 1;

        // 동적 프로그래밍
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    int nextSum1 = j + numbers[i];
                    int nextSum2 = j - numbers[i];
                    if (nextSum1 >= 0 && nextSum1 <= 20) {
                        dp[i][nextSum1] += dp[i - 1][j];
                    }
                    if (nextSum2 >= 0 && nextSum2 <= 20) {
                        dp[i][nextSum2] += dp[i - 1][j];

                    }
                }
            }
        }

        // 마지막 등식의 결과가 마지막 숫자와 같은 경우를 세어 결과 출력
        long answer = dp[N - 2][numbers[N - 1]];
        System.out.println(answer);
    }
}
