package BinarySearch;
import java.io.*;
import java.util.*;
public class beakjoon2512 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(right < arr[i] ) right = arr[i];
        }

        M = Integer.parseInt(br.readLine());

        int left = 1;
        
        int ans = 0;
        while(left <= right){
            int mid = (left + right) >> 1;

            int temp = 0;
            for(int i = 0 ; i < N; i++){
                if(mid > arr[i]) temp += arr[i];
                else temp += mid;
            }
            if(temp > M){
                right = mid - 1;
            }
            else{
                left = mid + 1;
                ans = mid;
            }
            
        }
        System.out.println( ans );

    }
}
