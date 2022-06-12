import java.io.*;
import java.util.*;
public class swea3234 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        int[] arr = new int[10];
        int N;
        int limit;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t= 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            limit = (1 << N) - 1;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(t).append(" ").append(solve(0, 0, 0, arr, N, limit)).append("\n");
        }
        System.out.print(sb);
    }
    
    static int solve(int leftSum, int rightSum, int bit, int[] arr,int N,int limit){
        
        if(bit == limit) return 1;
        int ret = 0;

        for(int i = 0 ; i < N; i++){
            if((bit & 1 << i) == 0){
                if(leftSum + arr[i] >= rightSum){
                    ret += solve(leftSum + arr[i], rightSum, bit | 1 << i, arr, N, limit);
                }
                if(leftSum >= rightSum + arr[i]){
                    //if((bit | 1 << i) == limit) return 1; 
                    ret += solve(leftSum , rightSum + arr[i], bit | 1 << i, arr, N, limit);
                }
                
            }
        }


        return ret;
    }
}
