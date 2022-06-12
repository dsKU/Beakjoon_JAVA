package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class SWEA3499 {
    static ArrayList<String> ans = new ArrayList<>();
    static String[] str;
    static StringBuilder sb = new StringBuilder();
    static int lSize, rSize;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            str = br.readLine().split(" ");
            ans.clear();
            lSize = N % 2 == 0 ? N/2 : N / 2 + 1 ;
            rSize = N;
            
            sb.append("#").append(t).append(" ");
            solve(0, lSize, false);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void solve(int left_idx, int right_idx, boolean flag){
        if(left_idx == lSize && right_idx == rSize) return;
        if(flag){
            sb.append(str[right_idx]).append(" ");
            solve(left_idx, right_idx + 1, !flag);
        }
        else{
            sb.append(str[left_idx]).append(" ");
            solve(left_idx + 1, right_idx, !flag);
        }
    }
}
