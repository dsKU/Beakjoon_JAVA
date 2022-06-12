package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class swea2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int sum_ = 0;

            for(int i = 0 ; i < N; i++){
                String str =br.readLine();
                for(int j = 0 ; j < N; j++){
                    map[i][j] = str.charAt(j) - '0';
                    sum_+=map[i][j];
                }
            }

            int count = N / 2;
            int len = N-1;
            for(int i = count ; i > 0; i--){
                for(int j = 0; j < i; j++){
                    sum_ -= map[j][count - i];
                }

                for(int j = 0; j < i; j++){
                    sum_ -= map[j][len + i - count];
                }

                for(int j = 0; j < i; j++){
                    sum_ -= map[len - j][count - i];
                }

                for(int j = 0; j < i; j++){
                    sum_ -= map[len - j][len + i - count];
                }
            }

            System.out.printf("#%d %d\n", t, sum_);
        }
    }
}
