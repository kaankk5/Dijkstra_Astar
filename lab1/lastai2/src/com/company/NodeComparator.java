package com.company;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

    // node1 is smaller than node2 if node1.f < node2.f (f=g+h)

    @Override
    public int compare(Node o1, Node o2) {
        return Double.compare(o2.getF(),o1.getF());
    }
}
