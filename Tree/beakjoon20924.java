package Tree;
import java.io.*;
import java.util.*;

//A번 노드와 B번 노드가 연결되어 있으며 << 무방향 간선....
public class beakjoon20924 {
    static int N,M;
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    static int ans = 0;
    static void DFS(int idx, int len){
        visited[idx] = true;
        if(tree[idx].size() == 1){
            ans = Math.max(ans, len);
            return;
        }

        for(int[] i : tree[idx]){
            if(visited[i[0]]) continue;
            
            DFS(i[0], len + i[1]);
        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i <= N ;i ++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new int[]{b,c});
            tree[b].add(new int[]{a,c});
        }

        int next = M;
        int length = 0;
        if(tree[M].size() == 1){
            visited[M] = true;
            int n[] = tree[M].get(0);
            length += n[1];
            next = n[0];
            while(tree[next].size() == 2){
                visited[next] = true;
                for(int node[] : tree[next]){
                    if(visited[node[0]]) continue;
                    length += node[1];
                    next = node[0];
                }
            }
        }
        

        DFS(next, 0);
        System.out.println(length + " " + ans);

    }
}
