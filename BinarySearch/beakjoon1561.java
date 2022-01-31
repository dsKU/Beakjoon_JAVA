package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon1561 {
    static int N,M;
    static long[] time;
    static long solve(long t){
        long result = 0;
        for(int i = 1; i <= M; i++){
            result += (t / time[i]);
        }
        //System.out.println(result);
        return result;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new long[M+1];
        
        long maxTime = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M ; i++){
            time[i] = Integer.parseInt(st.nextToken());
            if(time[i] > maxTime) maxTime = time[i];
        }
            
        if(N <= M){
            System.out.println(N);
            return;
        }

        long people = N - M;
        long left = 1;
        long right = people * maxTime;
        long ans = 0;
        
        while(left <= right){
            long mid = (left + right) >> 1;
            
            if(solve(mid) >= people){
                ans = mid;
                right = mid - 1;
                
            }
            else{
                left = mid + 1;
            }
        }

        long temp = ans - 1;
        long count = 0;
        for(int i = 1; i <= M; i++){
            count += (temp / time[i]);
        }

        int idx = 0;
        for(int i = 1; i <= M; i++){
            if(ans % time[i] == 0) count++;
            if(count == people){
                idx = i;
                break;
            }     
        }
        System.out.println(idx);
    }
}
