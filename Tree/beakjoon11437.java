import java.io.*;
import java.util.*;

public class beakjoon11437 {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static int[] depth;

    static void init_depth(int node, int parent){
        parents[node] = parent;
        depth[node] = depth[parent] + 1;

        for(int idx : tree[node]){
            if(idx == parent) continue;
            
            init_depth(idx, node);
        }
    }
    static int searchLCA(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a;            a = b;            b = temp;
        }
        while(depth[a] != depth[b]) a = parents[a];

        while(a != b){
            a = parents[a];
            b = parents[b];
        }

        return a;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        parents = new int[N+1];
        depth = new int[N+1];
        for(int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        init_depth(1, 0);


        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(searchLCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }
}
