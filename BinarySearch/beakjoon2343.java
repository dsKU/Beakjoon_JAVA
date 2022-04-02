package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon2343 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        long sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }

        long left = max;
        long right = sum;
        long ans = 0;
        while(left <= right){
            long mid = (left + right) >> 1;
        
            int cnt = 1;
            long temp = mid;
            for (int i = 0; i < N; i++) {
                
                if(arr[i] > temp){
                    cnt++;
                    temp = mid;
                }
                temp -= arr[i];
            }

            if(cnt <= M){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
