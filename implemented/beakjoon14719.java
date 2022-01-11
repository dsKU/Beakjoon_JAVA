package implemented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class beakjoon14719 {
    static int N;
    static int M;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M+1];

        st = new StringTokenizer(br.readLine());
        int max_level = 0;
        for(int i = 0 ; i < M; i ++){
            map[i] = Integer.parseInt(st.nextToken());
            max_level = Math.max(max_level, map[i]);
        }

        int ans = 0;
        
        for(int i = 0; i < max_level; i++){
            Stack<Integer> s = new Stack<Integer>();
            for(int j = 0 ; j < M; j++){
                if(map[j] > i){
                    
                    if(!s.isEmpty() && j - s.peek() > 1){
                        ans += (j - s.peek() - 1);
                        
                    }
                    s.push(j);
                }
            }
        }

        System.out.println(ans);

    }
}
