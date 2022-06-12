package SWEA_JAVA;

import java.io.*;
import java.util.*;

public class SWEA1210 {
    static int[][] map = new int[100][100];
    static int ans = 0;
    static void solve(int y, int x, int val){
        if(y == 99){
            if(map[y][x] == 2)
                ans = val;
            return;
        }

        if(x + 1 < 100 && map[y][x+1] == 1){
            int temp = x;
            while(temp + 1 < 100 && map[y][temp + 1] == 1) temp++;
            solve(y + 1, temp, val);
        }
        else if(x - 1 >= 0 && map[y][x-1] == 1){
            int temp = x;
            while(temp - 1 >= 0 && map[y][temp - 1] == 1) temp--;
            solve(y + 1, temp, val);
        }
        else  solve(y+1, x, val);

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        for(int t = 1; t <= 10; t++){
            br.readLine();

            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    map[i][j] = st.nextToken().charAt(0) - '0';
                }
            }
            
            for(int i = 0; i < 100; i++){
                if(map[0][i] != 0) solve(0, i, i);
            }
            System.out.printf("#%d %d\n",t, ans);
        }
    }
}
