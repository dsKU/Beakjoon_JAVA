import java.io.*;
import java.util.*;
public class swea13038 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] day = new int[7];

            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 7; i++){
                day[i] = Integer.parseInt(st.nextToken());
                if(day[i] == 1){
                    cnt++;
                }
            }
            int ans = Integer.MAX_VALUE;
            for(int d = 0 ; d < 7 ; d++){
                if(day[d] == 0) continue;
                int date = 0;
                int c = 0;
                int idx = d;
                while(true){
                    if(day[idx] == 1) c++;
                    
                    date++;
                    idx++;
                    
                    if(c == N)break;
                    if(idx == 7) idx = 0;
                }
                ans = Math.min(ans, date);
            }
            


            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
