import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int line;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb;

    static int count;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine()); //7
        check = new boolean[n+1];
        line = Integer.valueOf(br.readLine()); //6
        arr = new int[line][2];
        sb = new StringBuilder();
        count = 0;
        Arrays.fill(check,false);
        queue = new LinkedList<>();
        for(int i =0; i<line; i++){
            String[] strings = br.readLine().split(" ");
             arr[i][0] = Integer.valueOf(strings[0]);
             arr[i][1] = Integer.valueOf(strings[1]);
        }
        bfs(1);
        System.out.println(sb);
    }
    public static void bfs(int v){
        queue.offer(v);
        check[v] = true;
        while(!queue.isEmpty()){
            int start = queue.poll();
            count++;
            for(int i =0; i<line; i++){
                if((arr[i][1] == start && !check[arr[i][0]]) || (arr[i][0] == start && !check[arr[i][1]])){
                    if(arr[i][1] == start){
                        queue.offer(arr[i][0]);
                        check[arr[i][0]] = true;
                    }
                    else{
                        queue.offer(arr[i][1]);
                        check[arr[i][1]] = true;
                    }
                }
            };
        }
        sb.append(count-1);
    }
}