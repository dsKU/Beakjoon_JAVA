package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class SWEA1228 {
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            List<String> list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++){
                list.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0 ; i < M; i++){
                if(st.nextToken().equals("I")){
                    int start = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int j = 0 ; j < cnt; j++){
                        list.add(start + j, st.nextToken());
                    }
                }
            }
            
            sb.append("#").append(t).append(" ");
            Iterator<String> it = list.iterator();
            for(int i = 0 ; i < 10; i++){
                sb.append(it.next()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
