import java.io.*;
import java.util.*;
public class swea4012 {
    static int N;
    static int[][] arr;
    static boolean[] select;
    static int limit;
    static int ans;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t= 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());    
            limit = N/2;
            arr = new int[N][N];
            select = new boolean[N];
            ans = Integer.MAX_VALUE;
        
            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N; j++){
                    arr[i][j] += Integer.parseInt(st.nextToken());
                    arr[j][i] += arr[i][j];
                }
            }

            solve(0, 0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");

        }//end case
        System.out.print(sb);
    }
    static void solve(int cnt, int idx){
        
        if(cnt == limit){
            int temp = 0;
            int temp2 = 0;
            for(int i = 0 ; i < N; i++){
                for(int j = 0; j < i; j ++){
                    if(select[i] && select[j]){
                        temp += arr[i][j];
                    }
                    else if(!select[i] && !select[j]){
                        temp2 += arr[i][j];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(temp - temp2));
            return;
        }
        if(idx == N) return;

        select[idx] = true;
        solve(cnt+1, idx+1);
        select[idx] = false;
        solve(cnt, idx+1);


    }
}
