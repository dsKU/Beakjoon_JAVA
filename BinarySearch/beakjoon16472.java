package BinarySearch;
import java.io.*;
import java.util.*;

import javax.management.Query;


public class beakjoon16472 {
    static int N;

    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int [] num = new int[26];
        String str = br.readLine();
        int size = 0;
        int ans = 0;

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < str.length(); i++){
            int ch = str.charAt(i) - 'a';
            if(num[ch] == 0){
                if(size >= N){
                    while(size >= N){
                        int n = que.poll();
                        num[n]--;
                        if(num[n] == 0){
                            size--;
                        }
                    }
                }
                size++;
            }

            num[ch]++;
            que.add(ch);  
            ans = Math.max(ans, que.size());
        }

        System.out.println(ans);
    }
}
