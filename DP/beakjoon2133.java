package DP;
import java.util.Scanner;

public class beakjoon2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[31];
        if(N%2 == 1){
            System.out.println(0);
            sc.close();
            return;
        }
        DP[0] = 1;
        DP[2] = 3;
        for(int i = 4; i <= 30; i++){
            DP[i] = DP[i-2] * 3;
            for(int j= 4; j <= i; j += 2){
                DP[i] += DP[i-j]*2;
            }
        }
        System.out.println(DP[N]);
        sc.close();
    }
}
