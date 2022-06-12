import java.io.*;
import java.util.*;

public class swea1251_2 {
    static int[] parents = new int[1001];
    static int find(int x){
        if(x == parents[x]) return x;
        return find(parents[x]);
    }
    static boolean union(int a, int b){
        int ap = find(a);
        int bp = find(b);
        if(ap == bp) return true;
        parents[bp] = ap;
        return false;
    }
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
            
            for(int i = 0 ; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N; j++){
                    list[j][i] = Integer.parseInt(st.nextToken());
                }
                
            }
            double tax = Double.parseDouble(br.readLine());
            ArrayList<edge> edges = new ArrayList<>();
            for(int i = 0 ; i< N; i++){
                parents[i] = i;
                for(int j = 0 ; j < i; j++){
                    double dis = getDis(list[i], list[j]);
                    double rate = dis * dis * tax;
                    edges.add(new edge(i,j,rate));
                }
            }

            double ans = 0;
            edges.sort((a,b)->a.rate >= b.rate ? 1 : -1);
            //Collections.sort(edges, (a,b)-> a.rate > b.rate ? 1 : -1);
            int cnt = 0;
            for(edge e : edges){
                if(union(e.a, e.b)) continue;
                ans += e.rate;
                cnt++;
                if(cnt == N-1) break;
            }

            sb.append("#").append(t).append(" ").append(Math.round(ans)).append("\n");
        }
        System.out.print(sb);
    }
}
class edge{
    int a, b;
    double rate;
    public edge(int a, int b, double r){
        this.a = a;
        this.b = b;
        rate = r;
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