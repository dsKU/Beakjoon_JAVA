package Tree;
import java.io.*;
import java.util.*;
public class beakjoon3584 {
    static int N,M;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[][] parents;
    static int level;
    static void init(int node, int parent){
        depth[node] = depth[parent] + 1;

        for(int i = 1 ; i <= level; i++){
            parents[node][i] = parents[parents[node][i-1]][i-1];
        }
        for(int i : tree[node]){
            init(i, node);
        }

    }

    static int solve(int a, int b){
        if(depth[a] < depth[b]){    //레벨이 높은 게 a로 와야함
            int temp = a;            a = b;            b =temp;
        }

        for(int i = level; i >= 0; i--){    //레벨이 같아질 때까지 올려줌
            if(depth[parents[a][i]] >= depth[b]){
                a = parents[a][i];
            }
        }
        int ret = a;
        if(a != b){
            for(int i = level; i >= 0; i--){        //같은 레벨에서 공통조상 찾기 없으면 root가 됨
                if(parents[a][i] != parents[b][i]){
                    a = parents[a][i];
                    b = parents[b][i];
                }
                ret = parents[a][i];
            }
        }

        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            
            tree = new ArrayList[N+1];
            for(int i = 1; i <=N;i++){
                tree[i] = new ArrayList<>();
            }
            depth = new int[N+1];
            level = (int)Math.ceil(Math.log(N)/Math.log(2));
            parents = new int[N+1][level+1];
            for(int i = 1 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                parents[b][0] = a;
            }
            int root = 0;
            for(int i = 1 ; i <= N; i++){
                if(parents[i][0] == 0){
                    root = i; break;
                }
            }
            init(root, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int ans = solve(a, b);


            System.out.println(ans);
        }
    }
}
