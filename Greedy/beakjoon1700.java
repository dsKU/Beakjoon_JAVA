package Greedy;
import java.io.*;
import java.util.*;

public class beakjoon1700 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] val = new int[M+1][2];
        int[] idx = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(idx[temp] == 0){
                idx[temp] = i;
            }
            else{
                val[idx[temp]][1] = i - idx[temp];
                idx[temp] = i;
            }
            val[i][0] = temp;
        }
        for(int i = 1 ; i <= M; i++){
            int temp = idx[val[i][0]];
            if(temp != 0) val[temp][1] = M - temp + 1;
            
        }

        ArrayList<Integer> list = new ArrayList<>();

        int ans = 0;
        Integer max_ = 0;   //저장된 오브젝트 값을 삭제해야 하기 때문에 Integer형
        for(int i = 1; i <= M; i++){
            for(int j = 0; j < list.size();j++){
                int temp = list.get(j)-1;
                if(temp <= 0){
                    list.remove(j);
                    j--;
                }
                else list.set(j, list.get(j)-1);
                max_ = temp > max_ ? temp : max_;
            }
            
            if(list.size() >= N){
                list.remove(max_);
                ans++;
            }

            list.add(val[i][1]);
            max_ = 0;
            
        }
        System.out.println(ans);

    }
}

/*
System.out.print(i+": ");
            for(int j : list){
                System.out.print(j + " ");
            }
            System.out.println();
*/