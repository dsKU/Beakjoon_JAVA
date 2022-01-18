package Greedy;
import java.io.*;
import java.util.*;

public class beakjoon9576 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Boolean[] page = new Boolean[N + 1];
            int[][] person = new int[M][2];
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                person[i][0] = Integer.parseInt(st.nextToken());
                person[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(person, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[1] == b[1]){
                        return a[0] - b[0];
                    }
                    return a[1] - b[1];
                }
            });

            int ans = 0;
            for(int i = 0; i < M; i++){
                int a = person[i][0];
                int b = person[i][1];
                for(int j = a; j <= b; j++){
                    if(page[j] == null){
                        page[j] = true;
                        ans++;
                        break;
                    }
                }
                
            }

            System.out.println(ans);
        }
    }
}
