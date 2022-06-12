import java.io.*;
import java.util.*;
public class swea5643 {
    static int N,M;
    static int[][] graph;
    static boolean[][] floyd;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
    
            graph = new int[N+1][N+1];
            floyd = new boolean[N+1][N+1];
            
            for(int i = 0 ; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
    
                floyd[a][b] = true;
            }
            
            for(int i = 1 ; i <= N; i++){
                for(int j = 1 ; j <= N; j++){
                    for(int k = 1 ; k <= N; k++){
                        if(floyd[j][i] && floyd[i][k])
                            floyd[j][k] = true;
                    }
                }
            }  
    
            int[] cnt = new int[N+1];
            int ans = 0;
            for(int i = 1 ; i <= N; i++){
                for(int j = 1 ; j <= N; j++){
                    if(!floyd[i][j]) continue;
                    cnt[i]++;   cnt[j]++;
                    if(cnt[i] == N-1) ans++;
                    if(cnt[j] == N-1) ans++;
                }
            }    
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
