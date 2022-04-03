package BinarySearch;
import java.io.*;
import java.util.*;
public class beakjoon15810 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        long min = 1000001;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }
        Arrays.sort(arr);

        long left = arr[0];
        long right = min*M;
        long ans = 0;
        while(left <= right){
            long mid = (left + right) >> 1;

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += (mid/arr[i]);
                if(cnt >= M) break;
            }
            if(cnt >= M){
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        
        }
        System.out.println(ans);
    }

}
