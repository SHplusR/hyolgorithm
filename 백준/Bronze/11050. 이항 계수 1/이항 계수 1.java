import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(" ");
    int n = Integer.valueOf(strings[0]);
    int m = Integer.valueOf(strings[1]);
    int numer =1;
    int denom =1;
    for(int i=n; i>n-m;i--) {
    	numer *= i;
    }
    for(int i=1; i<=m;i++) {
    	denom *= i;
    }
    System.out.println(numer/denom);
}

}