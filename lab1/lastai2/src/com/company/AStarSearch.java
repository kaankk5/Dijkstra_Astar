package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearch {
    private double totalcost=0;
    private Node source;
    private Node destination;
    private Set<Node> explored;
    private PriorityQueue<Node> queue;

    public AStarSearch(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
        this.explored = new HashSet<>();
        this.queue = new PriorityQueue<>(new NodeComparator());
    }

    public void run() {
        queue.add(source);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            explored.add(current);
            // we have found the destination node
            if(current == destination)
                continue;
            // consider the adjacent nodes
            for(Edge edge : current.getAdjacencyList()) {
                Node child = edge.getTarget();
                double cost = edge.getWeight();
                double tempG = current.getG() + cost;
                double tempF = tempG + heuristic(current, destination);
                // if we have not considered the child and the f(x) is lower
                if(explored.contains(child) && tempF <= child.getF()) {
                    continue;
                }
                // else if we have not visited OR the f(x) score is higher
                else if(!queue.contains(child) || tempF > child.getF()) {
                    // this is how we can track the shortest path (predecessor)
                    child.setParent(current);
                    child.setG(tempG);
                    child.setF(tempF);
                    // we have it in the queue but now we have a higher value
                    // instead of update - we remove and reinsert again
                    if(queue.contains(child))
                        queue.remove(child);
                    queue.add(child);
                }
            }
        }
    }

    //I did not implement any heuristics for this lab so its 0.And I will write my report why I did not implement it.


    private double heuristic(Node node1, Node node2) {
        return 0;
    }

    public void printSolutionPath() {
        double totalcost=0;
        int counter=0;

        List<Node> path = new ArrayList<>();


        for(Node node=destination;node!=null;node=node.getParent()) {

            path.add(node);
        }

        Collections.reverse(path);
        //I reversed the list for a path.But Actually Im not give a spesific name to nodes.But you can see size or how many nodes we have.
        System.out.println("Total distance : "+destination.getF());



    }




}










