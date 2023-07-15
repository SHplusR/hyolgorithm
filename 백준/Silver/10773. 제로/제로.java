import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i =0; i<n; i++){
            int num= Integer.valueOf(br.readLine());
            if(num == 0){
                stack.pop();
            }
            else{
                stack.push(num);
            }
        }
        for(int a: stack){
            count += a;
        }
        System.out.println(count);
    }
}