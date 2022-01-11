package Divide_And_Conquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon4256 {
    static int T;
    static int N;
    static int[] in;    //중위
    static int[] pre;   //전위
    static int[] post;  //후위
    static int[] index;

    static void DAC(int in_s, int in_e, int pre_s, int pre_e){
        if(in_s > in_e || pre_s > pre_e) return;
        int root = pre[pre_s];

        DAC(in_s, index[root] - 1, pre_s + 1, pre_s + (index[root] - in_s) );
        DAC(index[root] + 1, in_e, pre_s + (index[root] - in_s) + 1, pre_e);

        System.out.print(root+" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            in = new int[N+1];
            pre = new int[N+1];
            post = new int[N+1];
            index = new int[N+1];
            
    
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N; i++){
                pre[i] = Integer.parseInt(st.nextToken());
                
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N; i++){
                in[i] = Integer.parseInt(st.nextToken());
                index[in[i]] = i;
            }
            
    
            DAC(1, N, 1, N);
            System.out.println();
        }
        

    }
}
