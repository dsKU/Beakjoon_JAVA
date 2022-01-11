package TopologicalSort;
import java.io.*;
import java.util.*;

public class beakjoon1766 {
    static StringBuilder sb;
    static int N,M;
    static ArrayList<Integer>[] arr;
    static int[] indgree;

    static void sort(){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 1; i <= N;i++){
            if(indgree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int idx = queue.poll();
            sb.append(idx+" ");
            
            for(Integer i : arr[idx]){
                indgree[i]--;
                if(indgree[i] == 0){
                    queue.offer(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        indgree = new int[N+1];
        sb = new StringBuilder();

        for(int i = 0 ; i <= N; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            indgree[b] ++;
        }

        sort();
        System.out.println(sb.toString());
    }
}

//문제번호가 작은 순이기 때문에 우선순위큐를 사용해서 큐에 들어가는 문제 중 작은 것들 먼저 풀이
