import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[]  dp = new int[n+1];

        for(int i=1; i<n+1; i++){
            int num = Integer.parseInt(strings[i-1]);
            dp[num] = dp[num-1]+1;
        }
        Arrays.sort(dp);
        System.out.println(n-dp[n]);
    }
    
}
