package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class swea1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1 ; t <= T; t++){
            String str = br.readLine();

            int len = str.length();
            char pre =  str.charAt(0);
            int ans = pre == '0' ? 0 : 1;
            for(int i = 1; i < len; i++){
                char ch = str.charAt(i);
                if( pre != ch){
                    ans ++;
                    pre = ch;
                }
            }

            System.out.printf("#%d %d\n",t,ans);
        }


    }
}
