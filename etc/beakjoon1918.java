package etc;
import java.io.*;
import java.util.*;


public class beakjoon1918 {
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray();
        int len = str.length;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < len; i++){
            if(str[i] >= 'A' && str[i] <= 'Z') {
                sb.append(str[i]);
            }
            else if(str[i] == ')'){//괄호를 만났을 때
                while(!st.isEmpty() && st.peek() !='('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else if(str[i] == '('){
                st.add(str[i]);
            }
            else if(str[i] == '+' || str[i] == '-'){
                while(!st.isEmpty() && st.peek() !='('){
                    sb.append(st.pop());
                }
                st.add(str[i]);
            }
            else{
                if(!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) sb.append(st.pop());
                st.add(str[i]);
            }
        }//end for

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        

        System.out.println(sb);

    }
}
