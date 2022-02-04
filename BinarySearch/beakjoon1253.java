package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon1253 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int[] val = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);
        //자기 자신은 포함하면 안됨....
        int ans = 0;
        for(int i = 0 ; i < N; i++){
            int left = 0;
            int right = N-1;
            while(left < right){
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }

                int sum_ = val[left] + val[right];
                if(val[i] == sum_){
                    ans++;
                    break;
                }
                if(val[i] > sum_){
                    left++;
                }
                else{
                    right--;
                }
            }//end while
        }//end for
        System.out.println(ans);


    }
}


