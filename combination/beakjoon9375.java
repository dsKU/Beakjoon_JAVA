package combination;
import java.io.*;
import java.util.*;

public class beakjoon9375 {
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                System.out.println(0);
                continue;
            }
            String[] key = new String[N];
            int[] count = new int[N];
            
            int idx = 1;
            key[0] = br.readLine().split(" ")[1];
            count[0] = 1;
            for(int i = 1 ; i < N; i++){
                String[] str = br.readLine().split(" ");
                boolean flag = false;
                for(int j = 0; j < idx; j++){
                    if(key[j].equals(str[1])){
                        count[j]++;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    key[idx] = str[1];
                    count[idx++] = 1;
                }
            }
            int ans = 1;
            for(int i = 0 ; i < idx ; i++){
                ans *= (count[i] + 1);
            }
            System.out.println(ans - 1);
        }


    }
}
