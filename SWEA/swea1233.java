package SWEA_JAVA;
import java.io.*;
import java.util.*;
public class swea1233 {
    static int N;
    static char[] tree;
    static boolean solve(int node){
        if(node > N) return false;
        
        if(node * 2 > N){
            if(tree[node] >= '0' && tree[node] <= '9') return true;
            else return false;
        }
        else{
            if(node * 2 + 1 > N) return false;
            return solve(node * 2) && solve(node * 2 +1);
        }

    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//= new StringTokenizer(br.readLine());
    
        for(int t = 1; t <= 10; t++){
            N =Integer.parseInt(br.readLine());
            tree = new char[N+2];
            for(int i = 0 ; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                tree[idx] = st.nextToken().charAt(0); 
            }
            System.out.println("#" + t + " "+ (solve(1) ? 1 : 0));
        }
    }
}
