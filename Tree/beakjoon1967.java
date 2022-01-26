package Tree;
import java.io.*;
import java.util.*;

public class beakjoon1967 {
    static int N;
    static ArrayList<Node1967>[] tree;
    static boolean visited[];
    static int max_, node;
    static void solve(int idx, int cnt){
        if(cnt > max_){
            max_ = cnt;
            node = idx;
        }
        for(Node1967 b : tree[idx]){
            if(!visited[b.a]){
                visited[b.a] = true;
                solve(b.a, cnt + b.b);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+2];
        visited = new boolean[N+2];
        for(int i = 1  ; i <= N; i++){
            tree[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[a].add(new Node1967(b, c));
            tree[b].add(new Node1967(a, c));
        }
        if(N==1){
            System.out.println(0);
            return;
        }
        visited[1] = true;
        solve(1,0);
        Arrays.fill(visited, false);
        visited[node] = true;
        solve(node, 0);

        System.out.println(max_);
    }
}
class Node1967{
    int a,b;
    public Node1967(int a,int b){
        this.a = a;
        this.b = b;
    }
}