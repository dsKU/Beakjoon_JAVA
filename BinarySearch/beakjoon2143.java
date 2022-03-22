package BinarySearch;

import java.io.*;
import java.util.*;

public class beakjoon2143 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());


        ArrayList<Long> listA = new ArrayList<>();
        int[] arr1 = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            arr1[i] = Integer.parseInt(st.nextToken()) + arr1[i-1];
            for(int j = 0 ; j < i ; j++){
                listA.add((long)(arr1[i] - arr1[j]));
            }
            
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M+1];
        ArrayList<Long> listB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M; i++){
            arr2[i] = Integer.parseInt(st.nextToken()) + arr2[i-1];
            for(int j = 0 ; j < i ; j++){
                listB.add((long)(arr2[i] - arr2[j]));
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int left = 0;
        int right = listB.size()-1;

        long ans = 0;
        int left_len = listA.size();
        while(left < left_len && right >= 0){
            long a = listA.get(left);
            long b = listB.get(right);

            long sum = a+b;
            if(sum == T) {
                long lcnt = 0;
                while(left < left_len && listA.get(left) == a){
                    lcnt++;
                    left++;
                }
                long rcnt = 0;
                while(right >= 0 && listB.get(right) == b){
                    rcnt++;
                    right--;
                }
                ans += lcnt*rcnt;
            }
            else if(sum > T) right--;
            else if(sum < T) left++;
        }

        System.out.println(ans);



    }
}
