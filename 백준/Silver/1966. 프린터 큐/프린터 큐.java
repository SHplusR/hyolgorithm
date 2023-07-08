import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());	// 테스트 케이스
       
        while (testcase-- > 0) {

            String[] strings =  br.readLine().split(" ");

            int N = Integer.valueOf(strings[0]); //n
            int M = Integer.valueOf(strings[1]); //m

            LinkedList<int[]> qList = new LinkedList<>(); //큐로 사용할 연결리스트

            String[] qStrings =  br.readLine().split(" "); //중요도

            for (int i = 0; i < N; i++) {
                qList.offer(new int[] { i, Integer.valueOf(qStrings[i])}); //qlist에 i와 중요도 offer
            }

            int count = 0;	// 출력횟수

            while (!qList.isEmpty()) {	// 한 케이스에 대한 반복문

                int[] front = qList.poll();	// 가장 처음 원소를 삭제 및 반환하여 1차 int배열 front에 넣기
                boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 boolean

                for(int i = 0; i < qList.size(); i++) {
                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    if(front[1] < qList.get(i)[1]) {
                        // 이전에 삭제했던 처음 원소인 front를 다시 넣기
                        qList.offer(front);
                        //i가 될때까지 원소들 삭제 및 뒤로 보내기 반복
                        for(int j = 0; j < i; j++) {
                            qList.offer(qList.poll());
                        }
                        // 첫번째 원소가 (front) 제일 큰 값이 아니었으므로 ismax에 false를 주고 반복문 빠져나가 L50 실행
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(isMax == false) {
                    continue;
                }

                // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
                count++;
                if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}