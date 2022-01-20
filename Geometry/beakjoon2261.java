import java.io.*;
import java.util.*;

public class beakjoon2261 { 
    static int distance(int[] a, int[] b){
        return (int)Math.pow((b[0] - a[0]),2) + (int)Math.pow((b[1] - a[1]),2);
    }
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

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
                    return a[1]-b[1];
                return a[0]-b[0];
            }
        });

        int idx = 0;
        int ans = distance(point[0], point[1]);
        TreeSet<int[]> list = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[1]==b[1])
                return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        list.add(point[0]);
        list.add(point[1]);
        
        for(int i = 2; i < N; i++){
            int temp = (int)Math.sqrt(ans) + 1;
            while(idx < i) {
                int diff = point[i][0] - point[idx][0];
                if(diff * diff >= ans){     
                    list.remove(point[idx]);
                    idx++;
                    
                }
                else break;
            }

            int[][] min_ = {{-100000, point[i][1]-temp},{100000,point[i][1] + temp}};
            TreeSet<int[]> sub = (TreeSet<int[]>)list.subSet(min_[0], min_[1]);

            for(int[] j : sub){
                ans = Math.min(ans, distance(point[i], j));
            }

            list.add(point[i]);
        }

        System.out.println(ans);
    }
}

