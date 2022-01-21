package Graph;
import java.util.*;

public class beakjoon1261 {
 
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
                if(cx >= N || cx < 0 || cy >= M || cy < 0) continue;
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
        M = sc.nextInt();
        sc.nextLine();

        map = new int[M][N];
        val = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0 ; i < M; i++){
            Arrays.fill(val[i], 1000000);
            Arrays.fill(visited[i], false);
        }

        for(int i = 0 ; i < M; i++){
            String str = sc.nextLine();
            for(int j = 0 ; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        Dijkstra();

        System.out.println(val[M-1][N-1]);
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

/* test case

6 5
001011
110100
100110
101000
000010

ans = 1

23 3
00101110111000000110100
01001111101010010001100
11000001010110010110000

ans = 5

6 5
000000
111110
000000
011111
000000

ans = 0
*/