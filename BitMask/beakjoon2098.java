package BitMask;
import java.io.*;
import java.util.*;

public class beakjoon2098 {
    static int N;
    static int[][] map;
    static int[][] DP;

    static int solve(int idx, int visit){
        if(DP[idx][visit] != -1) return DP[idx][visit];
        
        if(visit == (1<<N)-1){
            if(map[idx][0] == 0) return 16_000_001;
            return map[idx][0];
        }
        DP[idx][visit] = 16_000_001;

        for(int i = 0 ; i < N; i ++){
            if(map[idx][i] != 0 && (visit & (1 << i)) == 0){
                DP[idx][visit] = Math.min(DP[idx][visit] , solve(i, visit | (1 << i)) + map[idx][i]);
            }
        }

        return DP[idx][visit];
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        DP = new int[N][1<<N];
        for(int i = 0 ; i < N; i++){
            Arrays.fill(DP[i], -1);
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solve(0, 1));

    }
}
