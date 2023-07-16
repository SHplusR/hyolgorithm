import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] stairs = new int[n+1];
        stairs[0] = 0;
        for(int i =1; i<=n; i++){
            stairs[i] = Integer.valueOf(br.readLine()); //계단 배열
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = stairs[1];
        if(n >=3){
            dp[2] = stairs[1] + stairs[2];
            for(int i =3; i<=n; i++){
                int nojump = stairs[i] + stairs[i-1] + dp[i-3];
                int onejump = stairs[i] + dp[i-2];
                if(nojump > onejump){
                    dp[i] = nojump;
                }
                else{
                    dp[i] = onejump;
                }
            }
        }
        else if(n==2){
            dp[n] = stairs[1] + stairs[2];
        }
        System.out.println(dp[n]);
    }
}