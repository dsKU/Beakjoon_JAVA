import java.io.*;
import java.util.*;

public class beakjoon1944 {
    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] key;
    static int sx,sy;
    static int cnt = 0;
    static int solve(){
        PriorityQueue<Node1944> pq = new PriorityQueue<>();
        pq.add(new Node1944(sy, sx, 0));    //시작지점 push
        
        int res = 0;

        while(!pq.isEmpty()){
            Node1944 node = pq.poll();
            if(map[node.y][node.x] < node.b) continue;
            
            if(key[node.y][node.x]){    //열쇠 자리면 이떄까지 온 거 더해주고 열쇠 업데이트
                res += node.b;
                node.b = 0;
                cnt ++;
                key[node.y][node.x] = false;
            }
            else{
                map[node.y][node.x] = node.b + 1;
            }
           
            for(int i = 0 ; i < 4; i++){
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                
                if(map[cy][cx] == -1)continue;
                if(map[cy][cx] == 0 || map[cy][cx] > node.b + 1){
                    pq.add(new Node1944(cy, cx, node.b + 1));
                }

            }

        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        key = new boolean[N][N];
        for(int i = 0 ; i < N; i++){
            Arrays.fill(map[i], 10000);
            Arrays.fill(key[i], false);
            //st = new StringTokenizer(br.readLine());
            String str = br.readLine();
            for(int j = 0 ; j < N; j++){
                char ch = str.charAt(j);
                //char ch = st.nextToken().charAt(0);
                if(ch == '1'){  //벽은 -1로 변환
                    map[i][j] = -1;
                }
                else if(ch == 'S'){ //시작지점
                    sy = i;
                    sx = j;
                }
                else if(ch == 'K'){ //열쇠의 위치
                    key[i][j] = true;
                }
            }
        }//end input_for
        int res = solve();
                
        if(cnt == M) System.out.println(res);
        else System.out.println(-1);
    
    }//end main
}
class Node1944 implements Comparable<Node1944>{
    int x,y;
    int b;

    public Node1944(int y,int x, int b){
        this.y = y;
        this.x = x;
        this.b = b;
    }

    @Override
    public int compareTo(Node1944 o) {
        return this.b - o.b;
    }

}