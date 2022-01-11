package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beakjoon15659 {
    static int N;
    static int[] val;
    static int[] operaters;
    static int max_ = -1000000000;
    static int min_ = 1000000000;
    static ArrayList<Integer> oper;
    static ArrayList<Integer> number;

    static int culc(int a, int op, int b){
        if(op == 0){
            return a + b;
        }
        else if(op == 1){
            return a - b;
        }
        else if(op == 2){
            return a * b;
        }
        else{
            return a / b;
        }
    }

    static public void culc_result(){
        int result = number.get(0);
        for(int i = 0; i < oper.size(); i++){
            result = culc(result, oper.get(i), number.get(i+1));
        }
        max_ = Math.max(max_, result);
        min_ = Math.min(min_, result);
    } 

    static public void DFS(int idx, int result){
        if(idx == N){
            culc_result();
            return ;
        }

        for(int i = 0 ; i < 4; i++){
            if(operaters[i] > 0){
                operaters[i]--;
                if( i < 2){
                    number.add(val[idx]);
                    oper.add(i);
                    
                    DFS(idx+1,val[idx]);

                    number.remove(number.size()-1);
                    oper.remove(oper.size()-1);
                }
                else{
                    int temp = number.size()-1;
                    int pre_val = number.remove(temp);

                    int re = culc(pre_val, i, val[idx]);
                    number.add(re);
                    DFS(idx+1, result);
                    number.remove(temp);
                    number.add(pre_val);

                }
                operaters[i]++;
            }

        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        N = Integer.parseInt(st.nextToken());

        val = new int[N+1];
        operaters = new int[4];
        oper = new ArrayList<Integer>();
        number = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4; i++){
            operaters[i] = Integer.parseInt(st.nextToken());
        }


        number.add(val[0]);
        DFS(1, val[0]);

        System.out.println(max_);
        System.out.println(min_);

    }
}
