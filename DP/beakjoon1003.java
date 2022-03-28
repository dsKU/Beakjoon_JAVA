package DP;
import java.io.*;

public class beakjoon1003 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long DP[][] = new long[41][2];
        DP[0][0] = 1L;
        DP[1][1] = 1L;
        for(int i = 2; i <41; i++){
            DP[i][0] = DP[i-2][0] + DP[i-1][0];
            DP[i][1] = DP[i-2][1] + DP[i-1][1];
        }
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            System.out.println(DP[N][0] + " " + DP[N][1]);
        }
    }
}
