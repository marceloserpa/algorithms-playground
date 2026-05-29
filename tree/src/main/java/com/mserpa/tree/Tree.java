package com.mserpa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Node {
    int data;
    List<Node> children;

    Node(int x){
        data = x;
        children = new ArrayList<>();
    }
}


public class Tree {

    Node rootNode;

    public Tree(int root) {
        this.rootNode = new Node(root);
    }

    private Node searchParent(int[] parents) {
        Node parent = rootNode;
        for (int i = 0; i < parents.length; i++) {
            /**
            if (parent.data == parents[i]) {
                System.out.println("parent found");
                break;
            }*/

            // find in children list the new paret
            for (int j = 0; j < parent.children.size(); j++) {
                Node child = parent.children.get(j);

                if (child.data == parents[i]) {
                    parent = child;
                }
            }
        }
        return parent;
    }

    public void add(int value, int[] parents) {
        if(parents[0] != rootNode.data){
            throw new NoSuchElementException("Root is invalid.");
        }

        Node parent = searchParent(parents);
        System.out.println(" ");

        parent.children.add(new Node(value));

    }

}
