import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    static int n;

    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        n= Integer.valueOf(strings[0]);
        int m = Integer.valueOf(strings[1]);
        int v = Integer.valueOf(strings[2]);
        arr = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i =0; i<m;i++){
           String[] pointsStr =  br.readLine().split(" ");
           int a = Integer.valueOf(pointsStr[0]);
           int b = Integer.valueOf(pointsStr[1]);
           arr[a][b] = arr[b][a] =1;
        }
        dfs(v);
        sb.append("\n");
        check = new boolean[n+1];
        bfs(v);
        System.out.println(sb);

    }
    public static void dfs(int v){
        check[v] = true;
        sb.append(v+" ");
        for(int i =1; i<=n;i++){
            if(arr[v][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        queue.offer(v);
        check[v] = true;
        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start+" ");
            for(int i =1; i<=n; i++){
                if(arr[start][i] == 1 && !check[i]){
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }

    }
}