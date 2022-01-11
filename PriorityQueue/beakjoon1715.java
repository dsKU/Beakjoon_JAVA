package PriorityQueue;
import java.io.*;
import java.util.*;

public class beakjoon1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0;i < N; i++){
            pQ.add(Integer.parseInt(br.readLine()));
        }

        while(pQ.size() > 1){
            int a = pQ.poll();
            int b = pQ.poll();
            int re = a+b;
            pQ.add(re);
            result += re;
        }
        System.out.println(result);
    }
}
