//깃헙제출용
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.valueOf(br.readLine());
    	int[][] dp = new int[n+1][n+1];
    	int[][] tri = new int[n+1][n+1];
    	for(int i=1; i<=n; i++) {
    		String[] strings = br.readLine().split(" ");
    		int j= 1;
    		for(String a : strings) {
    			tri[i][j] = Integer.valueOf(a);
    			j++;
    		}
    	}
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=n;j++) {
    			dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+tri[i][j];
    		}
    	}
    	int sum = 0;
    	for(int i=1; i<=n; i++) {
    		if(sum<dp[n][i]) {
    			sum = dp[n][i];
    		}
    	}
    	System.out.println(sum);
}
}