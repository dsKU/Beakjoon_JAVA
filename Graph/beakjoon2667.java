package Graph;
import java.io.*;
import java.util.PriorityQueue;

public class beakjoon2667 {
    static int N;
    static int[][] map;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int dx[] = {-1 , 0, 1, 0};
    static int dy[] = {0 , 1, 0, -1};
    static public int DFS(int y,int x, int cnt){
        map[y][x] = cnt;
        int ret = 1;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];  
            if(cx >= 0 &&  cx < N && cy >=0 && cy < N){
                if(map[cy][cx] == 0){
                    ret += DFS(cy,cx, cnt);
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N; j++){
                map[i][j] = str.charAt(j)-'1';
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(map[i][j] == 0){
                    pq.add(DFS(i, j, ++cnt));
                }
            }
        }
    
        System.out.println(cnt);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
