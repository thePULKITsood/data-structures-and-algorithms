import java.util.ArrayList;

public class graph {
    public static class Edge {
        int src, nbr, wt;

        Edge() {
            this(0, 0, 0);
        }

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;

        }

    }

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = new ArrayList[8];
        // har block pe jake aaray list ko initialize karna padega

        // har block pe jo array list bnai hai usko initialize karna hoga

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 10));
        graph[0].add(new Edge(0, 1, 10));

        for (int i =0 ;i<graph.length ; i ++ )
        {
            System.out.print(i + "  ");
            ArrayList <Edge> list = graph [i];
            for (Edge e : list )
            {
                System.out.print( e.nbr + " - " + e.nbr +  " @ " + e.wt  +  "   ,   ");
            }
            System.out.println();
        }

    }
}