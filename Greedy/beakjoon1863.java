package Greedy;
import java.io.*;
import java.util.*;

public class beakjoon1863 {
    static int N;
    static int[] building;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        building = new int[N+1];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            building[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i = 0 ; i <= N; i++){
            while(!s.isEmpty() && building[i] < s.peek()){
                ans ++;
                s.pop();
            }
            if(!s.isEmpty() && building[i] == s.peek()) continue;

            s.add(building[i]);
        }

        System.out.println(ans);

    }
}
