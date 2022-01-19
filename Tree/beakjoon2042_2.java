package Tree;
import java.io.*;
import java.util.*;
//Fenwick Tree
public class beakjoon2042_2 {
    static long[] arr;
    static long[] tree;
    
    static void update(int end, int node, long diff){
        while(node <= end){
            tree[node] += diff;
            node += (node & -node);
        }  
    }

    static long tree_sum(int node){
        int end = 1;
        long result = 0;
        while(node >= end){
            result += tree[node];
            node -= (node & -node);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        arr = new long[N+1];
        tree = new long[N + 1];
        
        for(int i = 1 ; i <= N; i++){ 
            arr[i] = Long.parseLong(br.readLine());
            update(N,i,arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        K+=M;

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a == 1){
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[b];
                arr[b] = c;
                update(N, b, diff);

            }
            else if (a == 2){
                int c = Integer.parseInt(st.nextToken());
                sb.append(tree_sum(c) - tree_sum(b-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
