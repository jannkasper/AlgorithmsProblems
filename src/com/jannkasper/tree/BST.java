package com.jannkasper.tree;
class Node {
    int value;
    Node leftNode;
    Node rightNode;

    public Node(int value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }
}
public class BST {

    Node root = null;

    public Node insert (int value){
        Node createdNode = new Node(value);
        if (root == null) {
            root = createdNode;
            return createdNode;
        }

        Node currentNode = root;
        while ((value < currentNode.value && currentNode.leftNode != null) || (value >= currentNode.value && currentNode.rightNode != null)) {
            if (value < currentNode.value) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        if (value < currentNode.value) {
            currentNode.leftNode = createdNode;
            System.out.println("LEFT: " + value);
        } else {
            currentNode.rightNode = createdNode;
            System.out.println("RIGHT: " + value);
        }

        return createdNode;
    }

    public boolean search (int value) {
        Node currentNode = root;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            if (value < currentNode.value) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }

        return false;
    }

    public static void main (String[] arg) {
        BST tree = new BST();

        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(25);
        tree.insert(8);
        tree.insert(12);

        System.out.println("Is number 8 in tree?: " + tree.search(8));


    }
}
