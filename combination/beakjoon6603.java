package combination;
import java.io.*;
import java.util.*;

public class beakjoon6603 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static int cSize = 6;
    static StringBuilder sb = new StringBuilder();
    static int[] num = new int[6];
    static void solve(int idx, int srcidx){
        if(idx == cSize){
            for(int i : num){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = srcidx ; i < N; i++){

            num[idx] = arr[i];
            solve(idx + 1, i + 1);
        }



    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(br.ready()){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0)break;
            
            arr = new int[N];
            visited = new boolean[N];
            for(int i = 0 ; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solve(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
