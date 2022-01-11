package DP;
import java.util.Scanner;

public class beakjoon2293 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[101];
        int[] DP = new int[10001];
        int N = sc.nextInt();
        int M = sc.nextInt();
        DP[0] = 1;
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
            
        }
        
        for(int i = 1; i <= N; i++){
            for(int j = arr[i]; j <= M; j++){
                DP[j] += DP[j - arr[i]];
            }
        }
        System.out.println(DP[M]);
        sc.close();
    }    
}
