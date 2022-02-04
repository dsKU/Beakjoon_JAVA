package Greedy;
import java.io.*;
import java.util.*;

public class beakjoon19598 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] val = new int[N][2];
        for(int i =0  ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            val[i][0] = Integer.parseInt(st.nextToken());
            val[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val, (a,b) -> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);

        int ans = 0;
        for(int i = 0; i < N; i++){
            while(!pq.isEmpty() && val[i][0] >= pq.peek()[1]){
                pq.poll();
            }

            pq.add(val[i]);
            
            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);

    }
}
