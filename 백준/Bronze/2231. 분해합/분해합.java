
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int n = Integer.valueOf(str);
        int result = 0;
            for(int i = n-(9*len); i<=n; i++){
                int hap = i;
                int r = i;
                while(r != 0){
                    hap += r%10;
                    r= r/10;
                }
                if(hap == n){
                    result = i;
                    break;
                }
            }
        System.out.println(result);
        }
    }