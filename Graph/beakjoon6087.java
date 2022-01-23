package Graph;
import java.io.*;
import java.util.*;

public class beakjoon6087 {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> point;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static void Dijkstra(){
        map[point.get(0)[0]][point.get(0)[1]] = 0;  //시작점 초기화

        PriorityQueue<Node6087> pq = new PriorityQueue<>();
        pq.add(new Node6087(point.get(0)[0], point.get(0)[1] , 0 , -1));

        while(!pq.isEmpty()){
            Node6087 Node6087 = pq.poll();
            for(int i =0  ; i < 4; i++){
                int cy = Node6087.a + dy[i];
                int cx = Node6087.b + dx[i];
                if(cx >= N || cx < 0 || cy >= M || cy < 0 || map[cy][cx] == -1) continue;
                
                int next = Node6087.d == i ? Node6087.c : Node6087.c + 1;

                if(map[cy][cx] >= next){
                    map[cy][cx] = next;
                    pq.add(new Node6087(cy, cx, next, i));
                }
                
            }

        }   //end while
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        point = new ArrayList<>();

        for(int i = 0; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0 ; j < N; j++){
                char ch = str.charAt(j);
                map[i][j] = 10000;
                if(ch == '*'){
                    map[i][j] = -1;
                }
                else if(ch == 'C'){
                    int[] p = {i, j};
                    point.add(p);
                }
            }
        }

        Dijkstra();

        for(int i = 0; i < M; i++){
            for(int j = 0 ; j < N; j++){
                System.out.printf("%3d",map[i][j]);
            }
            System.out.println();
        }


        System.out.println(map[point.get(1)[0]][point.get(1)[1]] -1 );

    }
}
class Node6087 implements Comparable<Node6087>{
    int a,b,c,d;
    public Node6087(int a, int b, int c, int d) {
        this.a = a; // x
        this.b = b; // y
        this.c = c; // cnt
        this.d = d; // direction
    }
    @Override
    public int compareTo(Node6087 o){
        return this.c - o.c;
    }
}

/*test case
https://bingorithm.tistory.com/2
*/