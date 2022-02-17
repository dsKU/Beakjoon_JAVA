package BinarySearch;
import java.io.*;
import java.util.*;
public class beakjoon8983 {
    static int N,M, K;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] sade = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            sade[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sade);

        int ans = 0;
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            int left = 0;
            int right = N-1;
            while(left < right){
                int mid = (left + right) >> 1;
                if(left == mid || right == mid) break;
                //안 겹치기 위한 조건 left와 right 둘 다 검사해야함
                
                if(sade[mid] > x){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }
            System.out.println(left + " " + right);
            if(Math.abs(sade[left] - x) + y <= K) ans ++;
            else if(Math.abs(sade[right] - x) + y <= K) ans ++;
            
        }
        System.out.println(ans);
    }
}
