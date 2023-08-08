//깃헙제출용!!!!!
import java.util.*;

import java.io.*;

public class Main {
	static int depth[]; // 깊이 배열
	static int parent[][]; // 부모를 알려주는 배열
	static ArrayList[] tree; // 입력값 받는 배열
	static StringBuilder sb;
	static int n, m, newk;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		n = Integer.valueOf(br.readLine());
		depth = new int[n + 1];
		tree = new ArrayList[n + 1];

		int k = 1;
		for (k = 1; k <= n; k *= 2);
		newk = baseLog((long)k, 2);
		parent = new int[newk + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>(); // tree 초기화
		}

		// 트리에 받은 값 넣기 .
		for (int i = 1; i < n; i++) {
			String[] strings = br.readLine().split(" ");
			int a = Integer.valueOf(strings[0]);
			int b = Integer.valueOf(strings[1]);
			// 양방향
			tree[a].add(b);
			tree[b].add(a);
		}

		dfs(1, 1);
		fillParent();

		m = Integer.valueOf(br.readLine()); // 값 입력받기

		for (int i = 1; i <= m; i++) {
			String[] strings = br.readLine().split(" ");
			int a = Integer.valueOf(strings[0]);
			int b = Integer.valueOf(strings[1]);
			sb.append(LCA(a, b) + "\n");
		}
		System.out.println(sb);
	}

	static int baseLog(double x, double base) {
		return (int) (Math.log10(x) / Math.log10(base));
	}

	// depth기록. 첫번째 부모 parent[0][v] 기록.

	static void dfs(int id, int cnt) {
		// depth를 기록
		depth[id] = cnt;
		// 자식들의 depth를 기록
		int len = tree[id].size();
		for (int i = 0; i < len; i++) {
			int next = (Integer) tree[id].get(i);
			if (depth[next] == 0) {
				dfs(next, cnt + 1);
				parent[0][next] = id; // 첫번째 부모를 기록
			}
		}
	}

	static void fillParent() {
		for (int i = 1; i<=newk; i++) {
			for (int j = 1; j<=n; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];     
			}
		}
	}

	static int LCA(int aid, int bid) {

		int diff = depth[aid] - depth[bid];

		if (diff < 0) {
			int tmp = aid;
			aid = bid;
			bid = tmp;
			diff = Math.abs(diff); // 절댓값으로 변환하기
		}
		
		// 같은 층으로 옮기기
		for (int i = newk; i >= 0; i--) {
			if (Math.pow(2, i) <= diff) {
				aid = parent[i][aid];
				diff = depth[aid] - depth[bid];
			}
		}

		if (aid == bid)
			return aid;

		for (int i = newk; i >= 0; i--) {
			if (parent[i][aid] != parent[i][bid]) {
				aid = parent[i][aid];
				bid = parent[i][bid];
			}
		}
		return parent[0][aid];

	}
}