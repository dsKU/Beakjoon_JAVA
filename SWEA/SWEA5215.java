package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class SWEA5215 {
    static int[] score = new int[20];
    static int[] cal = new int[20];
    static int[] limit = new int[10001];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
    
        int T = Integer.parseInt(br.readLine());
    
        for(int t = 1 ; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   //개수
            int M = Integer.parseInt(st.nextToken());   //칼로리
            Arrays.fill(limit, 0, M+1, 0);
            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0 ; i < N; i++){
                for(int j = M; j >= cal[i]; j--){
                    limit[j] = Math.max(limit[j], limit[j-cal[i]] + score[i]);
                }
            }

            System.out.println("#" + t + " " +limit[M]);
        }
        
    }
}
