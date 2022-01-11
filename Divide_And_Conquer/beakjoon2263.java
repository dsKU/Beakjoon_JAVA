package Divide_And_Conquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon2263 {
    static int T;
    static int N;
    static int[] in;    //중위
    static int[] pre;   //전위
    static int[] post;  //후위
    static int[] index;

    static void DAC(int in_s, int in_e, int post_s, int post_e){
        if(in_s > in_e || post_s > post_s) return;

        int root = post[post_e];
        System.out.print(root + " ");

        //DAC(in_s, index[root] - 1, post_s, post_e - index[root]);
        //DAC(index[root] + 1, in_e, post_e - index[root] + 1, post_e - 1);
        DAC(in_s, index[root] - 1, post_s, post_s +(index[root] - in_s) -1);
        DAC(index[root] + 1, in_e, post_s + (index[root]-in_s), post_e - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        in = new int[N+1];
        pre = new int[N+1];
        post = new int[N+1];
        index = new int[N+1];
        

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            in[i] = Integer.parseInt(st.nextToken());
            index[in[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            post[i] = Integer.parseInt(st.nextToken());
            
        }
        

        DAC(1, N, 1, N);

    }
}
