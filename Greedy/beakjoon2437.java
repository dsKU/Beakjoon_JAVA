package Greedy;
import java.io.*;
import java.util.*;

public class beakjoon2437 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        int[] val =new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);
            
        int sum = 0;
        for(int i = 0 ; i < N; i++){
            if(sum + 1 >= val[i]){
                sum+=val[i];
            }
            else{
                break;
            }
        }
        System.out.println(sum+1);
    }
}
