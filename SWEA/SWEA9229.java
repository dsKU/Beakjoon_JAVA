package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class SWEA9229 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] val = new int[N];

            int ans = -1;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                val[i] = Integer.parseInt(st.nextToken());
                for(int j = 0 ; j < i; j++){
                    int temp = val[i] + val[j];
                    if(temp > M) continue;
                    ans = Math.max(temp,ans);
                }
            }
            
            System.out.printf("#%d %d\n", t, ans);
            

        }
        
    }
}
