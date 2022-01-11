package DP;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class beakjoon1516 {
    static public void topological_sort(int N, ArrayList<ArrayList<Integer>> arr, int[] indegree, int[] val){
        Queue<Integer> qu = new LinkedList<Integer>();
        int[] result = new int[N+1]; 

        for(int i = 1 ; i <= N;i++){
            result[i] = val[i];
            if(indegree[i] == 0){
                qu.offer(i);
            }
        }

        while(!qu.isEmpty()){
            int node = qu.poll();
            for(Integer i : arr.get(node)){
                result[i] = Math.max(result[i], result[node] + val[i]);
                indegree[i]--;
 
                if(indegree[i] == 0)
                    qu.offer(i);
            }
        }
        for(int i = 1 ; i <= N;i++){
            System.out.println(result[i]);
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] val = new int[N+1];
        int[] indegree = new int[N+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        int temp;

        for(int i = 0; i <= N ;i ++)
            arr.add(new ArrayList<Integer>());
            
        for(int i = 1; i <= N ;i ++){
            val[i] = sc.nextInt();
            
            while((temp = sc.nextInt()) != -1){
                arr.get(temp).add(i);
                indegree[i]++;
            }
        }
        topological_sort(N, arr, indegree, val);

        sc.close();
    }
}

