package implemented;

import java.io.*;
import java.util.*;

public class beakjoon17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        int N;
        N = Integer.parseInt(st.nextToken());
        int[] val = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> NGE = new Stack<>();
        Stack<Integer> num = new Stack<>();
        NGE.push(val[N-1]);
        num.push(-1);

        for(int i = N-2; i >= 0; i--){
            while(!NGE.isEmpty() && NGE.peek() <= val[i]){
                NGE.pop();
            }     

            if(NGE.isEmpty()) num.push(-1);
            else{

                num.push(NGE.peek());
            }

            NGE.push(val[i]);
        }

        
        
        while(!num.isEmpty()){
            bw.write(num.pop() + " ");
        }
        bw.flush();
        bw.close();
    }
}
