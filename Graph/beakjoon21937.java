package Graph;
import java.io.*;
import java.util.*;

public class beakjoon21937 {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] indgree;
    static int[] count;
    static boolean[] visited;
    static int cnt = -1;
    static void DFS(int idx){
        cnt++;

        for(int i : list[idx]){
            if(visited[i])  continue;
            visited[i] = true;
            DFS(i);
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
            
        }
    
        int target = Integer.parseInt(br.readLine());
        DFS(target);
        System.out.println(cnt);


    }
}
