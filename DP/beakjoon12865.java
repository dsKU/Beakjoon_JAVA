package DP;
import java.util.Scanner;
public class beakjoon12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] bag = new int[100001];
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        
        for(int i = 1; i <=N; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            for(int j = w[i]; j <= M; j++){
                bag[j] = Math.max(bag[j - w[i]] + v[i], bag[j]);
            }
            
        }
        System.out.println(bag[M]);sc.close();
    }
}
