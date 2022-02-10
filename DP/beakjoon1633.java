package DP;
import java.io.*;
import java.util.*;


public class beakjoon1633 {
    static int ans;
    static int index;
    static int[][] arr;
    static int[][][] DP;
    
    public static int solve(int b, int w, int i){
        if(i >= index) return 0;

        if(DP[i][b][w] != -1) return DP[i][b][w];

        if(b < 15){
            DP[i][b][w] = Math.max(DP[i][b][w], solve(b + 1, w, i + 1) + arr[i][0]);
        }
        if(w < 15){
            DP[i][b][w] = Math.max(DP[i][b][w], solve(b, w + 1, i + 1) + arr[i][1]);
        }       
        
        return  DP[i][b][w] = Math.max(DP[i][b][w], solve(b, w, i + 1));
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        //현재 idx가 블랙
        arr = new int[1001][2];
        DP = new int[1001][16][16];

        index = 1;
        while(br.ready()){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[index][0] = a;
            arr[index][1] = b;
            //DP[index][0][1] = a;
            //DP[index][1][0] = b;
            index += 1;
            
        }
        /*
        for(int i = 1 ; i < index; i++){
            for(int j = 1 ; j <=15; j++){
                for(int k = 1 ; k <=15; k++){
                    DP[i][j][k] = Math.max(DP[i][j][k], DP[i-1][j][k-1] + arr[i][0]);
                    DP[i][j][k] = Math.max(DP[i][j][k], DP[i-1][j-1][k] + arr[i][1]);
                    DP[i][j][k] = Math.max(DP[i][j][k], DP[i-1][j][k]);
                }
            }
        }
        System.out.println(DP[index-1][15][15]);
        */

        for(int i = 0 ; i <= index; i++){
            for(int j = 0 ; j <=15; j++){
                for(int k = 0 ; k <=15; k++){
                    DP[i][j][k] = -1;
                }
            }
        }
        
        
        System.out.println(solve(0, 0, 0));//DP[15][0] + DP[15][1]);
        
    }
}
