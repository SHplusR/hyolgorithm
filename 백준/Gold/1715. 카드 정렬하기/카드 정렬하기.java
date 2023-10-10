import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> numbers = new PriorityQueue<>(n);
        Long answer = 0L;
        for(int i=0; i<n; i++){
            Long num = Long.parseLong(br.readLine());
            numbers.add(num);
        }
        while(!numbers.isEmpty()) {
            Long temp = 0L;
            int length = numbers.size();
            if (length == 1) {
                break;
            } else {
                for (int i = 0; i < 2; i++) {
                    temp += numbers.poll();
                }
                answer += temp;
                numbers.add(temp);
            }
        }
        System.out.println(answer);
    }
}