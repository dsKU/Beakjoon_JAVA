package DP;
import java.util.Scanner;

public class beakjoon10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] arr = new long[101][10];
        int N = sc.nextInt();
        long ans = 0;
        arr[1][0] = 0; arr[1][1] = 1; arr[1][2] = 1; 
        arr[1][3] = 1; arr[1][4] = 1; arr[1][5] = 1; 
        arr[1][6] = 1; arr[1][7] = 1; arr[1][8] = 1; arr[1][9] = 1;  

        for(int i = 2;i <= N;i++){
            for(int j = 0; j <= 9 ; j++){
                if(j == 9){
                    arr[i][9] = arr[i-1][8] % 1000000000;
                }
                else if(j == 0){
                    arr[i][0] = arr[i-1][1]% 1000000000;
                }
                else{
                    arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])% 1000000000;
                }
            }
        }
        for(int i = 0; i <= 9; i++){
            ans += arr[N][i];
        }
        
        System.out.println(ans % 1000000000);sc.close();
    }
}
