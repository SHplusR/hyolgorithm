import java.io.*;

public class Main {

    static int n,m;
    static int[] ints;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[n+1];
        visit = new boolean[n+1];

        dfs(0);
        System.out.println(sb);

    }

    public static void dfs(int cnt) {
        if (cnt == m) {
            for(int i=1;i<=m;i++){
                sb.append(ints[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for (int i =1; i <=n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ints[cnt+1] = i;
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }
}