import java.io.*;
import java.util.*;


public class beakjoon2170 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
    

        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[N][2];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return b[1] - a[1];
                return a[0]-b[0];
            }
        });


        int ans = 0;
        int left = point[0][0];
        int right = point[0][1];
        for(int i = 1 ; i < N; i++){
            if(point[i][1] <= right) continue;
            if(point[i][0] <= right){
                right = point[i][1];
            } 
            else{
                ans += Math.abs(right - left);
                left = point[i][0];
                right = point[i][1];
            }
        }
        ans += Math.abs(right - left);
        System.out.println(ans);
    }
}
