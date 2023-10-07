import java.util.*;
import java.io.*;

public class Main {
    static class drivePath {
        int start, end, value;
        public drivePath(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int d = Integer.parseInt(strings[1]);

        ArrayList<drivePath> dpath = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] dStrings = br.readLine().split(" ");
            int start = Integer.parseInt(dStrings[0]);
            int end = Integer.parseInt(dStrings[1]);
            int value = Integer.parseInt(dStrings[2]);
            if (end > d) continue; // 고속도로 거리 추가
            if (end - start <= value)continue; //기존 길보다 더 걸림
            dpath.add(new drivePath(start,end,value));
        }

        Collections.sort(dpath, new Comparator<drivePath>() {
            public int compare(drivePath o1, drivePath o2) {
                if (o1.start == o2.start)
                {
                    return Integer.compare(o1.end, o2.end);
                }
                return Integer.compare(o1.start, o2.start);
            }
        });
        int move = 0;
        int dp[] = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int idx = 0;
        while (move < d) {
            if (idx < dpath.size()) {
                drivePath sp = dpath.get(idx);
                if (move == sp.start) {
                    dp[sp.end] = Math.min(dp[move] + sp.value, dp[sp.end]);
                    idx++;
                } else {
                    dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                    move++;
                }
            } else {
                dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                move++;
            }
        }
        System.out.println(dp[d]);
    }
}