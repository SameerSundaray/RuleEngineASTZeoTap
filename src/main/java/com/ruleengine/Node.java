package com.ruleengine;

public class Node {
    public String type;  
    public Node left;     
    public Node right;   
    public Object value;  

    public Node(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Node(String type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }
}
