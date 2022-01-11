package BackTracking;
import java.io.IOException;
import java.util.Scanner;

public class beakjoon15652 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static void DFS(int depth) throws IOException{
        if(depth == M){
            for(int i = 0 ; i < M; i ++){
                sb.append(arr[i] + " ");
                
            }
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= N; i++){
            if(depth == 0 || arr[depth-1] <= i){
                arr[depth] = i;
                DFS(depth+1);
            }
            
            
        }


    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        DFS(0);
        System.out.print(sb);
        sc.close();
    }
}
