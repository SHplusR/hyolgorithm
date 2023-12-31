// 1. s,e는 같은 0번쨰에 시작한다. 
// 2. 시작 - 끝 거리를 왼방향/ 오방향 중 더 짧은걸로 더한다. 그리고 해당 인덱스 값을 더한다. 
// 3. s를 뒤로 보낸다. 
// 4. 2~3 과정을 s가 끝까지 갈때까지 버팀.

class Solution {
    
    static int solution(String name) {
        int answer = 0;
        int[] nameList = new int[name.length()];
        int length = name.length();
        int movement = length-1;
        for(int i=0;i<length;i++){
                if((int)name.charAt(i)>78){
                    nameList[i] = (Math.abs((int)name.charAt(i)-90)+1);
                }
                else{
                    nameList[i] = (int)name.charAt(i)-65;
                }
                answer +=  nameList[i];
            }

            for(int i = 0; i < length; i++){
                int idx = i+1;
                // 연속되는 A 갯수 확인
                while(idx < length && nameList[idx] == 0){
                    idx++;
                }
                movement = Math.min(movement, i * 2 + (length - idx));
                movement = Math.min(movement, i + (length - idx) * 2);
            }
            return answer+movement;
        }
}