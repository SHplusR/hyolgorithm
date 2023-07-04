import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] coins = {25,10,5,1};
        int count = Integer.valueOf(br.readLine());
        for(int i =0; i<count; i++){
            int changes = Integer.valueOf(br.readLine());
            for(int j=0; j<coins.length; j++){
                int changecount = changes / coins[j];
                sb.append(changecount+" ");
                changes  = changes % coins[j];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}