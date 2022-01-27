import java.io.*;
import java.util.*;

public class beakjoon1761 {
    static int N, M;
    static ArrayList<Node1761>[] tree;
    static int[][] parents;
    static int[] depth;
    static int[] dist;
    static int MAX_DEPTH = (int) Math.ceil(Math.log(40_001) / Math.log(2));

    static void init_dist(int node, int parent, int d) {
        depth[node] = depth[parent] + 1;
        parents[node][0] = parent;
        dist[node] = d;
        //
        for(int i = 1; i <=MAX_DEPTH; i++)
            parents[node][i] = parents[parents[node][i-1]][i-1];

        for (Node1761 idx : tree[node]) {
            if (idx.child == parent) continue;
                init_dist(idx.child, node, d + idx.dist);
            
        }

    }
    static int searchLCA(int a,int b){
        if(a == 1 || b == 1) return 1;

        if(depth[a] < depth[b]){
            int temp = a;  a = b;  b = temp;
        }

        for(int i = MAX_DEPTH; i >= 0; i--){   
            if(depth[parents[a][i]] >= depth[b]){
                a = parents[a][i];
            }
        }    

        if(a != b){
            for(int i = MAX_DEPTH; i >= 0; i--){    
                if(parents[a][i] != parents[b][i]){
                    a = parents[a][i];
                    b = parents[b][i];
                }
            }
            a = parents[a][0];            
        }
        
        return a;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        parents = new int[N + 1][MAX_DEPTH + 1];
        dist = new int[N + 1];
        depth = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Node1761(b,c));
            tree[b].add(new Node1761(a,c));
        }

        init_dist(1, 0, 0);


        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(dist[a] + dist[b] - dist[searchLCA(a, b)] * 2).append("\n");
        }

        System.out.print(sb);
    }

}

class Node1761 {
    int child;
    int dist;
    public Node1761(int a, int c){
        child = a;
        dist = c;
    }
}