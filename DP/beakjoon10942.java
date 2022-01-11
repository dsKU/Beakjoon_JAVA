package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[][] DP = new boolean[N+1][N+1];

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i][i] = true;
            
            if(arr[i] == arr[i-1]){
                DP[i-1][i] = true;
            }
        }
        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                if(DP[j+1][j+i-1] && arr[j] == arr[i+j]){
                    DP[j][i+j] = true;
                }
            }
           
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(DP[a][b]){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
