import java.util.*;
import java.io.*;

public class CountingRooms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        int[] r = {-1,1,0,0};
        int[] c = {0,0,-1,1};


        st = new StringTokenizer(br.readLine());
        int totalRow = Integer.parseInt(st.nextToken());
        int totalCol = Integer.parseInt(st.nextToken());
        char[][] grid = new char[totalRow][totalCol];
        boolean[][] visited = new boolean[totalRow][totalCol];
        int[][] id = new int[totalRow][totalCol];
        for(int i = 0; i < totalRow;i++)
            grid[i] = br.readLine().toCharArray();
        ArrayDeque<Point> nodes = new ArrayDeque<Point>();
        int idCount = 1;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == '.' && id[i][j] == 0){
                    Point Start = new Point(i,j);
                    nodes.add(Start);
                    visited[i][j] = true;
                    id[i][j] = idCount;
                    while(!nodes.isEmpty()){
                        Point current = nodes.poll();
                        for(int k = 0; k < 4;k++){
                            int nr = current.r+r[k];
                            int nc = current.c+c[k];
                            if(nr > -1 && nr < totalRow && nc > -1 && nc < totalCol && !visited[nr][nc] && grid[nr][nc] != '#'){
                                Point newP = new Point(nr,nc);
                                nodes.add(newP);
                                visited[nr][nc] = true;
                                id[nr][nc] = idCount;
                            }
                        }
                    }
                    idCount++;
                }

            }
        }

        pw.println(idCount-1);


        pw.close();
    }

    static class Point{int r,c; public Point(int rr, int cc){ r = rr; c = cc;}}


}

