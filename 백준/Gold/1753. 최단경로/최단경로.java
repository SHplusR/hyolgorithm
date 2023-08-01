import java.util.*;
import java.io.*;


public class Main {

	static class Edge implements Comparable<Edge> {
		int startid, targetid, cost;

		public Edge(int targetid, int cost) {
			this.targetid = targetid;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		StringBuilder sb = new StringBuilder();
		String[] strings = br.readLine().split(" ");
	
		int v = Integer.valueOf(strings[0]);
		int e = Integer.valueOf(strings[1]);
		
		int[] dist = new int[v + 1];
		ArrayList[] adjlist = new ArrayList[v + 1];
		int INF = Integer.MAX_VALUE;
		int startid = Integer.valueOf(br.readLine());

		for (int i = 1; i <= v; i++) {
			adjlist[i] = new ArrayList<Edge>();
		}

		for (int i = 1; i <=e; i++) {
			String[] inputstr = br.readLine().split(" ");
			int start = Integer.valueOf(inputstr[0]);
			int target = Integer.valueOf(inputstr[1]);
			int cost = Integer.valueOf(inputstr[2]);
			adjlist[start].add(new Edge(target, cost));
		}
		// 최댓값 초기화
		for (int i = 1; i <= v; i++) {
			dist[i] = INF;
		}
		dist[startid] = 0;
		pq.add(new Edge(startid, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (now.cost > dist[now.targetid]) //누적비용이 더 클 시
				continue;
			int len = adjlist[now.targetid].size();
			for (int i = 0; i < len; i++) {
				Edge next = (Edge)adjlist[now.targetid].get(i);
				if (dist[next.targetid] > now.cost + next.cost) {
					dist[next.targetid] = now.cost + next.cost;
					pq.add(new Edge(next.targetid, dist[next.targetid]));
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			if (dist[i] != INF) {
				sb.append(dist[i]);
			} else {
				sb.append("INF");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
