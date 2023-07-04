import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 1;
        int temp = 1;
        int room = 1;
        int n = Integer.valueOf(br.readLine());
        if (n == 1) {
            System.out.println(room);
        } else {
            while (n >= max) {
                    temp += 6 * room;
                    if (temp >= n) {
                        break;
                    } else max = temp;
                    room++;
            }
            System.out.println(room+1);
        }
    }
}