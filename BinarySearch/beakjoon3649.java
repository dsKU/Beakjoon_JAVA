package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon3649 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st ;//= new StringTokenizer(br.readLine());
        String str;
        while((str = br.readLine()) != null){       //입력이 없을 떄까지 진행해야함...
            N = Integer.parseInt(str) * 10_000_000;
            M = Integer.parseInt(br.readLine());
            int[] val = new int[M];
            for(int i = 0 ; i < M; i++){
                val[i] = Integer.parseInt(br.readLine());
            }
    
            Arrays.sort(val);
    
            int left = 0;
            int right = M-1;
            boolean flag = false;
            while(left < right){
                int temp = val[left] + val[right];
    
                if(temp == N){
                    System.out.println("yes " + val[left] +" " + val[right]);
                    flag = true;
                    break;
                }
                else if(temp < N){
                    left++;
                }
                else{
                    right--;
                }
            }
            if(!flag) System.out.println("danger");
            
        }
        


    }
}
