package BitMask;
import java.io.*;
import java.util.*;

public class beakjoon3056 {
    static int N;
    static double[][] cost;
    static double[] DP;       

    static double solve(int idx, int complete){
        if(idx == N) return 1;

        if(DP[complete] != -1) return DP[complete];

        DP[complete] = 0;
        
        for(int i = 0; i < N; i++){
            if((complete & (1<<i)) == 0){
                int temp = complete | (1<<i);
                DP[complete] = Math.max(DP[complete],solve(idx+1, temp)*cost[idx][i]);
            } 
        }

        return DP[complete];
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cost = new double[N][N];
        DP = new double[ 1 << N ];    // DP는 미션을 수행한 것
        Arrays.fill(DP, -1);

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                cost[i][j] = Double.parseDouble(st.nextToken())/100;
            }
        }
        

        System.out.println(solve(0, 0)*100);
    }
}
