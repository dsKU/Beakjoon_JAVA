package implemented;
import java.io.*;
import java.util.*;

public class beakjoon16926 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        int count = Math.min(N, M) / 2; 
		for(int i=0; i<K; i++) {
			
			for(int j=0; j<count; j++) { 
				int temp = map[j][j]; 
				
				for(int k=j+1; k<M-j; k++)
                    map[j][k-1] = map[j][k];
				
				for(int k=j+1; k<N-j; k++)
                    map[k-1][M-1-j] = map[k][M-1-j];
				
				for(int k=M-2-j; k>=j; k--)
                    map[N-1-j][k+1] = map[N-1-j][k];
				
				for(int k=N-2-j; k>=j; k--)
                    map[k+1][j] = map[k][j];
				
                map[j+1][j] = temp;
			}
		}
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
