import java.io.*;
import java.util.*;

public class beakjoon1708 {
    static int N,M;
    static node[] point;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        point = new node[N];
        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            point[i] = new node(a, b);
        }
        Arrays.sort(point);

        

    }
    static long ccw(node a, node b, node c){
        return (b.x - a.x)*(c.y-a.y) - (c.x - a.x) * (b.y - a.y);
    }
    static class node implements Comparable<node>{
        long y, x;
        public node(int a, int b){
            y = a;
            x = b;
        }

        @Override
        public int compareTo(node o) {
            return this.y == o.y ? (int)(this.x - o.x) : (int)(this.y - o.y);
        }
    }
}
