package Tree;
import java.io.*;
import java.util.*;

public class beakjoon7578 {
    static int N,M;
    static int[] tree;
    static int[] arr;
    static int[] num;
    static int level;
    static void update(int node, int start, int end, int index){
        if(start > index || end < index) return;
        
        tree[node] += 1;

        if(start == end)return;

        int mid = (start + end)  >> 1;
        update(node * 2, start, mid, index);
        update(node * 2 + 1, mid + 1, end, index);
    }
    static int sum(int node, int start, int end, int left, int right){
        if( end < left || start > right) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) >> 1 ;

        return sum(node * 2, start, mid, left, right) +
               sum(node * 2 + 1, mid + 1, end, left, right);

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        num = new int[1_000_001];
        arr = new int[N+1];
        level = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new int[(1 << level+1)+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){ 
            num[Integer.parseInt(st.nextToken())] = i;
        }

        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){ 
            arr[i] = num[Integer.parseInt(st.nextToken())];

            int temp = sum(1, 1, N, arr[i] + 1, N );
            ans += temp;

            update(1, 1, N, arr[i]);
        }
        
        System.out.println(ans);

    }
}
