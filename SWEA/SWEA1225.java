package SWEA_JAVA;
import java.io.*;
import java.util.*;


public class SWEA1225 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb =new StringBuilder();
    
        while(br.ready()){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int[] arr = new int[8];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 8; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int idx = 0;
            int cnt = 0;
            while(true){
                int i = idx++ % 8;
                cnt = cnt == 5 ? 1 : cnt + 1;

                arr[i] -= cnt;
                if(arr[i] <= 0){
                    arr[i] = 0;
                    break;
                }
            }

            sb.append("#").append(t).append(" ");
            for(int i = 0; i < 8; i++){
                int index = (idx + i) % 8;
                sb.append(arr[index] ).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }
}
