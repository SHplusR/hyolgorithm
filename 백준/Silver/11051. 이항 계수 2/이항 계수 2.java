import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(" ");
    int n = Integer.valueOf(strings[0]);
    int m = Integer.valueOf(strings[1]);
    int[][] combi = new int[n+1][m+1];
    for(int i=0; i<=n; i++) {
    	combi[i][0] = 1;
    }
    for(int i=0; i<=m; i++) {
    	combi[i][i] = 1;
    }
    for(int i=2; i<=n;i++) {
    	for(int j=1; j<=m; j++) {
    		combi[i][j] = (combi[i-1][j-1]+combi[i-1][j])%10007; 
    	}
    }
    System.out.println(combi[n][m]);
}
}