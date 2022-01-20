import java.io.*;
import java.util.*;

public class beakjoon13334 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
    

        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[N][2];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b){
                point[i][0] = b;
                point[i][1] = a;
            }
            else{
                point[i][0] = a;
                point[i][1] = b;   
            }
        }
        int d = Integer.parseInt(br.readLine());

        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1])
                    return a[0] - b[0];
                return a[1]- b[1];
            }
        });

        //배열의 정렬 기준 1. end 오름차순, 2. start 값 오름차순
        //1. ans = leftQ.size() leftQ = start값으로 오름차순 end로 오름차순

        PriorityQueue<int[]> leftQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return a[1] - b[1];
                return a[0]-b[0];
            }
        });
        
        int ans = 0;
        int right = point[0][1];
        int idx = 0;

        for(int i = idx ; i < N; i++){  //첫 좌표 탐색
            int dist = Math.abs(point[i][1] - point[i][0]);
            if(dist > d) continue;
            right = point[i][0] + d;
            ans++;
            idx = i;
            leftQ.add(point[i]);
            break;
        }

        for(int i = idx + 1 ; i < N; i++){
            int dist = Math.abs(point[i][1] - point[i][0]);
            if(dist > d) continue;
            if(point[i][1] > right){
                while(!leftQ.isEmpty()){
                    if(leftQ.peek()[0] + d >= point[i][1]){  
                        break;
                    }
                    leftQ.poll();
                }
            }
            
            leftQ.add(point[i]);
            right = leftQ.peek()[0] + d;
            ans = Math.max(ans, leftQ.size());
            
        }
        System.out.println(ans);

    }
}
