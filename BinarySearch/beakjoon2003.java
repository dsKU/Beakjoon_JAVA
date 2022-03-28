package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon2003 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        long temp = arr[0];
        int left = 0;
        int right = 0;
        while(left <= right && right < N ){
            if(temp == M){
                ans++;
                temp += arr[++right];
            }
            else if(temp < M){
                temp += arr[++right];
            }
            else{
                temp -= arr[left++];
                if(left > right){
                    right = left;
                    temp = arr[left];
                }
            }
        }
        System.out.println(ans);
    }
}
