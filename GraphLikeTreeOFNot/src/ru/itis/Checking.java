package ru.itis;

import java.io.FileInputStream;
import java.util.Scanner;

public class Checking {
    private int n;
    private int graph[][];
    private int countOfIteration = 0;
    private int usedPeaks[];
    private int edges = 0;
    private boolean checker;

   public boolean check (String fileName) throws Exception {
       FileInputStream inputStream = new FileInputStream(fileName);
       Scanner scanner = new Scanner(inputStream);
       this.n = scanner.nextInt();
       setGraph(new int[n][n]);
       setUsedPeaks(new int[n]);

       for(int i = 0; i < n; i++) {
           for(int j = 0; j < n; j++) {
               graph[i][j] = scanner.nextInt();
               edges += graph[i][j];
           }
       }
       edges /= 2;
       dfs(0);
       if(n == edges + 1 && countOfIteration == n) {
           return !checker;
       } else {
           return checker;
       }
   }

   private void dfs(int v) {
       usedPeaks[v] = 1;
       countOfIteration++;
       for(int i = 0; i < n; i++) {
           if(graph[v][i] == 1 && usedPeaks[i] == 0) {
               dfs(i);
           }
       }
   }
    private void setGraph(int[][] graph) {
        this.graph = graph;
    }

    private void setUsedPeaks(int[] usedPiks) {
        this.usedPeaks = usedPiks;
    }

    public boolean isChecker() {
        return checker;
    }


}
