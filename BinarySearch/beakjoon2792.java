package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon2792 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;
        while(left <= right){
            long mid = (left + right) >> 1;
            
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                cnt += (arr[i] / mid);
                if(arr[i] % mid != 0) cnt++;
            }

            if(cnt <= N){
                right = mid - 1;
                ans = mid;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
