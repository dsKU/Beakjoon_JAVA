package DP;
import java.io.*;
import java.util.*;

public class beakjoon20667 {
    static int N, M, K;
    static int[] cpu;
    static int[] memory;
    static int[] priority;
    static int[][] DP;
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   //cpu목표
        K = Integer.parseInt(st.nextToken());   //메모리목표

        int cpuMax = 1000;
        int prioMax = 500;
        cpu = new int[N+1];
        memory = new int[N+1];
        priority = new int[N+1];
        DP = new int[prioMax+1][cpuMax+2];
        //N ≤ 100, M ≤ 1,000, K ≤ 100,000
        //따라서 K가 0이 올 수도 있어서 초기화 안 해주면 입구컷나는 것 같음
        for(int i = 0 ; i <= prioMax; i++)
        Arrays.fill(DP[i], -987654321);

        for(int i = 1 ; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cpu[i] = a;
            memory[i] = b;
            priority[i] = c;
        }

        for(int k = 1 ; k <= N; k++){
            for(int i = prioMax; i >= 0; i--){
                for(int j = cpuMax + 1; j >= 0; j--){
                    if( i + priority[k] > prioMax) continue;

                    if(j + cpu[k] <= cpuMax)
                        DP[i + priority[k]][j + cpu[k]] = Math.max( DP[i + priority[k]][j + cpu[k]], DP[i][j] + memory[k]);

                    if(j + cpu[k] > cpuMax) // 슬라이싱 윈도우
                        DP[i + priority[k]][cpuMax + 1] = Math.max( DP[i + priority[k]][cpuMax + 1], DP[i][j] + memory[k]);
                }
            }
        }

        int ans = -1;
        for(int i = 0; i <= prioMax; i++){
            for(int j = M; j <= cpuMax + 1; j++){
                if(DP[i][j] >= K){
                    if (ans == -1 || ans > i){
                        ans = i;
                    }
                }
            }
        }
        System.out.println(ans);
        

    }
}
