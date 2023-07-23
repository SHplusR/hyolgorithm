import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //c= c- dz= d- l nj s= z=
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; i++) {

            char ch = str.charAt(i);

            if(ch == 'c' && i < len - 1) {
                if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    count++;
                    i++;
                }
                else{
                    count++;
                }
            }

            else if(ch == 'd' && i < len - 1) {
                if(str.charAt(i + 1) == '-') {
                    count++;
                    i++;
                }
                else if(str.charAt(i + 1) == 'z' && i < len - 2) {
                    if(str.charAt(i + 2) == '=') {
                        count++;
                        i += 2;
                    }
                    else{
                        count++;
                    }
                }
                else{
                    count++;
                }
            }

            else if((ch == 'l' || ch == 'n') && i < len - 1) {
                if(str.charAt(i + 1) == 'j') {
                    count++;
                    i++;
                }
                else{
                    count++;
                }
            }

            else if((ch == 's' || ch == 'z') && i < len - 1) {
                if(str.charAt(i + 1) == '=') {
                    count++;
                    i++;
                }
                else{
                    count++;
                }
            }

            else{
                count++;
            }

        }

        System.out.println(count);
    }
}