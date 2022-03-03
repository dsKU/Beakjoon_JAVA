package BinarySearch;

import java.io.*;
import java.util.*;
public class beakjoon1072 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long rate = M*100/N;

        long left = 0;
        long right = N;
        long ans = 0;
        while(left <= right){
            long mid = (left + right) >> 1;
            long temp = (M + mid)*100 / (N + mid); 

            if(temp > rate){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
                
            }
        }
        if(ans == 0) System.out.println(-1);
        else System.out.println(ans);

    }
}
