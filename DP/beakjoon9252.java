package DP;
import java.util.Scanner;

public class beakjoon9252 {
    static void print(int i , int j, int[][] DP,String str1, String str2){
        if(DP[i][j] == 0) return;
        if(str1.charAt(i-1) == str2.charAt(j-1)){
            print(i-1,j-1,DP,str1,str2);
            System.out.print(str1.charAt(i-1));
        }
        else{
            if(DP[i-1][j] > DP[i][j-1]){
                print(i-1,j,DP,str1,str2);
            } 
            else{
                print(i,j-1,DP,str1,str2);
            }
        }
    }
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

        int str1_len = str1.length();
        int str2_len = str2.length();
        System.out.println(DP[str1_len][str2_len]);        
        print(str1_len,str2_len,DP,str1,str2);
        
        sc.close();
    }
}
