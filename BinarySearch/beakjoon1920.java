package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon1920 {
    static int N;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        val = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i < N;i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        while(T-- > 0){
            int temp = Integer.parseInt(st.nextToken());
            
            if(find(temp)){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }
    static boolean find(int n){
        int left = 0;
        int right = N-1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(val[mid] < n){
                left = mid + 1;
            }
            else if(val[mid] > n){
                right = mid - 1;
            }
            else{
                return true;
                
            }
        }
        return false;
    }
}
