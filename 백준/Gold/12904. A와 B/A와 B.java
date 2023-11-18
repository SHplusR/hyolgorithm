import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        while(T.length() != S.length()){
            String s = T.substring(0,T.length()-1);
            if(T.charAt(T.length()-1) == 'A'){
                T = s;
            }
            else{
                StringBuilder sb = new StringBuilder(s);
                T = String.valueOf(sb.reverse());
            }
        }
        if(T.equals(S)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}