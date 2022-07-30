import java.util.*;
import java.io.*;

public class MessageRoutes {
    public static class Node{
        int label;
        int dis;
        ArrayList<Node> adj;
        boolean visited;
        Node prev;
        public Node(int id){
            label = id;
            dis = 0;
            adj = new ArrayList<>();
            visited = false;
        }

        public String toString(){
            return label+" "+dis+" "+visited;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int links = Integer.parseInt(st.nextToken());

        ArrayList<Node>graph = new ArrayList<>();

        for(int i = 0; i <= nodes;i++)
            graph.add(new Node(i));




        for(int i = 0; i < links;i++){
            st = new StringTokenizer(br.readLine());
            Node one = graph.get(Integer.parseInt(st.nextToken()));
            Node two = graph.get(Integer.parseInt(st.nextToken()));

            one.adj.add(two);
            two.adj.add(one);
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        graph.get(1).dis = 1;
        graph.get(1).visited = true;
        q.add(graph.get(1));
        while (!q.isEmpty()){
            Node root = q.poll();
            for(Node nxt : root.adj){
                if(!nxt.visited){
                    nxt.visited = true;
                    nxt.dis = root.dis+1;
                    nxt.prev = root;
                    q.add(nxt);
                }
            }
        }

        if(graph.get(nodes).dis == 0){
            pw.println("IMPOSSIBLE");
        }else{
            pw.println(graph.get(nodes).dis);
            ArrayList<Node> path = new ArrayList<>();
            Node point = graph.get(nodes);
            path.add(point);
            while(point.label != 1){
                point = point.prev;
                path.add(point);
            }

            for(int i = path.size()-1;i >= 0;i--){
                pw.print(path.get(i).label+" ");
            }

        }



        pw.close();
    }
}
