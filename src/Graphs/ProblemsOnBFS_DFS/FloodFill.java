package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value
 * of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image
 * starting from the pixel image[sr][sc].
 *
 * To perform a flood fill:
 *
 * Begin with the starting pixel and change its color to color.
 * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
 * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
 * The process stops when there are no more adjacent pixels of the original color to update.
 * Return the modified image after performing the flood fill.
 * */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;
        int visited[][] = new int[n][m];

        // put the source in queue and mark it visited
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(sr,sc));
        visited[sr][sc]=1;

        while (!queue.isEmpty()){
            Cell cell = queue.poll();

            //visit all its unvisited neighbours whose color is same as the color of this cell.
            int colorOfCurrentCell = image[cell.x][cell.y];

            int row[]={-1,1,0,0};
            int col[]={0,0,-1,1};
            for (int i = 0; i < 4; i++) {
                int xCordinate = cell.x+row[i];
                int yCordinate = cell.y+col[i];

                if(xCordinate<n && yCordinate<m && xCordinate>=0 && yCordinate>=0 && image[xCordinate][yCordinate]==colorOfCurrentCell && visited[xCordinate][yCordinate]==0){
                    queue.offer(new Cell(xCordinate,yCordinate));
                    visited[xCordinate][yCordinate]=1;
                }
            }

            // now change the color of this current cell
            image[cell.x][cell.y]=color;
        }

        return image;

    }

    class Cell{
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
