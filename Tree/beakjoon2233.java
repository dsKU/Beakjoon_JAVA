package Tree;
import java.io.*;
import java.util.*;
public class beakjoon2233 {
    static int N;
    static int a,b;
    static int[] parents;
    static int[] depth;
    static int[][] ij;
    static int[] node = new int[2];
    static void setTree(String str){
        int len = str.length();

        int parent = 0;
        int idx = 1;
        int nodeIdx = 0;
        for(int i = 0 ; i < len; i++){
            char ch = str.charAt(i);
            if(ch == '0'){
                if(i == a || i == b){
                    node[nodeIdx++] = idx;
                }
                depth[idx] = depth[parent] + 1;
                parents[idx] = parent;
                parent = idx;
                ij[idx][0] = i;
                idx++;
            }
            else{
                if(i == a || i == b){
                    node[nodeIdx++] = parent;
                }
                ij[parent][1] = i;
                parent = parents[parent];
                
            }
        }
    }
    static int find(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a; a = b; b = temp;
        }

        while(depth[a] != depth[b]) a = parents[a];

        while(a != b){
            a = parents[a];
            b = parents[b];
        }

        return a;
        
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken())-1;
        b = Integer.parseInt(st.nextToken())-1;

        parents = new int[N+1];
        ij = new int[N+1][2];
        depth = new int[N+1];
        setTree(str);
        int idx = find(node[0], node[1]);

        System.out.println(++ij[idx][0] + " " + ++ij[idx][1]);
    }
}
