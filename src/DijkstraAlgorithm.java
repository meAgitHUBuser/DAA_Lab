class DijkstraAlgorithm {
     static final int VERTICES = 9;

     int getMinDistanceVertex(int dist[], Boolean shortestPathTreeSet[]) {
          int minDistance = Integer.MAX_VALUE, minIndex = -1;

          for (int v = 0; v < VERTICES; v++)
               if (!shortestPathTreeSet[v] && dist[v] <= minDistance) {
                    minDistance = dist[v];
                    minIndex = v;
               }

          return minIndex;
     }

     void printSolution(int dist[]) {
          System.out.println("Vertex \t Distance from Source");
          for (int i = 0; i < VERTICES; i++)
               System.out.println(i + " \t\t " + dist[i]);
     }

     void dijkstra(int graph[][], int src) {
          int[] dist = new int[VERTICES];
          Boolean[] shortestPathTreeSet = new Boolean[VERTICES];
          for (int i = 0; i < VERTICES; i++) {
               dist[i] = Integer.MAX_VALUE;
               shortestPathTreeSet[i] = false;
          }

          dist[src] = 0;

          for (int count = 0; count < VERTICES - 1; count++) {
               int u = getMinDistanceVertex(dist, shortestPathTreeSet);

               shortestPathTreeSet[u] = true;

               for (int v = 0; v < VERTICES; v++)
                    if (!shortestPathTreeSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                              && dist[u] + graph[u][v] < dist[v])
                         dist[v] = dist[u] + graph[u][v];
          }

          printSolution(dist);
     }

     public static void main(String[] args) {
          int graph[][] = new int[][] {
                    { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
          };

          DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
          dijkstra.dijkstra(graph, 0);
     }
}
