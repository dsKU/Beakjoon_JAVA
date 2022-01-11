import java.io.*;
import java.util.*;

public class beakjoon12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(Long.MIN_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Long temp = Long.parseLong(st.nextToken());
            
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
