package Divide_And_Conquer;
import java.io.*;
import java.util.*;

public class beakjoon1074 {
    static int N, M, K;
    static int ans = 0;
    static void solve(int y, int x, int size){
        if(size == 1) return;
        if(y < size / 2 && x < size / 2){
            solve(y,x,size/2);
        }
        else if(y < size / 2 && x >= size / 2){
            ans += size * size /4;
            solve(y, x - size/2, size/2);
        }
        else if(y >= size / 2 && x < size / 2){
            ans += size * size / 4 * 2;
            solve(y - size/2, x, size/2);
        }
        else{
            ans += size * size /4 * 3;
            solve(y - size/2, x - size/2, size/2);
        }


    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        N = (int)Math.pow(2, N);
        solve(M, K, N);
        System.out.println(ans);
    }
}
