package DP;
import java.util.Scanner;


public class beakjoon2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] val = new int[3];
        int[] max_arr = new int[3];
        int[] min_arr = new int[3];
        for(int j = 0; j < 3 ; j++){
            val[j] = sc.nextInt();
        }
        max_arr[0] = min_arr[0] = val[0]; 
        max_arr[1] = min_arr[1] = val[1];
        max_arr[2] = min_arr[2] = val[2];
        
        for(int i = 1; i < N ; i++){
            for(int j = 0; j < 3 ; j++){
                val[j] = sc.nextInt();
            }
            int bmax0 = max_arr[0],bmax2 = max_arr[2]; 
            max_arr[0] = Math.max(max_arr[0], max_arr[1]) + val[0];
            max_arr[2] = Math.max(max_arr[1], max_arr[2]) + val[2];
            max_arr[1] = Math.max(bmax0, Math.max(max_arr[1], bmax2)) + val[1];
            
            int bmin0 = min_arr[0],bmin2 = min_arr[2]; 
            min_arr[0] = Math.min(min_arr[0], min_arr[1]) + val[0];
            min_arr[2] = Math.min(min_arr[1], min_arr[2]) + val[2];
            min_arr[1] = Math.min(bmin0, Math.min(min_arr[1], bmin2)) + val[1];
        }

        int max_val = Math.max(max_arr[0], Math.max(max_arr[1], max_arr[2]));
        int min_val = Math.min(min_arr[0], Math.min(min_arr[1], min_arr[2]));

        System.out.println(max_val + " "+ min_val);
        sc.close();
    }
}
