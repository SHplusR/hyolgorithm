import java.io.*;
import java.util.*;

public class Main {

    static class location{
        public int ln;
        public int lm;

        public int ans;

        location(int ln, int lm){
            this.ln =ln;
            this.lm =lm;
        }
    }
    static int n,m;
    static int[][] maps;
    static boolean[][] check;

    static int[] nd = {-1,0,1,0};
    static int[] md = {0,-1,0,1};
    static StringBuilder sb;

    static Queue<location> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();
        String[]strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        maps = new int[n+1][m+1];
        check = new boolean[n+1][m+1];
        queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            String input = br.readLine();
            for(int j=1;j<=m;j++){
                maps[i][j] =input.charAt(j-1) - '0';
            }
        }
        queue.add(new location(1,1));
        check[1][1] = true;
        bfs(1,1);
        System.out.println(maps[n][m]);
    }

    static void bfs(int a, int b){
        while(!queue.isEmpty()){
            location cur = queue.poll();
            for(int i=0; i<4;i++){
                int newn  = cur.ln + nd[i];
                int newm  = cur.lm + md[i];
                if(newn>0 && newn<=n && newm>0 && newm<=m && !check[newn][newm]){
                    check[newn][newm] = true;
                    if(maps[newn][newm] == 1){
                            queue.add(new location(newn,newm));
                            maps[newn][newm] = maps[cur.ln][cur.lm]+1;
                    }
                    else continue;
                }
                else continue;
            }
        }

    }
    }