package Math;
import java.util.*;


public class beakjoon1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        boolean[] visited = new boolean[N+1];
        for(int i = 3; i <= N; i+=2){
            if(visited[i]) continue;
            arr.add(i);
            int temp = i;
            while(temp <= N){
                visited[temp] = true;
                temp += i;
                
            }
            
        }

        int left = 0;
        int right = 1;
        int len = arr.size();
        int sum = 2;
        while(left < right){
             if(sum == N){
                ans++;
                sum -= arr.get(left);
                left++;
            }
            else if(sum > N || (right == len)){
                sum -= arr.get(left);
                left++;
            }
            else if(sum < N){
                sum += arr.get(right);
                right++;
            }
             
        }

        System.out.println(ans);
        sc.close();
    }
}
