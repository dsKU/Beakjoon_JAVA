package DP;
import java.io.*;
import java.util.*;

public class beakjoon1351 {
    static long P,Q;
    static HashMap<Long,Long> DP = new HashMap<>();
    static long solve(long key){
        if(key == 0) return 1;
        if(DP.containsKey(key))return DP.get(key);
        long value = solve(key/P) + solve(key/Q);
        DP.put(key, value);
        return value;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        long N;
        N = Long.parseLong(st.nextToken());
        P =Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
    
        System.out.print(solve(N));
    }
}
