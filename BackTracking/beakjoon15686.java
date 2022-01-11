package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class point{
    public int x;
    public int y;
    public point(){
        this.x = 0;
        this.y = 0;
    }
    public point(int a, int b){
        this.x = a;
        this.y = b;
    }
}
public class beakjoon15686 {
    static int N;
    static int M;
    static int [][] distance; //ArrayList<Integer> distance = new ArrayList<Integer>();
    static ArrayList<point> customer = new ArrayList<point>();
    static ArrayList<point> store = new ArrayList<point>();
    static int[] visited;
    static int ans = Integer.MAX_VALUE;
    static public void DFS(int depth, int idx){
        if(depth == M){
            int temp_min = 0;
            for(int i = 0 ; i < customer.size(); i++){
                int dist = Integer.MAX_VALUE;
                for(int j = 0; j < M; j++){
                    dist = Math.min(dist, distance[i][visited[j]]);
                }
                temp_min += dist;
            }
            ans = Math.min(ans,temp_min);
            return;
        }

        for(int i = idx ; i < store.size() ; i ++){
            visited[depth] = i;
            DFS(depth+1, i);
            //visited[depth] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[M+1];

        for(int i = 0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1){
                    customer.add(new point(i,j));
                }
                if(val == 2){
                    store.add(new point(i,j));
                }
            }
        }

        distance = new int[customer.size()][store.size()];

        for(int i = 0 ; i < customer.size(); i ++){
            for(int j = 0; j < store.size() ; j++){
                int x = Math.abs(customer.get(i).x - store.get(j).x);
                int y = Math.abs(customer.get(i).y - store.get(j).y);

                distance[i][j] = x+y;
            }
        }
        
        DFS(0,0);
        System.out.println(ans);
    }

    
}
