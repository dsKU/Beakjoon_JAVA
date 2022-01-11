package Divide_And_Conquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class beakjoon6549 {
    static long[] arr;

    static long DAC(int left, int right){
        if(left == right) return arr[left];

        int mid = (left + right)/2;
        long ret = Math.max(DAC(left,mid), DAC(mid+1,right));

        int l = mid;
        int r = mid+1;
        long height = Math.min(arr[l], arr[r]);
        ret = Math.max(ret, height*2);

        while(left < l || r < right){
            if(r < right && (l == left || arr[l - 1] < arr[r + 1])){
                r++;
                height = Math.min(height, arr[r]);
            }
            else{
                l--;
                height = Math.min(height, arr[l]);
            }


            ret = Math.max(ret, height * ( r - l +1));
        }

        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            
            arr = new long[N];
            for(int i = 0 ; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            System.out.println(DAC(0,N-1));

        }
        

    }
}
