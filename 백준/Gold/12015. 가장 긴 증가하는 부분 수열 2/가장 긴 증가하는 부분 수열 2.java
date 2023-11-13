import java.io.*;

public class Main {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int idx, len = 0;
        lis = new int[n+1];
        String[] strings = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(strings[i]);
        }
        for(int i=0; i<n; i++){
            if(arr[i]> lis[len]){
                len +=1;
                lis[len] = arr[i];
            }
            else{
                idx = binarySearch(0,len,arr[i]);
                lis[idx] = arr[i];
            }
        }
        System.out.println(len);
    }
    static int binarySearch(int left, int right, int key) {
        int mid =0;
        while(left<right) {
            mid = (left+right)/2;
            if(lis[mid] < key) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return right;
    }
    }