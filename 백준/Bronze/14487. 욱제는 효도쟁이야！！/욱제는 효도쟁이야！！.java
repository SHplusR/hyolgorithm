import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        String[] strings = br.readLine().split(" ");
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(strings[i]);
            ints.add(value);
        }
        Collections.sort(ints,Collections.reverseOrder());
        for(int i=1; i<ints.size(); i++){
            sum += ints.get(i);
        }
        System.out.println(sum);
    }
}