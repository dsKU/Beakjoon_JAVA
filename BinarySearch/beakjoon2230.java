package BinarySearch;
import java.io.*;
import java.util.*;


public class beakjoon2230 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    
        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int ans = Integer.MAX_VALUE;
        while(right < N && left < N){
            int d = Math.abs(arr[right] - arr[left]);

            if(d >= M){   
                ans = Math.min(ans, d);
                left++;
            }
            else{
                right++;
            }

        }


        System.out.println(ans);

    }
}
