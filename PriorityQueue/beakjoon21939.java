package PriorityQueue;
import java.io.*;
import java.util.*;

public class beakjoon21939 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a,b)-> a[1] == b[1] ? b[0]-a[0] : b[1]-a[1]);   //내림차순
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)-> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);   //오름차순
        int[] num = new int[100_001];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq1.add(new int[]{a,b});
            pq2.add(new int[]{a,b});
            num[a] = b;
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                pq1.add(new int[]{a,b});
                pq2.add(new int[]{a,b});
                num[a] = b;
            }
            else if(str.equals("recommend")){
                int[] temp = null;
                int cmd = Integer.parseInt(st.nextToken());
                if(cmd == 1){
                    while(num[pq1.peek()[0]]!= pq1.peek()[1]){
                        pq1.poll();
                    }
                    temp = pq1.peek();
                }
                else{
                    while(num[pq2.peek()[0]]!= pq2.peek()[1]){
                        pq2.poll();
                    }
                    temp = pq2.peek();
                }
                sb.append(temp[0]).append("\n");
            }
            else if(str.equals("solved")){
                int a = Integer.parseInt(st.nextToken());
                num[a] = 0;
            }
        }
        System.out.print(sb);
    }
}
