import java.io.*;
import java.util.*;

public class Main {

	static int infinite = 200000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		int[][] dist = new int[n + 1][n + 1];
		
		//최댓값으로 초기화
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dist[i][j] = infinite;
			}
		}
	
		for (int i = 0; i < m; i++) {
			String[] strings = br.readLine().split(" ");
			int start = Integer.valueOf(strings[0]);
			int end = Integer.valueOf(strings[1]);
			dist[start][end] = Math.min(dist[start][end], Integer.valueOf(strings[2]));
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// (출발 -도착) 와 (출발- 경유 + 경유 - 도착) 중 더 작은 값.
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) {
					sb.append("0" + " ");
				}
				else if(dist[i][j] == infinite) {
					sb.append("0" + " ");
				}
				else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}