package BitMask;

import java.io.*;
import java.util.*;
public class beakjoon1194 {
    static int N,M;
    static char[][] map;
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static point1194 start;
    static boolean[][][] visited;
    static int solve(){
        Queue<node1194> que = new ArrayDeque<>();
        que.add(new node1194(start.y, start.x, 0, 0));
        visited[0][start.y][start.x] = true;

        while(!que.isEmpty()){
            node1194 node = que.poll();

            for(int i = 0 ; i < 4; i++){
                int cy = node.y + dy[i];
                int cx = node.x + dx[i];

                if(cy < 0 || cy >= N || cx < 0 || cx >= M) continue; //범위초과
                if(map[cy][cx] == '#') continue;    //벽
                if(map[cy][cx] == '1') return node.d + 1;   //종료 조건

                if(map[cy][cx] >= 'A' && map[cy][cx] <= 'F'){
                    if(visited[node.k][cy][cx]) continue; //이미 방문

                    int temp = 1 << (map[cy][cx] - 'A');
                    if((node.k & temp) == temp){//문을 만났을 키가 있는지 확인해서 없으면 넣지않음
                        visited[node.k][cy][cx] = true;
                        que.add(new node1194(cy, cx, node.d + 1, node.k));
                    }
                    continue;
                }
                
                int key = node.k;
                if(map[cy][cx] >= 'a' && map[cy][cx] <= 'f'){
                    key |= (1 << (map[cy][cx] - 'a'));
                }
                if(visited[key][cy][cx]) continue; //이미 방문

                visited[key][cy][cx] = true;
                que.add(new node1194(cy, cx, node.d + 1, key));
            }

        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[1<<6][N][M];
        for(int i = 0 ; i < N; i ++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0 ; j < M; j ++){
                if(map[i][j] == '0') start = new point1194(i, j);
            }
        }


        System.out.println(solve());



    }

}
class point1194{
    int y; int x;
    public point1194(int a,int b){
        y = a;
        x = b;
    }
}
class node1194{
    int y; int x; int d; int k;
    public node1194(int a, int b, int c, int z){
        y = a;
        x = b;
        d = c;
        k = z;
    }
}