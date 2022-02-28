package DP;
import java.io.*;
import java.util.*;
public class beakjoon2491 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int [][] dp = new int[N+1][2];
        int ans = 0;
        //0큰 거 1 작은 거
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i-1] == arr[i]){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            }
            else if(arr[i-1] > arr[i]){
                dp[i][1] = dp[i-1][1] + 1;
                dp[i][0] = 1;
            }
            else{
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = 1;
            }
            ans = Math.max(Math.max(dp[i][0], dp[i][1]), ans);
        }
        System.out.println(ans);
    }
}
