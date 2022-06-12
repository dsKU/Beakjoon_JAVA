import java.io.*;
import java.util.*;

public class swea5604 {
    static long[][] arr;
    static int getDigit(long num){
        int ret = 0;
        while(num >= 10){
            num /= 10;
            ret ++;
        }
        return ret;
    }
    static long getSum(long num, int digit){
        long ret = 0;

        while(digit >= 0){
            long d = (long) Math.pow(10, digit);
            long div = num / d;
            long next = num % d;
            
            ret += arr[digit][(int)div];
            ret += div * next;
            digit--;
            num = next;
            
        }
        
        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // // ********************************************************************** //
        arr = new long[17][10]; 
        // arr[i][j] : i = 자리수 0번째부터 시작, j = j0...0까지의 합 ex) arr[2][2] => 0부터 200까지의 합
        for (int j = 1; j < 10; j++) {  //제일 처음
            arr[0][j] = j + arr[0][j-1];
        }
        long temp = 1;
        for(int i = 1 ; i <=16; i++){
            arr[i][1] = arr[i-1][9] + (temp - 1) * 9  + arr[i-1][1];    // 90..1부터 10...0 까지 
            temp *= 10; //사이에 필요한 횟수 100 -> 200까지 100번 1000에서 2000까지 1천번
            for (int j = 2; j < 10; j++) {
                arr[i][j] = (temp * (j-1)) + arr[i][1] + arr[i][j-1];
            }
        }
        // ********************************************************************** //
        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            int m = getDigit(M);
            long ans = -1;
            if( N == 0){
                ans = getSum(M, m); 
            }
            else{
                N--;
                int n = getDigit(N);
                ans = getSum(M, m) - getSum(N, n);
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
