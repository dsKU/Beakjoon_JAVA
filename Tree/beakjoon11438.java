package Tree;
import java.io.*;
import java.util.*;

public class beakjoon11438 {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[][] parents;
    static int[] depth;
    static int MAX_DEPTH = (int)Math.ceil(Math.log(100_001)/Math.log(2));
    static void init_depth(int node, int parent){
        parents[node][0] = parent;
        depth[node] = depth[parent] + 1;

        for(int i = 1 ; i <= MAX_DEPTH; i++){
            parents[node][i] = parents[parents[node][i-1]][i-1];
        }

        for(int idx : tree[node]){
            if(idx == parent) continue;
            
            init_depth(idx, node);
        }
    }
    static int searchLCA(int a, int b){
        if(a == 1 || b == 1 ) return 1;

        if(depth[a] < depth[b]){    //a의 깊이가 높음
            int temp = a;            a = b;            b = temp;
        }
        
        
        for(int i = MAX_DEPTH; i >= 0; i--){   
            if(depth[parents[a][i]] >= depth[b]){
                a = parents[a][i];
            }
        }    

        int result = a;
        if(a != b){
            for(int i = MAX_DEPTH; i >= 0; i--){    
                if(parents[a][i] != parents[b][i]){
                    a = parents[a][i];
                    b = parents[b][i];
                }
                result = parents[a][i];
            }
        }
        
        return result;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        parents = new int[N+1][MAX_DEPTH+1];
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
        System.out.print(sb);
    }
}
