package com.sainath.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// Represent graph using Map<Node, Set<Edge>>
public abstract class Graph {
    protected static class Node {
        private String element;

        public Node(String name) {
            this.element = name;
        }

        public String getElement() {
            return element;
        }

        @Override
        public String toString() {
            return element;
        }
    }

    protected static class Edge {
        private final Node source;
        private final Node destination;
        private final int weight;

        public Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Node getSource() {
            return source;
        }

        public Node getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return weight == edge.weight &&
                    Objects.equals(source, edge.source) &&
                    Objects.equals(destination, edge.destination);
        }

        @Override
        public int hashCode() {
            return source.hashCode() + destination.hashCode() + weight;
        }

        @Override
        public String toString() {
            return source +
                    " to " + destination +
                    " distance " + weight + " km";
        }
    }

    private Map<Node, Set<Edge>> adjacencyMap;
    public int numEdges;
    public int numNodes;

    public Graph() {
        adjacencyMap = new HashMap<>();
        numEdges = 0;
        numNodes = 0;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public Map<Node, Set<Edge>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public boolean containsNode(Node node) {
        return adjacencyMap.containsKey(node);
    }

    public boolean addNode(Node node) {
        if (node == null || containsNode(node)) {
            return false;
        }

        Set<Edge> newAdjacencySet = new HashSet<>();
        adjacencyMap.put(node, newAdjacencySet);
        numNodes++;
        return true;
    }

    public Set<Node> getNeighbours(Node node) {
        if (!containsNode(node)) {
            return null;
        }

        Set<Edge> nodeEdges = adjacencyMap.get(node);
        Set<Node> neighbourNodes = new HashSet<>();

        for (Edge edge : nodeEdges) {
            Node neighbourNode = edge.getDestination();
            neighbourNodes.add(neighbourNode);
        }
        return neighbourNodes;
    }

    public abstract boolean addEdge(Node node1, Node node2, int weight);

    public abstract boolean removeEdge(Node node1, Node node2, int weight);

    public boolean addEdgeFromTo(Node source, Node destination, int weight) {
        Edge newEdge = new Edge(source, destination, weight);
        Set<Edge> sourceEdges = adjacencyMap.get(source);

        if (!sourceEdges.contains(newEdge)) {
            sourceEdges.add(newEdge);
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println(adjacencyMap);
    }

    public static void main(String[] args) {

    }
}

class UndirectedGraph extends Graph {

    @Override
    public boolean addEdge(Graph.Node node1, Graph.Node node2, int weight) {
        addNode(node1);
        addNode(node2);

        boolean isAddEdgeSuccess = addEdgeFromTo(node1, node2, weight) && addEdgeFromTo(node2, node1, weight);

        if (isAddEdgeSuccess) {
            numEdges++;
        }

        return isAddEdgeSuccess;
    }

    @Override
    public boolean removeEdge(Graph.Node node1, Graph.Node node2, int weight) {
        return false;
    }
}

class DirectedGraph extends Graph {

    @Override
    public boolean addEdge(Node node1, Node node2, int weight) {
        addNode(node1);
        addNode(node2);

        boolean isAddEdgeSuccess = addEdgeFromTo(node1, node2, weight);

        if (isAddEdgeSuccess) {
            numEdges++;
        }

        return isAddEdgeSuccess;
    }

    @Override
    public boolean removeEdge(Node node1, Node node2, int weight) {
        return false;
    }
}