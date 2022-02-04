package BruteForce;
import java.io.*;
import java.util.*;
/*
    이 코드처럼 구현할 수 있는 경우의 수를 탐색하는 방법
    0부터 1_000_000까지 전부 탐색해서 되는 것들만 비교하는 방법이 있는 것 같다
*/

public class beakjoon1107 {
    static int N,M;
    static boolean[] number;
    static int ans = Integer.MAX_VALUE;
    static int limit = 0;
    static void solve(int value, int cnt){
        int temp = cnt + Math.abs(N - value);
        ans = Math.min(ans, temp);

        if(limit == cnt)return;

        for(int i = 0 ; i < 10; i++){
            if(number[i]) continue;
            value *= 10;
            value += i;

            solve(value, cnt+1);
            value /= 10;
        }


    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        number = new boolean[10];
        if(M != 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i <  M; i++){
                number[Integer.parseInt(st.nextToken())] = true;
            }
        }
        

        ans = Math.abs(N-100);
        if(N == 100) {
            System.out.println(0);
            return;
        }
        if(M == 10){
            System.out.println(ans);
            return;
        }
        
        int temp = N == 0 ? 1 : N;
        while(temp > 0){
            limit++;
            temp /= 10;
        }
        limit++;
        for(int i = 0; i < 10 ; i++){
            if(number[i]) continue;
            solve(i,1);
        }

        System.out.println(ans);


    }
}
