import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> queue;
    static Boolean []check;
    static int[] days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        queue = new LinkedList<>();
        check = new Boolean[100001];
        Arrays.fill(check, false);
        days = new int[100001];
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        bfs(n,k);
    }

    public static void bfs(int n, int k){
        queue.add(n);
        while(!queue.isEmpty()){
            int start = queue.poll();
            if(start == k && !check[start]){
                System.out.println(days[start]);
                return;
            }
            else if(!check[start]){
                loc(start);
                check[start] = true;
            }
            else;
        }
    }
    public static void loc(int start){
        if(start+1 <= 100000) {
            if(!check[start+1]){
                queue.offer(start+1);
                if(days[start+1]==0){
                    days[start+1]= days[start]+1;
                }
}
        }
        if(start-1 >= 0) {
            if(!check[start-1]){
                queue.offer(start-1);
                if(days[start-1]==0){
                    days[start-1]= days[start]+1;
                }
            }
        }
        if(start*2 <= 100000) {
            if(!check[start*2]){
                queue.offer(start*2);
                if(days[start*2]==0){
                    days[start*2]= days[start]+1;
                }
            }
        }
    }
}