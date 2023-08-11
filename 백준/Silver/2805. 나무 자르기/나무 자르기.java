import java.io.*;

public class Main {
    static int[] height; //트리 높이를 받는 arr
    static int n,m,max,resultmax;
    static long count;
    static int start,end;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        max = 0;
        height = new int[n];
        String[] treestrings = br.readLine().split(" ");
        for(int i =0; i<n; i++) {
            height[i] = Integer.parseInt(treestrings[i]); //트리 높이
        }
        for(int a : height) {
            if(max <a) {
                max = a;
            }
        }
        start =0;
        end = max;
        resultmax = -1;
        parametic(0, max);
        System.out.println(sb);
    }
    static void parametic(int s, int e) {
        if(s<=e) {
            long mid = (s+e)/2;
            docut(mid);
            if(m<=count) {
                resultmax = Math.max(resultmax,(int)mid);
                start = (int)(mid)+1;
                parametic(start,end);
            }
            else{
                end = (int)(mid)-1;
                parametic(start, end);
            }
        }
        else{
            sb.append(resultmax);
        }
    }

    static long docut(long mid){
        count = 0;
        for(int a : height) {
            if((a - mid)>0) {
                count += (a - mid);
            }
        }
        return count;
    }
}