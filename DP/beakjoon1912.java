package DP;
import java.util.Scanner;

public class beakjoon1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] DP = new int[N+1][2];
        DP[0][0] = -100000000 ; DP[0][1] = -100000000;
        //0 = idx를 선택하지않음 1 = 선택함
        for(int i = 1; i <= N; i++){
            int inx = sc.nextInt();
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            DP[i][1] = Math.max(inx, DP[i-1][1] + inx);  
            
        }
        
        System.out.println(Math.max(DP[N][0],DP[N][1]));
        sc.close();
    }
}
