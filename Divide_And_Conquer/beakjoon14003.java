import java.io.*;
import java.util.*;

public class beakjoon14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Long[] arr = new Long[N];
        int[] idx_arr = new int[N];
        ArrayList<Long> list = new ArrayList<Long>();
        ArrayList<Integer> idx_list = new ArrayList<Integer>();
        list.add(Long.MIN_VALUE);
        idx_list.add(-1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            idx_arr[i] = i;
            if(list.get(list.size()-1) < arr[i]){
                list.add(arr[i]);
                idx_arr[i] = idx_list.get(idx_list.size()-1);
                idx_list.add(i);
            }
            else{
                int left = 0;
                int right = list.size()-1;
                while(left < right){
                    int mid = (left + right) >> 1;
                    if(list.get(mid) >= arr[i]){
                        right = mid;
                    }
                    else{
                        left = mid + 1;
                    }
                }

                list.set(right, arr[i]);
                idx_arr[i] = idx_list.get(right - 1);
                idx_list.set(right, i);
                
            }
        }

        System.out.println(list.size()-1);
        
        Stack<Long> s = new Stack<>();
        int idx = idx_list.get(idx_list.size()-1);        
        
        while(idx != -1){
            s.push(arr[idx]);
            idx = idx_arr[idx];
        }
        
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }

    }    
}
