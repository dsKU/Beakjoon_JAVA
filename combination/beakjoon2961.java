package combination;
import java.io.*;
import java.util.*;

public class beakjoon2961 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int ans = 20_0000_0001;
    static void solve(int idx){
        
        if(idx == N){
            int cnt = 0;
            int a = 1;
            int b = 0;
            for(int i = 0 ; i < N; i++){
                if(visited[i]){
                    a *= arr[i][0];
                    b += arr[i][1];
                    cnt++;
                }
            }
            if(cnt == 0) return;
            ans = Math.min(Math.abs(a - b), ans);  
            return;
        }
        visited[idx] = true;
        solve(idx+1);
        visited[idx] = false;
        solve(idx+1);

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][2];
        visited = new boolean[N];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
             
        }

        solve(0);
        System.out.println(ans);
    }
}
