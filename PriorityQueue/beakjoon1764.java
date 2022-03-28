package PriorityQueue;
import java.io.*;
import java.util.*;


public class beakjoon1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)-> a.compareTo(b));
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(set.contains(str)){
                pq.add(str);
            }
        }
        System.out.println(pq.size());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }
}
