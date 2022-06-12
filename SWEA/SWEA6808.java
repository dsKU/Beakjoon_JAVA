package SWEA_JAVA;
import java.io.*;
import java.util.*;


public class SWEA6808 {
    static int[] card = new int[9];
    static boolean[] selected = new boolean[19];
    static int gyuWin = 0;
    static int inWin = 0;
    static void solve(int gyu, int in, int idx){
        if(idx == 9){
            if(gyu > in){
                gyuWin++;
            }
            else if(gyu < in){
                inWin++;
            }

            return;
        }
        for(int i = 1 ; i < 19; i++){
            if(selected[i]) continue;
            selected[i] = true;
            if(card[idx] > i){
                
                solve(gyu + card[idx] + i, in, idx+1);
            }
            else{
                solve(gyu, in+ card[idx] + i, idx+1);
            }
            selected[i] = false;
        }


    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        
        for(int t= 1; t <= T; t++){
            gyuWin = 0;
            inWin = 0;
            for(int i = 1 ; i < 19; i++) selected[i] = false;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 9; i++){
                card[i] = Integer.parseInt(st.nextToken());
                selected[card[i]] = true;
            }
            solve(0, 0, 0);
            System.out.printf("#%d %d %d\n",t,gyuWin, inWin);
        }
    }
}
