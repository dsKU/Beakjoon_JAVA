package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] val = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);

        

        int left = 0;
        int right = val.length - 1;
        long left_val = val[left];
        long right_val = val[right];
        long min_ = 2000000001;

        while(left < right){
            long temp = val[left] + val[right];
            long t = Math.abs(temp);
            if( t < min_){
                left_val = val[left];
                right_val = val[right];
                min_ = t;
            }
            if(temp >= 0){
                right--;
            }
            else if(temp < 0){
                left++;
            }   
            
            
        }
        System.out.println(left_val+ " " + right_val);
    }
}
