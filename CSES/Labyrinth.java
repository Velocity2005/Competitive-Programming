import java.util.*;
import java.io.*;

public class Labyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        int[] r = {1,-1,0,0};
        int[] c = {0,0,1,-1};


        st = new StringTokenizer(br.readLine());
        int tRow = Integer.parseInt(st.nextToken());
        int  tCol = Integer.parseInt(st.nextToken());
        char[][] grid = new char[tRow][tCol];
        boolean[][] visited = new boolean[tRow][tCol];
        int[][] distance = new int[tRow][tCol];
        int[][] direction = new int[tRow][tCol];

        ArrayDeque<Point> bfs = new ArrayDeque<Point>();
        Point start;
        int startR = 0;
        int startC=0;
        int endR=0;
        int endC = 0;
        for(int i = 0; i < grid.length;i++)
            grid[i] = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < grid.length;i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'A') {
                    startR = i;
                    startC = j;
                    visited[i][j] = true;
                    bfs.add(new Point(startR,startC));
                    distance[i][j] = 0;
                }
                if(grid[i][j] == 'B') {
                    endR = i;
                    endC = j;
                }
            }
        }



        while(!bfs.isEmpty()) {
            Point current = bfs.poll();
            for(int i = 1; i < 5; i++){
                int nr = current.r+r[i-1];
                int nc = current.c+c[i-1];
                while(nr>-1 && nr < tRow && nc > -1 && nc < tCol && !visited[nr][nc] && grid[nr][nc] != '#'){
                    bfs.add(new Point(nr,nc));
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[current.r][current.c]+1;
                    direction[nr][nc] = i;

                }
            }
        }

        ArrayDeque<Point> backitup = new ArrayDeque<Point>();
        backitup.add(new Point(endR,endC));
        while(!backitup.isEmpty()){
            Point current = backitup.poll();
            int cR = current.r;
            int cC = current.c;
            if(direction[cR][cC] == 2) {
                sb.append("U");
                backitup.add(new Point(cR+1,cC));
            }else if(direction[cR][cC] == 1){
                sb.append("D");
                backitup.add(new Point(cR-1,cC));
            }else if(direction[cR][cC] == 3){
                sb.append("R");
                backitup.add(new Point(cR,cC-1));
            }else if(direction[cR][cC] == 4){
                sb.append("L");
                backitup.add(new Point(cR,cC+1));
            }else{
                break;
            }

        }



        if(visited[endR][endC]) {
            pw.println("YES");
            pw.println(distance[endR][endC]);
            pw.println(sb.reverse().toString());
        }else {
            pw.println("NO");
        }


        pw.close();
    }

    static class Point{int r,c; public Point(int rr, int cc){ r = rr; c = cc;}}
}
