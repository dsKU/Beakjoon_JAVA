import java.io.*;
import java.util.*;

public class beakjoon9205 {
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] point = new int[105][2];
        boolean[] visited = new boolean[105];

        for(int t= 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine())+2;

            for (int i = 0; i < N; i++) {
                visited[i] = false;

                st = new StringTokenizer(br.readLine());
                point[i][0] = Integer.parseInt(st.nextToken());
                point[i][1] = Integer.parseInt(st.nextToken());
            }

            boolean flag = false;
            Queue<Integer> que = new LinkedList<>();

            que.add(0);
            visited[0] = true;
            while(!que.isEmpty()){
                int idx = que.poll();

                if(idx == N - 1){
                    flag = true;
                    break;
                }

                for(int i = 0 ; i < N; i++){
                    if(visited[i]) continue;
                    if(getDis(point[idx], point[i]) <= 1000){
                        que.add(i);
                        visited[i] = true;
                    }
                }

            }
            if(flag){
                sb.append("happy");
            }
            else{
                sb.append("sad");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int getDis(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
