package Tree;

import java.io.*;
import java.util.*;

public class beakjoon10868 {
    static int N,M;
    static int[] tree;
    static int[] arr;
    static int level;
    static int update(int node, int left, int right){
        if(left == right) return tree[node] = arr[left];

        int mid = (left + right) >> 1;
        tree[node] = Math.min(update(node * 2, left, mid),
            update(node * 2 + 1, mid + 1, right));

        return tree[node];
    }

    static int search(int node, int left, int right, int from, int to){
        if(from > right || to < left) return Integer.MAX_VALUE;

        if(from <= left && to >= right) return tree[node];

        int mid = (left + right) >> 1;
        
        return Math.min(search(node*2, left, mid, from, to), 
                search(node*2+1, mid+1, right, from, to));
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        level = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new int[(1 << level+1)+1];
        arr = new int[N];
        for(int i = 0 ; i < N; i++){ 
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        update(1, 0, N-1);
        
        for(int i = 0 ; i < M; i++){ 
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(search(1, 0, N-1, a-1, b-1));
        }


    }
}
