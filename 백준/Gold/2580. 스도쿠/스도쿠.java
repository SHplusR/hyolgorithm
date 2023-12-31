import java.io.*;
import java.util.*;

public class Main {
    static int[][] maps;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maps = new int[9][9];

        for(int i =0; i<9;i++){
            String[] strings= br.readLine().split(" ");
            for(int j =0; j<9; j++){
                maps[i][j] = Integer.valueOf(strings[j]); //스도쿠 넣기.
            }
        }
        sdoku(0,0);
    }
    public static void sdoku(int r, int c){
        //만약 한 행을 다 하면 다음 행으로 이동.
        if(c == 9){
            sdoku(r+1,0);
            return;
        }
        //모든 행을 다 한 경우
        if(r == 9){
            sb = new StringBuilder();
            for(int i =0; i<9; i++){
                for(int j =0; j<9; j++){
                    sb.append(maps[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        //만약 0(값 비어있음)일 경우
        if(maps[r][c] == 0){
            for(int i =1; i<=9; i++){
                if(possible(r,c,i)){
                    maps[r][c] = i;
                    sdoku(r,c+1);
                }
            }
            maps[r][c] = 0;
            return;
        }
        sdoku(r,c+1);
    }

    static boolean possible(int r, int c, int check){

        //같은행에서 값 판단 (수평)
       for(int i =0; i<9; i++){
           if(maps[r][i] == check){
               return false;
           }
       }
       //같은열에서 값 판단(수직)
        for(int i =0; i<9; i++){
            if(maps[i][c] == check){
                return false;
            }
        }
        //3*3에서 값 판단
        int newr = (r/3) * 3;
        int newc = (c/3) *3;
        for(int i =newr; i<newr+3; i++){
            for(int j =newc; j<newc+3; j++){
                if(maps[i][j]== check){
                    return false;
                }
            }
        }
        //값이 같지 않은 경우 true반환
        return true;
    }
}