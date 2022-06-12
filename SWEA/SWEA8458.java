import java.io.*;
import java.util.*;
public class SWEA8458 {
    static int N;
    static int ans;
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            int cnt = 0;
            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int temp = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                if(temp % 2 == 0) cnt++;
                max = Math.max(max, temp);
            }

            ans = 0;
            if(cnt == 0 || cnt == N){
                while(true){
                    if(max < 1){
                        if(max % 2 != 0){
                            ans ++;
                            if(ans % 2 == 0) ans++;
                        }
                        break;
                    }
                    ans++;
                    max -= ans;
                }

            }
            else{
                ans = -1;
            }
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
    
}
