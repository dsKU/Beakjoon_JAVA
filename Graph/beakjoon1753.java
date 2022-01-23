package Graph;
import java.io.*;
import java.util.*;

public class beakjoon1753 {
    static int V;
    static int E;
    static int start;
    static int[] min_;
    static ArrayList<Node1753>[] arr;

    static void Dijkstra(){
        PriorityQueue<Node1753> pQ = new PriorityQueue<>();

        pQ.offer(new Node1753(start,0));

        while(!pQ.isEmpty()){
            Node1753 Node1753 = pQ.poll();
            if(min_[Node1753.a] < Node1753.b) continue;

            for(Node1753 n : arr[Node1753.a]){
                if(min_[n.a] > min_[Node1753.a]+n.b){
                    min_[n.a] = min_[Node1753.a]+n.b;
                    pQ.offer(new Node1753(n.a, min_[n.a]));
                }
                
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        
        min_ = new int[V+1];
        arr = new ArrayList[V+1];

        for(int i = 1 ; i <= V; i++){
            min_[i] = 200001;
            arr[i] = new ArrayList<>();
        }
        min_[start] = 0;

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt(); 
            int c = sc.nextInt();
            
            arr[a].add(new Node1753(b,c));
        }

        Dijkstra();

        for(int i = 1; i <=V;i++){
            if(min_[i] >= 200001)
                System.out.println("INF");
            else
                System.out.println(min_[i]);
        }
        sc.close();
    }
}

class Node1753 implements Comparable<Node1753>{
    int a;
    int b;
    Node1753(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node1753 o) {
        return this.b - o.b;
    }
}