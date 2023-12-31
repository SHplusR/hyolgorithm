import java.io.*;
import java.util.*;
class Main {
    static class worm{
        int wn,wm;
        public worm(int wn, int wm){
            this.wn = wn;
            this.wm = wm;
        }
    }
    static int[] dn,dm;
    static ArrayDeque<worm> wormQueue;
    static int n,m,k;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        dn = new int[] {-1,0,1,0};
        dm = new int[] {0,1,0,-1};
        wormQueue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tCase = Integer.parseInt(br.readLine());
        for(int i=0; i<tCase; i++){
            String[] strings = br.readLine().split(" ");
            m = Integer.parseInt(strings[0]);
            n = Integer.parseInt(strings[1]);
            k = Integer.parseInt(strings[2]);
            boolean[][] check = new boolean[n][m];
            int[][] map = new int[n][m];
            wormQueue = new ArrayDeque<>();
            for(int j=0; j<k; j++){
                String[] wormStrings = br.readLine().split(" ");
                int wormx = Integer.parseInt(wormStrings[0]);
                int wormy = Integer.parseInt(wormStrings[1]);
                map[wormy][wormx] = 1;
            }

            for(int wn=0; wn<n;wn++){
                for(int wm=0; wm<m; wm++){
                    if(map[wn][wm] == 1 && !check[wn][wm]){
                        wormQueue.offer(new worm(wn,wm));
                        check[wn][wm] = true;
                        bfs(check,map);
                    }
                }
            }
            sb.append(answer).append("\n");
            answer =0;
        }
        System.out.println(sb);
    }
    static void bfs(boolean[][] check, int[][] map){
        while(!wormQueue.isEmpty()){
            worm w = wormQueue.pop();
            for(int i=0; i<4;i++){
                int newn = w.wn+dn[i];
                int newm = w.wm+dm[i];
                if(newn<0 || newn>=n || newm<0 || newm>=m);
                else{
                    if(map[newn][newm] == 1 && !check[newn][newm]){
                        wormQueue.offer(new worm(newn,newm));
                        check[newn][newm] = true;
                    }
                }
            }
        }
        answer+=1;
    }
}