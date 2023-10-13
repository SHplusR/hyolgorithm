import java.io.*;
import java.util.*;
class Main {
    static class lecture implements Comparable<lecture>{
        int start, end;
        public lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(lecture o) {
            if(this.start == o.start){
                return this.end - o.end;
            }
            else{
                return this.start-o.start;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque <lecture> lecDeque = new ArrayDeque<>();
        ArrayList<lecture> lectures = new ArrayList<>(n);
        PriorityQueue<Integer> lecPq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            String[] strings = br.readLine().split(" ");
            int start = Integer.parseInt(strings[0]);
            int end = Integer.parseInt(strings[1]);
            lectures.add(new lecture(start,end));
        }
        Collections.sort(lectures);
        lecPq.offer(lectures.get(0).end);

        for(int i=1; i<n; i++){
           if( lecPq.peek() <=lectures.get(i).start){
               lecPq.poll();
           }
           lecPq.offer(lectures.get(i).end);
        }
        System.out.println(lecPq.size());

    }
}
