package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon1781 {
    static int N;
    static node1781[] arr;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        arr = new node1781[N];
        
        for(int i =0  ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] =  new node1781(d, c);
        }

        Arrays.sort(arr, (a, b)-> b.dead - a.dead);
        PriorityQueue<node1781> pq = new PriorityQueue<>((a, b)-> b.cup - a.cup);
        
        int idx = 0;
        int deadline = N;
        int ans = 0;
        while(deadline > 0){

            while(idx < N && arr[idx].dead == deadline){
                pq.add(arr[idx++]);
            }

            if(pq.isEmpty()){
                deadline = arr[idx].dead;
                while(arr[idx].dead == deadline){
                    pq.add(arr[idx++]);
                }
            }

            //System.out.println(deadline + " "+pq.peek().dead + " " + pq.peek().cup);
            ans += pq.poll().cup;
            deadline--;
        
        }

        System.out.println(ans);
    }
}
class node1781{
    int dead;
    int cup;
    public node1781(int d, int c){
        dead = d;
        cup = c;
    }
}