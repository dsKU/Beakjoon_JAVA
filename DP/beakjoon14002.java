package DP;
import java.io.*;
import java.util.*;

public class beakjoon14002 {
    static int N;
    static int[] arr;
    static int[] DP;
    static int[] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        DP = new int[N];
        pre = new int[N];

        int max_idx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i] = 1;
            pre[i] = i;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(DP[i] <= DP[j]){
                        DP[i] = DP[j] + 1;
                        pre[i] = j;
                        if(DP[max_idx] < DP[i]){
                            max_idx = i;
                        }
                    }
                }
            }
        }
        Stack<Integer> s = new Stack<>();
        int idx = max_idx;
        while(idx != pre[idx]){
            s.push(arr[idx]);
            idx = pre[idx];
        }
        s.push(arr[idx]);
        System.out.println(DP[max_idx]);
        
        while(!s.isEmpty()){
            System.out.print(s.pop()+ " ");
        }

    }
}
