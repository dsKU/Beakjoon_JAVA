package DP;
import java.util.Scanner;

public class beakjoon11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        int[] DP = new int[N+1];
        int ans = 0;
        for(int i = 1;i <= N;i++){
            arr[i] = sc.nextInt();
            DP[i] = 1;
            for(int j = 1; j <= i; j++){
                if(arr[i] > arr[j]){
                    DP[i] = Math.max(DP[i], DP[j] + 1); 

                }
            }
            ans = Math.max(ans, DP[i]);
        }
        
        
        System.out.println(ans);
        sc.close();
    }
}
