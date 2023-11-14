import java.io.*;

public class Main {
    static int[] lis;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       int[] arr = new int[n];
       lis = new int[n+1];
       int len =0;
       String[] strings =  br.readLine().split(" ");
       for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(strings[i]);
       }
       for(int i=0; i<=n; i++){
        lis[i] = Integer.MIN_VALUE;
       }
       for(int i=0; i<n; i++){
           if(arr[i] > lis[len]){
               len+=1;
               lis[len] = arr[i];
           }
           else{
               //갱신
               int idx = binarySearch(0,len,arr[i]);
               lis[idx] = arr[i];
           }
       }
        System.out.println(len);
    }
    static int binarySearch(int low, int high, int key){
        int mid =0;
        while(low < high){
            mid = (low+high)/2;
            if(lis[mid] < key){
                low = mid+1;
            } else{
                //lis[mid] >= key
                high = mid;
            }
        }
        return high;
    }
}