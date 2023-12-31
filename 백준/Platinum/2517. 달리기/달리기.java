import java.io.*;
import java.util.*;

public class Main {
    static class runner implements Comparable<runner> {
        int rank;
        int speed;
        public runner(int rank, int speed){
            this.rank = rank;
            this.speed =speed;
        }
        //내림차순. 15 10 9 ...
        @Override
        public int compareTo(runner r) {
            return r.speed-this.speed;
        }
    }
    static int n,offset;
    static int[] value; //최종 값
    static runner[] runners;
    static int[] idxtree;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        runners = new runner[n];
        value = new int[n];
        for(int i=0;i<n;i++){
            runners[i] = new runner(i,Integer.parseInt(br.readLine()));
        }
        for(offset=1;offset<n;offset*=2);
        idxtree = new int[offset*2+2];
        Arrays.sort(runners);//내림차순 정렬 완
        for(int i=0;i<n;i++){
            runner r = runners[i];
            getTree(r);
        }
        for(int i=0; i<n;i++){
            sb.append(value[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void getTree(runner r){
        int idx = r.rank+offset;
        idxtree[idx] = 1;
        int a  = idx;
        while(a>=1){
            a /= 2;
            idxtree[a] = idxtree[a*2]+idxtree[a*2+1];
        }
        getRank(idx);
    }
    public static void getRank(int idx){
        int l = offset;
        int r = idx;
        int answer =0;
        while(l<=r){
            //홀수
            if((l&1)== 1){
                answer += idxtree[l++];
            }
            //짝수
            if((r&1) == 0){
                answer += idxtree[r--];
            }
            l /= 2;
            r /= 2;
        }
        value[idx-offset] = answer;
    }
}