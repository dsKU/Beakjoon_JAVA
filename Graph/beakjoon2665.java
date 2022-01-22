package Graph;
import java.util.*;

public class beakjoon2665 {
 
    static int N,M;
    static int[][] map;
    static int[][] val;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void Dijkstra(){
        val[0][0] = 0;
        PriorityQueue<ab> q = new PriorityQueue<>();
        q.add(new ab(0,0,0));

        
        while(!q.isEmpty()){
            ab p = q.poll();
            
            if(visited[p.a][p.b]) continue;
            visited[p.a][p.b] = true;

            for(int i =0  ; i < 4; i++){
                int cy = p.a + dy[i];
                int cx = p.b + dx[i];
                if(cx >= N || cx < 0 || cy >= N || cy < 0) continue;
                if(val[cy][cx] > val[p.a][p.b] + map[cy][cx]){
                    val[cy][cx] = val[p.a][p.b] + map[cy][cx];
                    q.add(new ab(cy,cx,val[cy][cx]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //M = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        val = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i < N; i++){
            Arrays.fill(val[i], 1000000);
            Arrays.fill(visited[i], false);
        }

        for(int i = 0 ; i < N; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
                map[i][j] = map[i][j] == 1? 0 : 1;
            }
        }
        Dijkstra();
        System.out.println(val[N-1][N-1]);
        sc.close();
    }
}
class ab implements Comparable<ab>{
    int a;
    int b;
    int c;
    public ab(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(ab o) {
        return this.c - o.c;
    }
}
