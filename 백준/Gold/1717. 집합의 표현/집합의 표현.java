import java.io.*;
public class Main {
	
static void init() {
	for(int i=0; i<=n;i++) {
		parent[i] =i;
	}
}

static void union(int a, int b) {
	int pa = find(a);
	int pb = find(b);
	parent[pa] = pb;
}

static int find(int id) {
	if(parent[id] == id) {
		return id;
	} 
	return parent[id] = find(parent[id]);
}

static int n;
static int m;
static int[] parent;
static StringBuilder sb;

public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] strnigs = br.readLine().split(" ");
		n = Integer.valueOf(strnigs[0]);
		m = Integer.valueOf(strnigs[1]);
		parent = new int[n+1];
		init();
		for(int i=0; i<m; i++) {
			String[] inputstr = br.readLine().split(" ");
			int input = Integer.valueOf(inputstr[0]);
			int a = Integer.valueOf(inputstr[1]);
			int b = Integer.valueOf(inputstr[2]);
			
			if(input == 0) {
				union(a, b);
			}
			else {
				if(find(a) == find(b)) {
					sb.append("YES"+"\n");
				}
				else {
					sb.append("NO"+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
