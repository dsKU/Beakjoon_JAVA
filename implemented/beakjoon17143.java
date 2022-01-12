import java.io.*;
import java.util.*;



public class beakjoon17143 {
    static int N;
    static int M;
    static int S;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};
    static ArrayList<shark> sh;
    static int[][] map;
    
    static void change_direction(shark s){
        
        if(s.direction == 1 && s.y == 1){
            s.direction = 2;
        }
        else if(s.direction == 2 && s.y == N){
            s.direction = 1;
        }
        else if(s.direction == 4 && s.x == 1){
            s.direction = 3;
        }
        else if(s.direction == 3 && s.x == M){
            s.direction = 4;
        }

    }


    static void shark_move(int idx){
        shark s = sh.get(idx);
        int move = s.speed;
        while(move-- > 0){
            change_direction(s);
            if(s.direction == 1){           //위
                s.y--;
            }
            else if(s.direction == 2){      //아래
                s.y++;
            }
            else if(s.direction == 4){      //왼쪽
                s.x--;
            }
            else if(s.direction == 3){      //오른쪽
                s.x++;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        sh = new ArrayList<shark>();
        map = new int[N+1][M+1];
        sh.add(new shark(-1,-1,0,0,0));

        for(int i = 1 ; i <= S ; i ++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());  
            int c = Integer.parseInt(st.nextToken());  
            int s = Integer.parseInt(st.nextToken());  
            int d = Integer.parseInt(st.nextToken());  
            int z = Integer.parseInt(st.nextToken());
            
            if(d == 1 || d == 2){
                s = s % ( (N - 1) * 2);
            }
            else{
                s = s % ( (M - 1) * 2);
            }

            map[r][c] = i;
            sh.add(new shark(r, c, s, d, z));
        }

        int ans = 0;

        for(int round = 1; round <= M; round++){
            // 라운드에 해당하는 좌표 찾아서 상어 잡기

            for(int i = 1 ; i <= N; i++){
                if(map[i][round] != 0){
                    ans += sh.get(map[i][round]).size;
                    sh.remove(map[i][round]);
                    
                    break;
                }
            }

            map = new int[N+1][M+1];
            
            for(int i = 1 ; i < sh.size(); i++){//상어 이동
                shark s = sh.get(i);
                shark_move(i); 

                //상어 삭제 병신 맵 업뎃안하고 이지랄하고있네
                int idx = map[s.y][s.x];
                if(idx != 0){ //맵에 상어가 있고
                    if(s.size > sh.get(idx).size){//새로운 상어가 더 크면
                        sh.set(idx, s);
                        sh.remove(i);           //기존 상어 삭제
                        i--;                      //인덱스 감소
                    }
                    else{
                        sh.remove(i);             //새로운 상어 삭제
                        i--;
                    }
                }                
                else{
                    map[s.y][s.x] = i;
                }
                
            }//end move


            
            /*
            if(round >1)continue;
            System.out.println();
            for(int k = 1; k <= N; k++){
                for(int j = 1; j <= M; j++){
                    System.out.print(map[k][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        */
        }
        System.out.println(ans);

    }
}

class shark{
    public int x;
    public int y;
    public int speed;
    public int direction;
    public int size;

    public shark(int r,int c, int s, int d, int z){
        this.x = c;
        this.y = r;
        this. speed = s;
        this. direction = d;
        this.size = z;
    }

}