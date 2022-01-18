import java.io.*;
import java.util.*;

public class beakjoon11000 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        int [][] val = new int[N][2];

        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine());
            val[i][0] = Integer.parseInt(st.nextToken());
            val[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[]b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(val[0][1]);
        for(int i = 1 ; i < N;i++){
            if(pq.peek() <= val[i][0]){
                pq.poll();
            }
            pq.add(val[i][1]);
        }

        System.out.println(pq.size());

    }
}
