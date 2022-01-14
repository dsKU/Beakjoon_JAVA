import java.io.*;
import java.util.*;

public class beakjoon5430 {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String command = br.readLine();
            int idx = Integer.parseInt(br.readLine());
            String arr_ori = br.readLine();
            if(idx == 0 && command.contains("D")){
                System.out.println("error");
                continue;
            }
            
            Deque<String> dq = new ArrayDeque<String>();
            String [] arr = arr_ori.substring(1, arr_ori.length()-1).split(",");

            for(String a : arr)
                dq.add(a);
            
            Boolean reverse = false; //0은 원점 1은 뒤집힘
            int i = 0;
            int len = command.length();

            while(i < len && !dq.isEmpty()){
                if(command.charAt(i) == 'R'){
                    reverse = !reverse;
                    i++;
                    continue;
                }
                
                if(reverse == true){
                    dq.pollLast();
                } 
                else {
                    dq.pollFirst();
                }
                    
                i++;
            }
            if(i != len){
                System.out.println("error");
                continue;
            }
            if(dq.isEmpty()){
                System.out.println("[]");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            if(reverse){
                while(!dq.isEmpty())
                    sb.append(dq.pollLast()+",");
            }
            else{
                while(!dq.isEmpty())
                    sb.append(dq.pollFirst()+",");
            }

            sb.setCharAt(sb.length()-1, ']');
            System.out.println(sb);
        }
    }
}
