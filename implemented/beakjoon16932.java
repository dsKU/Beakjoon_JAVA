package implemented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class beakjoon16932 {
    static int N;
    static int M;
    static int[][] map;
    static int[] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> val;
    static ArrayList<point16932> zero_arr;
    static ArrayList<point16932> arr;
    static int DFS(int x, int y, int idx, int cnt){
        map[x][y] = idx;
        cnt ++;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            
            if(cx >= 0 && cx < N && cy >= 0 && cy < M){
                if(map[cx][cy] == 1){
                    cnt += DFS(cx,cy, idx, 0);
                }
            }

        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        val = new ArrayList<Integer>(); val.add(0); val.add(0);
        zero_arr = new ArrayList<point16932>();
        arr = new ArrayList<point16932>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    zero_arr.add(new point16932(i,j));
                }
                else{
                    arr.add(new point16932(i,j));
                }
            }
        }

        int ans = 0;
        int idx = 2;
        for(point16932 p : arr){             //각 떨어진 무리들 idx업데이트
            if(map[p.x][p.y] == 1){                    
                val.add(DFS(p.x, p.y, idx, 0));
                idx++;
            }

        }
        
        for(point16932 p : zero_arr){                  // 0일 떄 중복없이 주변 것들 더해서 최대값 구하기         
                HashSet<Integer> set = new HashSet();
                
                int temp = 0;        
                for(int k = 0 ; k < 4; k++){
                    int cx = p.x + dx[k];
                    int cy = p.y + dy[k];
                    
                    if(cx >= 0 && cx < N && cy >= 0 && cy < M){
                        int index = map[cx][cy];
                        if(index > 1 && !set.contains(index)){
                            set.add(index);
                            temp += val.get(index);
                        }
                    }
                }
                ans = Math.max(ans, temp + 1);
        }


        System.out.println(ans);
    }
}

class point16932{
    public int x;
    public int y;
    public point16932(int x, int y){
        this.x = x;
        this.y = y;
    }
}