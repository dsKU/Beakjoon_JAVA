package Divide_And_Conquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon1780 {
    static int N;
    static int[][] map;
    static int cnt_minus1;
    static int cnt_zero;
    static int cnt_1;
    static public boolean check_paper(int from_x, int to_x, int from_y, int to_y){
        int ch = map[from_y][from_x];
        for(int i = from_y; i < to_y; i++){
            for(int j = from_x; j < to_x; j++){
                if(ch != map[i][j]) return false;
            }
        }

        return true;
    }

    static public void DAC(int from_x, int to_x, int from_y, int to_y){
        if(check_paper(from_x, to_x, from_y, to_y)){
            int val = map[from_y][from_x];
            if(val == -1){
                cnt_minus1++;
            }
            else if( val == 0){
                cnt_zero++;
            }
            else if(val == 1){
                cnt_1 ++;
            }
            return;
        }
        int size = to_x - from_x;
        int next_size = size / 3;

        DAC(from_x, to_x - (next_size * 2), from_y, to_y - (next_size * 2));
        DAC(from_x + next_size, to_x - next_size, from_y, to_y - (next_size * 2));
        DAC(from_x + (next_size * 2), to_x, from_y, to_y - (next_size * 2));

        DAC(from_x, to_x - (next_size * 2), from_y + next_size, to_y - next_size);
        DAC(from_x + next_size, to_x - next_size, from_y + next_size, to_y - next_size);
        DAC(from_x + (next_size * 2), to_x, from_y + next_size, to_y - next_size);

        DAC(from_x, to_x - (next_size * 2), from_y + (next_size * 2), to_y);
        DAC(from_x + next_size, to_x - next_size, from_y + (next_size * 2), to_y);
        DAC(from_x + (next_size * 2), to_x, from_y + (next_size * 2), to_y);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DAC(0, N, 0, N);

        System.out.println(cnt_minus1);
        System.out.println(cnt_zero);
        System.out.println(cnt_1);

    }
}
