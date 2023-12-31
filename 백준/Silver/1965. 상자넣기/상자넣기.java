import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];
        int[] dp = new int[n];
        int answer = 0;
        String[] boxsizeS = br.readLine().split(" ");
        for(int i=0; i<n;i++){
            boxes[i] = Integer.parseInt(boxsizeS[i]);
            dp[i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<i;j++){
                if(boxes[i]>boxes[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i] > answer){
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}