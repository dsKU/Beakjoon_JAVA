package DP;
import java.util.*;

public class beakjoon13902 {
    static int N;
    static int M;
    static int DP[];
    static int arr[];
    static Set<Integer> val;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DP = new int[N+2];
        M = sc.nextInt();
        arr = new int[M+1];
        val = new HashSet<Integer>();

        Arrays.fill(DP, 100001);
        DP[0] = 0;

        for(int i = 0; i  < M ; i++){
            arr[i] = sc.nextInt();
            val.add(arr[i]);
            for(int j = 0; j < i; j++){
                int temp = arr[i]+arr[j];
                if(temp <= N)
                val.add(temp);
            }
        }
        
        for(int i = 1; i <= N; i++){
            for(int j : val){
                if(i - j >= 0){
                    DP[i] = Math.min(DP[i], DP[i - j] + 1);
                }
            }
        }

        if(DP[N]>=100001){
            System.out.println(-1);
        }
        else{
            System.out.println(DP[N]);
        }
        
        sc.close();
    }
}
