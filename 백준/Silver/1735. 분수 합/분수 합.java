import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[][] ints = new int[2][2];
    int numer = 0;
    
    for(int i =0; i<2; i++) {
    	String[] strings = br.readLine().split(" ");
    	ints[i][0] = Integer.valueOf(strings[0]);
    	ints[i][1] = Integer.valueOf(strings[1]);
    }
    
    int denom = ints[0][1] * ints[1][1];
    
    for(int i=0; i<2; i++) {
    	numer += (ints[i][0] * (denom/ints[i][1]));
    }
    int q = getGcd(numer, denom);
    if(q != 1) {
    	numer = numer/q;
    	denom = denom/q;
    };
    sb.append(numer +" "+ denom);
    System.out.println(sb);
    }
    
    static int getGcd(int a, int b) {
    	int r = a % b;
    	if(r==0) {
    		return b;
    	}
    	return getGcd(b, r);
    }
}