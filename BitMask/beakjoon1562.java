package BitMask;
import java.util.Arrays;
import java.util.Scanner;

public class beakjoon1562 {

    static int N;
    static long[][][] DP;
    static long[] num;
    static long mod = 1000000000;
    static long solve(int status, int num, int len){
        if(len <= 1 ) return status == ( 1 << 10 )-1 ? 1 :0;
        

        if(DP[len][num][status] != -1) return DP[len][num][status];

        DP[len][num][status] = 0;

        if(num < 9)
            DP[len][num][status] = (DP[len][num][status] + solve(status | ( 1<< (num+1)), num+1, len-1)) % mod;
        if(num > 0)
            DP[len][num][status] = (DP[len][num][status] + solve(status | (1 << (num-1)), num-1, len-1)) % mod;

        return DP[len][num][status];
    }   


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new long[10];
        DP = new long[101][10][1<<10];
        for(int i = 0; i <101; i++){
            for(int j = 0 ; j < 10; j ++){
                Arrays.fill(DP[i][j], -1);
            }
        }

        int ans = 0;
        for(int i = 1; i <= 9; i ++){
            ans += solve(1<<i, i, N);   
            ans %= mod;
        }

        System.out.println(ans);
        
        sc.close();

    }
}
