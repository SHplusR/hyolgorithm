
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        double sum = 0;

        for(int i=0;i<n; i++){
            int num = Integer.parseInt(br.readLine());
            ints[i] = num;
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(ints);

        //1. 산술평균
        for(int i : ints) {
            sum += i;
        }
        sb.append(Math.round(sum/n)).append("\n");

        //2. 중앙값
        sb.append(ints[ints.length/2]).append("\n");
        int max =0;
        //3.최빈값
        for(int i: hashMap.values()){
            if(max <i){
                max = i;
            }
        }
        for(int key : hashMap.keySet()){
            if(hashMap.get(key) == max){
                arrayList.add(key);
            }
        }
        Collections.sort(arrayList);
        if(arrayList.size()>1){
            sb.append(arrayList.get(1)).append("\n");
        }
        else{
            sb.append(arrayList.get(0)).append("\n");
        }

        //4.범위
        sb.append(Math.abs(ints[0]-ints[ints.length-1]));
        System.out.println(sb);
    }
}