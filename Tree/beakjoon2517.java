import java.io.*;
import java.util.*;

//시간초과
public class beakjoon2517 {
    static int N,M;
    static long[] tree;
    static node2517[] arr;

    static void update(int node, int start, int end, int idx){
        if(idx < start || idx > end) return;
        tree[node] += 1;

        if(start == end) return;

        int mid = (start + end) >> 1;
        update(node * 2, start, mid, idx);
        update(node * 2 + 1 , mid + 1, end, idx);
    }

    static long search(int node, int start, int end, int left, int right){
        if( end < left || start > right) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) >> 1 ;

        return search(node * 2, start, mid, left, right) +
                search(node * 2 + 1, mid + 1, end, left, right);
        
        
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        int level = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new long[(1 << level+1)+1];
        arr = new node2517[N];

        for(int i = 0 ; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = new node2517(i, a);
        }
        Arrays.sort(arr, (a,b)->b.val - a.val);
        for(int i = 0 ; i < N; i++){
            arr[i].val = i;
        }
        Arrays.sort(arr, (a,b)->a.idx - b.idx);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i++){
            int temp = arr[i].val;
            sb.append(search(1, 0, N-1, 0, temp) + 1).append("\n");
            
            update(1, 0, N-1, temp);
        }

        System.out.print(sb);

    }
}
class node2517{
    int idx;
    int val;
    public node2517(int i, int a){
        idx = i;
        val = a;
    }
}