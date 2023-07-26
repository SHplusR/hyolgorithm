import java.io.*;
import java.util.*;

public class Main {
	static long[] array = new long[91];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		if(n <=2) {
			System.out.println(1);
		}
		else {
			System.out.println(fibo(n));
		}
		
    }
static long fibo(int a) {
array[1] = 1;
array[2] = 1;
	for(int i =3;i<=a;i++) {
		array[i] = array[i-1] + array[i-2];
	}
	return array[a];		
}
}