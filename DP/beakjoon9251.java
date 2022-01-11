package DP;
import java.util.Scanner;

public class beakjoon9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int[][] DP = new int[1001][1001];

        for(int i = 1; i <= str1.length();i++){
            for(int j = 1; j <= str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] + 1;    

                }
                else{
                    DP[i][j] = Math.max( DP[i][j-1], DP[i-1][j] );
                }

            }
        }
        System.out.println(DP[str1.length()][str2.length()]);
        
        sc.close();
    }
}
