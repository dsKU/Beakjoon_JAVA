import java.io.*;
import java.util.*;


public class swea7645 {
    static int[] parent;
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x1, int x2){
        int p1 = find(x1);
        int p2 = find(x2);
        if(p1 == p2) return;
        if(p2 > p1) parent[p2] = p1;
        else parent[p1] = p2;

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for(int i = 1; i <= N; i++) parent[i] = i;
            for(int i = 0 ; i < M ;i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
                
            }

            boolean visited[] = new boolean[N+1];
            int ans = 0;
            for(int i = 1; i <= N; i++){
                int pa = find(parent[i]);
                if(!visited[pa]){
                    visited[pa] = true;
                    ans++;
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
