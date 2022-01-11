package DP;
import java.util.Scanner;

public class beakjoon2688 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] DP = new long[65];
        long[][] arr = new long[65][10];
        int T = sc.nextInt();
        DP[1] = 10;
        
        for(int i = 0 ; i < 10; i++){
            arr[1][i] = 1;
        }
        for(int i = 2 ; i < 65; i++){
            for(int j = 0 ; j < 10; j++){
                for(int k = j ; k < 10; k++){
                    arr[i][j] += arr[i-1][k];
                }
                DP[i] += arr[i][j];
            }
        }
        while(T-- >0){
            int n = sc.nextInt();
            
            System.out.println(DP[n]);
        }
        sc.close();
    }
}
