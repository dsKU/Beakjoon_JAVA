import java.util.*;

public class breakjoon1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min_ = sc.nextLong();
        long max_ = sc.nextLong();

        int limit_ = (int)Math.ceil(Math.sqrt((double)max_));
        int diff = (int) (max_ - min_);
        boolean[] sosu = new boolean[limit_ + 2];
        boolean[] visited = new boolean[diff+1];
        Arrays.fill(sosu, false);
        Arrays.fill(visited, false);
        
        
        for(int i = 2; i <= limit_; i++){ //제곱수 찾기 + min부터 에네토스테네스
            if(sosu[i] == false) {
                long temp =(long)i * (long)i;
                if(temp <= limit_) {
                    for(int j = i*i; j <= limit_; j+=i){
                        sosu[j] = true;
                    }
                }
                long temp2 = (long)Math.ceil((double)min_ / (double)temp) ;
                temp2*=temp;
                if(temp2 <= max_){
                    for(; temp2 <= max_; temp2+=temp){
                        visited[(int)(temp2 - min_)] = true;
                    }
                }
            }
        }

        long ans = 0L;
        for(int i = 0; i <= diff; i++){   
            if(!visited[i])ans++;
        }

        System.out.println(ans);
        sc.close();
    }
}
