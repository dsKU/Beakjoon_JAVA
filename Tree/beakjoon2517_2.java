package Tree;
import java.io.*;
import java.util.*;
//세그먼트 트리는 시간초과
//다른 코드들 보니까 해쉬맵사용..
public class beakjoon2517_2 {
    static int N,M;
    static long[] tree;
    static node2517[] arr;

    static void update(int idx){
        while(idx <= N){
            tree[idx] += 1;
            idx += (idx & -idx); 
        }

    }

    static long search(int idx){
        long ans = 0;
        while( idx >= 1){
            ans += tree[idx];
            idx -= (idx & -idx);
        }
        
        return ans;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        tree = new long[N+1];
        arr = new node2517[N];

        for(int i = 0 ; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = new node2517(i + 1, a);
        }
        Arrays.sort(arr, (a,b)->b.val - a.val);
        for(int i = 0 ; i < N; i++){
            arr[i].val = i + 1;
        }
        Arrays.sort(arr, (a,b)->a.idx - b.idx);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i++){
            int temp = arr[i].val;
            long rank = search(temp)+1;

            sb.append(rank).append("\n");
            
            update(temp);
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