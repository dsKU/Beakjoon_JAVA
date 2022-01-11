package Divide_And_Conquer;
import java.io.*;
import java.util.*;

public class beakjoon12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            
            if(list.get(list.size()-1) < temp){
                list.add(temp);
            }
            else{
                int left = 0;
                int right = list.size()-1;
                while(left < right){
                    int mid = (left + right) >> 1;
                    if(list.get(mid) >= temp){
                        right = mid;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                list.set(right, temp);

            }
        }

        System.out.println(list.size()-1);

    }    
}
