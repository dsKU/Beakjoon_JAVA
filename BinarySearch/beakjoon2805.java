package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon2805 {
    static int N,M;
    static int[] val;
    static int max_;
    static int min_val = Integer.MAX_VALUE;
    static int max_val = Integer.MIN_VALUE;

    static void solve(int left, int right){
        if(left > right) return;
        int mid = (left + right) >> 1;

        if(culc(mid) >= M){
            if(mid > max_) max_ = mid;
            solve(mid + 1, right);
        }
        else{
            solve(left, mid - 1);
        }
        
    }
    static long culc(int mid){
        long sum = 0;
        for(int i = 0 ; i < N; i ++){
            sum += val[i] > mid ? val[i] - mid : 0;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        val = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
            max_val = Math.max(max_val, val[i]);
        }
        //Arrays.sort(val);

        solve(0, max_val);
        System.out.println(max_);

    }
}
