import java.io.*;
import java.util.*;

public class swea3289 {
    static int[] arr = new int[1_000_001];
    static int find(int x){
        if(arr[x] == x) return x;
        return find(arr[x]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b) arr[a] = b;
        else arr[b] = a;

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= N; i++){
                arr[i] = i;
            }

            for(int i = 0 ; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(a == 0){
                    union(b, c);
                }
                else{
                    if(b==c){
                        sb.append("1");
                        continue;
                    } 

                    if(find(b) == find(c)) sb.append("1");
                    else sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
