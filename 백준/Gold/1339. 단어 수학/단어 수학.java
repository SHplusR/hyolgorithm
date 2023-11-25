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
        Integer[] alphaInteger = Arrays.stream(alpha).boxed().toArray(Integer[]::new);
        Arrays.sort(alphaInteger, Collections.reverseOrder());
        
        for(int i=0; i<alphaInteger.length; i++){
            if(alphaInteger[i] == 0) break;
            else{
                answer += alphaInteger[i]*k;
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