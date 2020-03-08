package com.sainath.ds;

import java.util.HashSet;
import java.util.Set;

public class GraphDFS {
    private Set<Graph.Node> visitedNodes;
    private Graph graph;

    public GraphDFS(Graph graphToSearch) {
        this.visitedNodes = new HashSet<>();
        graph = graphToSearch;
    }

    public boolean dfs(String elementToSearch, Graph.Node node) {
        if (node == null || !graph.containsNode(node)) {
            return false;
        }

        if (node.getElement().equals(elementToSearch)) {
            return true;
        }

        visitedNodes.add(node);
        for (Graph.Node neighbourNode : graph.getNeighbours(node)) {
            visitedNodes.add(neighbourNode);
            System.out.print(neighbourNode.getElement() + " => ");
            if (dfs(elementToSearch, neighbourNode)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraph uGraph = new UndirectedGraph();

        Graph.Node mumbai = new Graph.Node("Mumbai");
        Graph.Node thane = new Graph.Node("Thane");
        Graph.Node pune = new Graph.Node("Pune");
        Graph.Node naviMumbai = new Graph.Node("Navi Mumbai");

        uGraph.addNode(mumbai);
        uGraph.addNode(thane);
        uGraph.addNode(pune);
        uGraph.addNode(naviMumbai);

        /*
                        Mumbai
                      /         \
             Navi Mumbai   --   Thane
                    \           /
                         Pune
         */

        uGraph.addEdge(mumbai, naviMumbai, 30);
        uGraph.addEdge(mumbai, thane, 25);
        uGraph.addEdge(thane, naviMumbai, 10);
        uGraph.addEdge(thane, pune, 100);
        uGraph.addEdge(naviMumbai, pune, 80);

        GraphDFS graphDFS = new GraphDFS(uGraph);
        System.out.println("\n" + graphDFS.dfs("Pune", mumbai));
    }
}
