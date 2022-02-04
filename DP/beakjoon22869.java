package DP;
import java.io.*;
import java.util.*;

public class beakjoon22869 {
    static int N, M;
    static int[] val;
    static int[] DP;
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        val = new int[N];
        DP = new int[N];
        Arrays.fill(DP, -1);
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        
        DP[0] = 1;
        for(int i = 0; i < N; i++){
            if(DP[i] != 1) continue;
            for(int j = i + 1; j < N; j++){
                if(DP[j] == -1){
                    if((j - i) * (1 + Math.abs(val[i] - val[j])) <= M){
                        DP[j] = 1;
                    }
                }
            }
            if(DP[N-1] == 1) break;
        }



        if(DP[N-1] == 1) System.out.println("YES");
        else System.out.println("NO");

    }
}
