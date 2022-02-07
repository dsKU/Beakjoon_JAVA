package implemented;
import java.io.*;
import java.util.*;

public class beakjoon2493 {
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int[] ans = new int[N];
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left.push(i);
        }

        while(!left.isEmpty()){
            right.push(left.pop());
            if(left.isEmpty()) break;
            else{
                while(!right.isEmpty() && arr[left.peek()] >= arr[right.peek()]){
                    ans[right.pop()] = left.size();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
