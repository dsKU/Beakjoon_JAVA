import java.io.*;
import java.util.*;

public class swea1247 {
    static int ans;// = Integer.MAX_VALUE;
    static int N;
    static int[] company = new int[2];
    static int[] home = new int[2];
    static int[][] person;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t= 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            person = new int[N][2];
            boolean[] visited = new boolean[N];
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for(int i = 0 ; i < N ;i++){
                person[i][0] = Integer.parseInt(st.nextToken());
                person[i][1] = Integer.parseInt(st.nextToken());
            }
            
            solve(company, visited, 0, 0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void solve(int[] start, boolean[] visited, int dis, int cnt){
        if(dis > ans) return;
        
        if(cnt == N){
            int temp = distance(start, home) + dis;
            if(ans > temp) ans = temp;
            return;
        }

        for(int i = 0 ; i < N; i++){
            if(visited[i])continue;
            visited[i] = true;
            solve(person[i], visited, dis + distance(person[i], start), cnt+1);
            visited[i] = false;
        }

    }
    static int distance(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
