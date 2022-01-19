package Tree;
import java.io.*;
import java.util.*;
//Segment Tree
public class beakjoon2042 {
    static long[] arr;
    static long[] tree;
    static long init(int start, int end,int node){
        if(start == end){
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        tree[node] = init(start, mid , node * 2) + init(mid + 1 , end , node * 2 + 1);
        return tree[node];
    }

    static void update(int start, int end, int node, int index, long diff){
        if(start > index || end < index) return;
        tree[node] += diff;

        if(start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

    static long tree_sum(int start, int end, int node, int left, int right){
        if (left > end || right < start)
            return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return  tree_sum( start, mid,   node * 2, left, right) +
                tree_sum( mid + 1, end, node * 2 + 1, left, right);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        arr = new long[N];
        tree = new long[(1 << h + 1) + 1];
        
        for(int i = 0 ; i < N; i++){ 
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0, N-1, 1);
        StringBuilder sb = new StringBuilder();
        K+=M;

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a == 1){
                long c = Long.parseLong(st.nextToken());
                b--;
                long diff = c - arr[b];
                arr[b] = c;
                update(0, N-1, 1, b, diff);

            }
            else if (a == 2){
                int c = Integer.parseInt(st.nextToken());
                sb.append(tree_sum(0, N-1, 1, b-1, c-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
