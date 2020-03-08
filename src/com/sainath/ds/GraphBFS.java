package com.sainath.ds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphBFS {

    private Set<Graph.Node> markedNodes;
    private Graph graph;

    public GraphBFS(Graph graphToSearch) {
        markedNodes = new HashSet<>();
        this.graph = graphToSearch;
    }

    public boolean bfs(String elementToFind, Graph.Node start) {
        if (start == null) {
            return false;
        }

        if (!graph.containsNode(start)) {
            return false;
        }

        if (elementToFind.equals(start.getElement())) {
            System.out.println("Path: " + start.getElement());
            return true;
        }
        Queue<Graph.Node> queue = new LinkedList<>();
        markedNodes.add(start);
        queue.add(start);
        System.out.print("Path: " + start.getElement() + " => ");
        while (!queue.isEmpty()) {
            Graph.Node currentNode = queue.remove();
            for (Graph.Node neighbourNode : graph.getNeighbours(currentNode)) {
                if (!markedNodes.contains(neighbourNode)) {
                    if (elementToFind.equals(neighbourNode.getElement())) {
                        System.out.print(neighbourNode.getElement() + " ");
                        return true;
                    }
                    markedNodes.add(neighbourNode);
                    queue.add(neighbourNode);
                    System.out.print(neighbourNode.getElement() + " => ");
                }
            }
        }
        System.out.println();
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

        GraphBFS graphBFS = new GraphBFS(uGraph);

        System.out.println("\n" + graphBFS.bfs("Pune", mumbai));
    }
}
