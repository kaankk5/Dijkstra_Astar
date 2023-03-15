package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name="ZXFSDF";
    private double x;
    private double y;
    // parameters for the A* search
    private double g;
    private double h;
    private double f;
    // track the adjacency list (neighbors)
    private List<Edge> adjacencyList;
    // it tracks the previous node in the shortest path
    private Node parent;

    public Node(String name,int x,int y) {
        this.name=name;

        this.x = 0;
        this.y = 0;
        this.adjacencyList = new ArrayList<>();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbor(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }
}
