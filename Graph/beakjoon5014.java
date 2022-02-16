package Graph;
import java.io.*;
import java.util.*;

public class beakjoon5014 {
    static int F,S,G,U,D;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[100_0001];

        F = Integer.parseInt(st.nextToken());   //최대층수
        S = Integer.parseInt(st.nextToken());   //현위치
        G = Integer.parseInt(st.nextToken());   //목표
        U = Integer.parseInt(st.nextToken());   //한 번에 위로 올라가는 수
        D = Integer.parseInt(st.nextToken());   //한 번에 밑으로 내려가는 수
        Arrays.fill(arr, 100_0001);

        arr[S] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(S);

        while(!que.isEmpty()){
            int floor = que.poll();

            if(floor + U <= F  && arr[floor + U] > arr[floor] + 1 ) {
                que.add(floor + U);
                arr[floor + U] = arr[floor] + 1;
            }
            
            if(floor - D > 0  && arr[floor - D] > arr[floor] + 1 ){
                que.add(floor - D);
                arr[floor - D] = arr[floor] + 1;
            }
            
        }
        if(arr[G] >= 100_0001)System.out.println("use the stairs");
        else System.out.println(arr[G]);
    }
}
