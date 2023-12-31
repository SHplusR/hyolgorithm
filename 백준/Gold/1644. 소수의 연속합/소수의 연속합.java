import java.util.*;
import java.io.*;
public class Main {
    static boolean[] primnnum;
    static int n;

    static ArrayList<Integer> pnumarr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        primnnum = new boolean[n + 1];
        findPrimeNum(n);
        sumPrimeNum(n);

    }

    static ArrayList<Integer> findPrimeNum(int n) {
        primnnum[0] = primnnum[1] = true;
        pnumarr = new ArrayList<Integer>();
        for (int i = 2; i * i <= n; i++) {
            if (!primnnum[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primnnum[j] = true;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (primnnum[i] == false) {
                pnumarr.add(i);
            }
        }
        return pnumarr;
    }

    static void sumPrimeNum(int n) {
        int cnt = 0;
        int st = 0;
        int et = 1;
        int sum = 2;
        while(true) {
            if(pnumarr.isEmpty()){
                break;
            }
            else{
                if (sum == n)
                    cnt++;
                if(sum < n) {
                    if(et >= pnumarr.size())  break;
                    sum += pnumarr.get(et);
                    et++;
                } else {
                    sum -= pnumarr.get(st);
                    st++;
                }
            }
        }
        System.out.println(cnt);
    }
}