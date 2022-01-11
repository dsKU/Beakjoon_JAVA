package DP;
import java.util.Scanner;

public class beakjoon9084 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            int[] val = new int[N+1];
            for(int i = 1; i <= N; i++){
                val[i] =sc.nextInt();
            }
            int M = sc.nextInt();
            int[] bag = new int[M+1];
            bag[0] = 1;
            for(int i = 1; i <=N; i++){
                for(int j = val[i]; j <= M ; j++){
                    bag[j] += bag[j - val[i]];
                }
            }
            System.out.println(bag[M]);
            sc.close();
        }
    }
}
