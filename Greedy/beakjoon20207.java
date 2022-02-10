package Greedy;
import java.io.*;
import java.util.*;


public class beakjoon20207 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int[][] schedule = new int[N][2];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(schedule, (a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int ans = 0;
        int start = schedule[0][0];
        int end = schedule[0][1];
        int m = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.add(schedule[0]);
        for(int i = 1 ; i < N; i++){
            if(schedule[i][0] <= pq.peek()[1]){
                end = Math.max(end, schedule[i][1]);
            }   
            else{
                while(!pq.isEmpty() && pq.peek()[1] < schedule[i][0]){
                    end = Math.max(end, pq.peek()[1]);
                    pq.poll();
                }
                
                if(pq.isEmpty() && end + 1 < schedule[i][0]){
                    ans += (end - start + 1) * m;
                    m = 0;
                    start = schedule[i][0];
                    end = schedule[i][1];
                }
            }
            
            pq.add(schedule[i]);
            m = Math.max(m, pq.size());
        }
        while(!pq.isEmpty()){
            end = Math.max(end, pq.poll()[1]);
        }
        ans += (end - start + 1) * m;
        System.out.println(ans);
    
    }   
}
