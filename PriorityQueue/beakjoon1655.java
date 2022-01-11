package PriorityQueue;
import java.io.*;
import java.util.*;


public class beakjoon1655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Integer> min_pQ = new PriorityQueue<>();
        PriorityQueue<Integer> max_pQ = new PriorityQueue<>(Comparator.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++){
            int a = Integer.parseInt(br.readLine());

            if(max_pQ.size() == min_pQ.size()){
                max_pQ.add(a);
                
                if(!min_pQ.isEmpty() && max_pQ.peek() > min_pQ.peek()){
                    min_pQ.add(max_pQ.poll());
                    max_pQ.add(min_pQ.poll());
                }
            }
            else{
                min_pQ.add(a);

                if(max_pQ.peek() > min_pQ.peek()){
                    min_pQ.add(max_pQ.poll());
                    max_pQ.add(min_pQ.poll());
                }
            }  
            sb.append(max_pQ.peek() + "\n");
        }
        System.out.println(sb);
    }
}
