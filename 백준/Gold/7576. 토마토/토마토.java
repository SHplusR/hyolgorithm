import java.io.*;
import java.util.*;

public class Main {

    static class location {
        public int tn;
        public int tm;

        location(int tn, int tm) {
            this.tn = tn;
            this.tm = tm;
        }
    }

    static int[] nd = {-1, 0, 1, 0};
    static int[] md = {0, -1, 0, 1};
    static Queue<location> queue;
    static int[][] maps;
    static boolean[][] visit;
    static int zt, mt, day = 0;
    static int n, m;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        queue = new LinkedList<>();
        m = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        v = -1;
        maps = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputT = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(inputT[j]);
                if (Integer.parseInt(inputT[j]) == 1) {
                    queue.add(new location(i, j));
                } else if (Integer.parseInt(inputT[j]) == 0) {
                    zt++;
                } else {
                    mt++;
                }
            }
        }
        if ((n * m) == (queue.size() + mt)) {
            System.out.println(0);
        } else if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            location lc = queue.peek();
            visit[lc.tn][lc.tm] = true;
            bfs();
            System.out.println(findday());
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            location lc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = lc.tn + nd[i];
                int b = lc.tm + md[i];
                if (a >= 0 && a < n && b >= 0 && b < m) {
                    if (!visit[a][b]) {
                        visit[a][b] = true;
                        if (maps[a][b] == 0) {
                            queue.add(new location(a, b));
                            maps[a][b] = maps[lc.tn][lc.tm] + 1;
                        }
                    }
                } else continue;
            }
        }
    }

    static int findday() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(maps[i][j] == 0){
                    return -1;
                }
                else{
                    v = Math.max(v,maps[i][j]);
                }
            }
        }
        return v-1;
    }
}
