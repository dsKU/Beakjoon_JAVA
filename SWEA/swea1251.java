import java.io.*;
import java.util.*;

public class swea1251 {
    static double getDis(int[] a, int[] b){
        long x = Math.abs(a[1] - b[1]);
        long y = Math.abs(a[0] - b[0]);
        return Math.sqrt(x*x + y*y);
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] list = new int[N][2];
            double[][] graph = new double[N][N];

            for(int i = 0 ; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N; j++){
                    list[j][i] = Integer.parseInt(st.nextToken());
                }
                
            }
            double tax = Double.parseDouble(br.readLine());

            for(int i = 0 ; i< N; i++){
                for(int j = 0 ; j < i; j++){
                    double dis = getDis(list[i], list[j]);
                    double rate = dis * dis * tax;
                    graph[i][j] = rate;
                    graph[j][i] = rate;
                }
            }

            double ans = 0;
            PriorityQueue<node> pq = new PriorityQueue<>((a,b)->a.rate > b.rate ? 1 : -1);
            pq.add(new node(0,0));
            boolean[] visited = new boolean[N];
            while(!pq.isEmpty()){
                node n = pq.poll();
                if(visited[n.idx]) continue;

                visited[n.idx] = true;
                ans += n.rate;
                for(int i = 0 ; i < N; i++){
                    if(visited[i])continue;
                    pq.add(new node(i, graph[n.idx][i]));
                }
            }

            sb.append("#").append(t).append(" ").append(Math.round(ans)).append("\n");
        }
        System.out.print(sb);
    }
}
class point{
    int y, x;
    public point(int a, int b){
        y = a;
        x = b;
    }
}
class node{
    int idx;
    double rate;
    public node(int a, double b){
        idx = a;
        rate = b;
    }
}