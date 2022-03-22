package BitMask;
import java.io.*;
import java.util.*;

public class beakjoon20304 {    //비슷한 문제 5014
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int limit = (int)Math.ceil(Math.log(N)/Math.log(2)) + 1;
        
        int bits[] = new int[N+1];
        Arrays.fill(bits, 21);

        Queue<Integer> que = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            int a = Integer.parseInt(st.nextToken());
            que.add(a);
            bits[a] = 0; 
        }

        int ans = 0;
        while(!que.isEmpty()){
            int temp = que.poll();

            for(int i = 1 ; i <= N; i = i<<1){
                int temp2 = temp ^ i;
                if(temp2 > N || bits[temp2] <= bits[temp] + 1) continue;
                
                bits[temp2] = bits[temp] + 1;
                que.add(temp2);
                ans = Math.max(ans, bits[temp2]);
            }
        }
        System.out.println(ans);
        
    }
}
