import java.util.*;
import java.io.*;
public class Main{
    static class idx {
        public int id;
        public int val;
        idx(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<idx>dequeue = new ArrayDeque();

        //썼으니까 다시 만들기
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            //dequeue가 비어있지 않으며 dequeue의 마지막 값이 새로 들어올 값보다 클 때
            if(!dequeue.isEmpty()&& dequeue.getFirst().id < i-l+1){
                dequeue.removeFirst();
            }
            while(!dequeue.isEmpty() && dequeue.getLast().val >= temp){
                dequeue.removeLast(); //마지막 원소 삭제
            }
            dequeue.addLast(new idx(i,temp));
            bw.write(dequeue.getFirst().val+" ");
        }
        bw.flush();
        bw.close();
    }
}
