/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtree;

/**
 *
 * @author Jena
 */
public class Node {
   int key;
   Node parent;
   Node right;
   Node left;
   int color;//0 black 1 red
   public Node() {}

    public Node(int key) {
        this.key = key;
        right = left = null;
        color = 1;
    }
    void flipColor()
    {
        if(color == 1)
            color = 0;
        else
            color = 1;
    }
}
