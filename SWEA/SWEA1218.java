package SWEA_JAVA;
import java.io.*;
import java.util.*;

public class SWEA1218 {
    static boolean Check(char ch1, char ch2){
        if(ch1 == '(' && ch2 == ')') return true;
        if(ch1 == '[' && ch2 == ']') return true;
        if(ch1 == '{' && ch2 == '}') return true;
        if(ch1 == '<' && ch2 == '>') return true;
        return false;
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> st = new Stack<Character>();

            int ans = 1;
            for(int i = 0 ; i < N; i++){
                char ch = str.charAt(i);
                if(ch == ')' || ch == '}' || ch == ']' || ch == '>'){
                    if(st.isEmpty() || !Check(st.pop(), ch)){
                        ans = 0;
                        break;
                    }
                }
                else st.add(ch);
            }
            if(!st.isEmpty()) ans = 0;
            System.out.printf("#%d %d\n",t, ans);
        }



    }
}
