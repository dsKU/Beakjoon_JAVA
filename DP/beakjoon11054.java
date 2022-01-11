
import java.io.*;
import java.util.*;

public class beakjoon11054 {
    static int N;
    static int[] arr;
    static int[][] DP;
    static int[] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        DP = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i][0] = 1;
            DP[i][1] = 1;
        }
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    DP[i][0] = Math.max(DP[i][0], DP[j][0] + 1);
                }
                int a = N - i - 1;
                int b = N - j - 1;
                if(arr[a] > arr[b]){
                    DP[a][1] = Math.max(DP[a][1], DP[b][1] + 1);
                }
            }
        }
        int max_ = 0;
        for(int i = 0 ; i < N; i++){
            max_ = Math.max(max_, DP[i][0] + DP[i][1] -1);
        }


        System.out.println(max_);
        
        

    }
}
