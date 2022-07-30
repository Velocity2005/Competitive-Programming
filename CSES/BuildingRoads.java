import java.util.*;
import java.io.*;

public class BuildingRoads {
    static int[] parent;
    static int[] rank;

    public static int find(int n){
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(rank[b] > rank[a]){
            int temp = a;
            a = b;
            b = temp;

        }
        parent[b] = a;
        if(rank[a] == rank[b])
            rank[a]++;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        parent = new int[node+1];
        for(int i = 1; i < parent.length;i++)
            parent[i] = i;
        rank = new int[node+1];
        int roads = Integer.parseInt(st.nextToken());
        ArrayList<Integer> nodes = new ArrayList<>();
        while(roads-->0){
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        }

        //pw.println(Arrays.toString(parent));
        for(int i = 1; i < parent.length;i++){
            if(parent[i] == i)
                nodes.add(i);
        }

        pw.println(nodes.size()-1);
        for(int i = 0; i < nodes.size()-1;i++){
            pw.println(nodes.get(i)+" "+nodes.get(i+1));
        }

        pw.close();
    }
}
