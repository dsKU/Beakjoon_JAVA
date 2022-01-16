package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon1654 {
    static int N;
    static Long M;
    static Long[] val;
    static Long max_ = (long)0;
    static Long max_val = Long.MIN_VALUE;
    static void solve(Long left, Long right){
        if(left > right) return;

        Long mid = (left + right) >> 1;
        
        if(culc(mid) >= M){
            
            if(mid > max_) max_ = mid;
            solve(mid + 1, right);
            
        }
        else{
            solve(left,mid - 1);
        }
    }
    static Long culc(Long mid){
        Long sum = (long) 0;
        for(int i = 0 ; i < N; i++){
            sum += (val[i] / mid);
        }
        
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        val = new Long [N];
        for(int i = 0;i < N; i++){
            val[i] = Long.parseLong(br.readLine());
            max_val = Math.max(max_val, val[i]);
        }

        solve((long)1, max_val);
        System.out.println(max_);

    }
}
