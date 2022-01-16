package PriorityQueue;
import java.io.*;
import java.util.*;

public class beakjoon13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            Long ans = (long) 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i ++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1){
                Long a = pq.poll();
                Long b = pq.poll();
                Long sum = a+b;
                ans+= sum;
                pq.add(sum);
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
