package implemented;
import java.io.*;
import java.util.*;
//알고리즘 분류는 그리드인데 왜 그리드인지는 잘 모르겠음.
public class beakjoon2873 {
    static int N, M;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static void Vertical(int y, int x, int size, boolean flag){
        if(y == 0) return;

        if(flag) sb.append("D");

        for(int i = y; i <= size; i++){
            for(int j = x; j <= M - 1; j++){
                if(flag)    sb.append("L");
                else    sb.append("R");
            }
            flag = !flag;
            sb.append("D");
        }
        
    }
    static void Horizon(int y, int x, int size, boolean flag){
        if(x == 0) return;

        if(flag) sb.append("R");

        for(int i = x; i <= size; i++){
            for(int j = y; j <= N - 1; j++){
                if(flag)    sb.append("U");
                else    sb.append("D");
            }
            flag = !flag;
            sb.append("R");
        }

        
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        int minX = 0;
        int minY = 0;
        int min_ = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int a= Integer.parseInt(st.nextToken());
                
                if(((i + j) % 2) == 1 && min_ > a){
                    min_= a;
                    minY= i;
                    minX= j;                
                }
                map[i][j] = a;
            }
        }

        
        if(N % 2 == 1){ //완탐 가능     세로가 홀수 일 떄 가로로 크게 지그재그
            Vertical(1, 1, N, false);
        }
        else if(M % 2 == 1){    //세로로 완탐가능   세로가 홀수고 가로가 짝수 일 때 세로로 크게 지그재그
            Horizon(1, 1, M, false);
        }
        else{   //N,M이 짝수 일 때  최소 1개는 순회못함.
                //최소 지점 전까지 크게 지그재그 돌고 최소 지점일 때 1칸 간격으로 지그재그
                //그 뒤 남은 지점은 크게 지그재그
            int a = minY - 1;
            int b = minX - 1;   

            if(a % 2 == 0){
                Vertical(1 , 1, a, false);
                
                char ch = 'D';
                int limit = (M-1)*2;
                int y = minY + 1;
                int x = 1;
                //D -> R-> U (if) -> R-> D
                for(int j = 1; j <= limit; j++){ 
                    sb.append(ch);
                    if(ch == 'D' || ch == 'U'){
                        ch = 'R';
                        x++;
                    }
                    else if(ch == 'R'){
                        if(y-1 == minY && x == minX){
                            x++;
                            continue;
                        } 
                        if(y > minY){
                            ch = 'U';
                            y--;
                        }
                        else{
                            ch = 'D';
                            y++;
                        }
                    }
                }
                
                Vertical(minY + 2 , 1, N, true);
            }
            else{
                Horizon(1 , 1, b, false);

                char ch = 'R';
                int limit = (N-1)*2;
                int y = 1;
                int x = minX+1;

                for(int j = 1; j <= limit; j++){ 
                    sb.append(ch);
                    if(ch == 'R' || ch == 'L'){
                        ch = 'D';
                        y++;
                    }
                    else if(ch == 'D'){
                        if(x-1 == minX && y == minY){
                            y++;
                            continue;
                        } 
                        if(x > minX){
                            ch = 'L';
                            x--;
                        }
                        else{
                            ch = 'R';
                            x++;
                        }
                    }
                }
                Horizon(1 , minX + 2, M, true);
            }
        }
        sb.deleteCharAt(sb.length() - 1);


        
        System.out.println(sb);



    }
}
