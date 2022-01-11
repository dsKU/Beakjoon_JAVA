package DP;
import java.util.Scanner;

public class beakjoon14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long[] DP = new long[N+1];
        DP[0] = 1;
        DP[1] = 0;
        DP[2] = 2;

    }
}
