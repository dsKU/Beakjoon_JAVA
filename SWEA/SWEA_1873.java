package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class SWEA_1873 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for(int t = 1 ; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            int tx = 0;
            int ty = 0;
            for(int i = 0 ; i < N; i++){
                String str = br.readLine();
                for(int j = 0 ; j < M; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v' ){
                        tx = i;
                        ty = j; 
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            String str = br.readLine();
            
            for(int i = 0 ; i < act; i++){
                char command = str.charAt(i);
                switch(command){
                    case 'U':   //위
                        // 범위 안에 있고 평지면 탱크가 있는 위치를 평지로 바꾸고 위치 이동
                        if(tx - 1 >= 0 && map[tx - 1][ty] == '.') 
                            map[tx--][ty] = '.';

                        map[tx][ty] = '^';

                    break;
                    case 'D':   //아래
                        if(tx + 1 < N && map[tx + 1][ty] == '.') 
                            map[tx++][ty] = '.';

                        map[tx][ty] = 'v';

                    break;
                    case 'L':
                        if(ty - 1 >= 0 && map[tx][ty - 1] == '.') 
                            map[tx][ty--] = '.';

                        map[tx][ty] = '<';

                    break;
                    case 'R':
                        if(ty + 1 < M && map[tx][ty + 1] == '.') 
                            map[tx][ty++] = '.';
                        
                        map[tx][ty] = '>';

                    break;
                    case 'S':
                        int x = tx;
                        int y = ty;
                        int d = 0;

                        //int[] dx = {1,-1,0,0};    참고용
                        //int[] dy = {0,0,1,-1};
                        if(map[tx][ty] == '>') d = 2;
                        else if(map[tx][ty] == '<') d = 3;
                        else if(map[tx][ty] == '^') d = 1;
                        else if(map[tx][ty] == 'v') d = 0;

                        while(true){
                            if(x >= N || y >= M || x < 0 || y < 0|| map[x][y] == '#') break;
                            if(map[x][y] == '*') {
                                map[x][y] = '.';
                                break;
                            }
                            x+=dx[d];
                            y+=dy[d];
                        }
                    break;
                }//end switch

            }//end for_command


            
            sb.append("#").append(t).append(" ");
            for(char[] s : map){
                sb.append(s).append("\n");
            }
            
        }//end for_test
        System.out.print(sb);
    }
}
