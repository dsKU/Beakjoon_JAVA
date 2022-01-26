package Tree;
import java.io.*;
import java.util.*;

public class beakjoon1949 {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean visited[];
    static int[][] DP;
    static int[] val;
    static int solve(int node, int visited, int parent){
        
        if(DP[node][visited] != -1) return DP[node][visited];
        int ret = 0;

        for(int idx : tree[node]){
            if(parent == idx) continue;
            if(visited == 0){
                ret +=  Math.max(solve(idx, 0, node), solve(idx,1,node) + val[idx]);
            }
            else{
                ret +=  solve(idx, 0,node);
            }
        }

        return DP[node][visited] = ret;
    }



    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+2];
        DP = new int[N+1][2];
        val = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
            val[i] = Integer.parseInt(st.nextToken());
            DP[i][0] = -1;
            DP[i][1] = -1;
        }
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        if(N==1){
            System.out.println(val[1]);
            return;
        }
        System.out.println(Math.max(solve(1, 0, 0),solve(1, 1, 0)+val[1]));

    }
}
