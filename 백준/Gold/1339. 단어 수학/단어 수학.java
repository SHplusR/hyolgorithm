import java.io.*;
import java.util.*;

public class Main {

    static int[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        alpha = new int[26];
        int answer =0;
        int k=9;
        for(int i=0; i<n; i++){
            alphaNum(br.readLine());
        }
        Arrays.sort(alpha);

        for(int i=alpha.length-1; i>=0; i--){
            if(alpha[i] == 0) break;
            else{
                answer += alpha[i]*k;
                k--;
            }
        }
        System.out.println(answer);
    }
    static void alphaNum(String s){
        for(int i=0; i<s.length(); i++){
            alpha[(int)s.charAt(i)-65] += Math.pow(10,s.length()-(i+1));
        }
    }
}