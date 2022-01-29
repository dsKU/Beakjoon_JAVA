package DP;
import java.io.*;
import java.util.*;

public class beakjoon1102 {
    static int N,M;
    static int[][] map;
    static int[] DP;
    static int goal;
    static int ans = Integer.MAX_VALUE;
    static int bitCounter(int bit){
        int result = 0;
        while(bit != 0){
            bit = (bit & (bit - 1));
            result++;
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        DP = new int[1<<N];
        Arrays.fill(DP,100000);
        int bit = 0;
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String str = br.readLine();
        for(int i = 0 ; i < N; i++){
            char ch = str.charAt(i);
            if(ch == 'Y') 
                bit |= (1<<i);
        }

        goal = Integer.parseInt(br.readLine());
        if( bit == 0 && goal != 0) {
            System.out.println(-1);
            return;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        int [] t = {bit, 0};
        pq.add(t);
        while(!pq.isEmpty()){
            int[] node = pq.poll();

            if(bitCounter(node[0]) >= goal && ans > node[1]){
                ans = node[1];
                break;
            }
            
            for(int i = 0 ; i < N; i++){
                if((node[0] & (1 << i)) != (1<<i)) continue;
                
                for(int j = 0 ; j < N; j++){
                    if((node[0] & (1 << j)) == (1 << j) || DP[node[0] | (1 << j )] < node[1] + map[i][j]) continue;

                    DP[node[0] |( 1 << j)] = node[1] + map[i][j];
                    int[] temp = { (node[0] | (1 << j)) , DP[node[0] |( 1 << j)]};
                    pq.add(temp);
                }
            }
        }

        System.out.println(ans);
    }
}
