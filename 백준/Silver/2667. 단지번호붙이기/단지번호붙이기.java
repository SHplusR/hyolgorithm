import java.io.*;
import java.util.*;
class Main {
    static class home{
        int x,y;
        public home(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[][] map;
    static boolean[][] check;
    static ArrayDeque<home> homeQueue;
    static ArrayList<Integer> homeList;
    static int[] dx, dy;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n][n];
        homeQueue = new ArrayDeque<>();
        homeList = new ArrayList<>();
        dx = new int[] {-1,0,1,0};
        dy = new int[] {0,1,0,-1};
        answer =0;

        for(int i=0; i<n; i++){
            String strings = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = (int)(strings.charAt(j)-48);
            }
        }

        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !check[i][j]){
                    homeQueue.add(new home(i,j));
                    check[i][j] = true;
                    bfs();
                }
            }
        }
        sb.append(answer).append("\n");
        Collections.sort(homeList);
        for(int a : homeList){
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(){
        int hcount =1;
        while(!homeQueue.isEmpty()){
            home h = homeQueue.poll();
            for(int i=0; i<4; i++){
                int newx = h.x+dx[i];
                int newy = h.y+dy[i];
                if(newx<0 || newx >=n || newy<0 || newy>=n);
                else{
                    if(!check[newx][newy] && map[newx][newy] == 1){
                        homeQueue.add(new home(newx,newy));
                        check[newx][newy] = true;
                        hcount +=1;
                    }
                }
            }
        }
        homeList.add(hcount);
        answer+=1;
    }
}