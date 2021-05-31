/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtree;

/**
 *
 * @author MGD
 */

public class RBTree {
    Node root;
    int size;
    public RBTree()
    {
        root = null;
        size = 0;
    }
    private void leftRotation(Node node)
    {
        //node not have right child
        if(node.right == null)
        {
            return;
        }
        //temp is right child
        Node temp = node.right;
        //right  of my node is left temp or RLnode
        node.right = temp.left;
        //if node is root temp will be root
        if(node.parent == null)
        {
            root = temp;
        }
        else if(node.parent.left == node)
        {
                node.parent.left = temp;
        }
        else
        {
                node.parent.right = temp;
        }
        temp.left = node;
    }
    private void rightRotation(Node node)
    {
        //node not have left child
        if(node.left == null)
        {
            return;
        }
        //temp is left child
        Node temp = node.left;
        //right  of my node is left temp or RLnode
        node.left = temp.right;
        //if node is root temp will be root
        if(node.parent == null)
        {
            root = temp;
        }
        else if(node.parent.left == node)
        {
                node.parent.left = temp;
        }
        else
        {
                node.parent.right = temp;
        }
        temp.right = node;
    }
    private Node sibile(Node node)
    {
        if(node == null )
        {
            return null;
        }
        else
        {
            Node p = node.parent;
            if(p != null)
            {
                if(node == p.left)
                {
                    return p.right;
                }
                else
                {
                    return p.left;
                }
            }
            else 
            {
                return null;
            }
        }
    }
    private Node uncle(Node node)
    {
        Node p = node.parent;
        if(node == root || node == null)
            return null;
        else
        {
            if (p != null)
                return this.sibile(p);
            else 
                return null;
        }
    }
    void fixViolation(Node root, Node pt) 
    { 
        Node parent_pt = null; 
        Node grand_parent_pt = null; 
      
        while ((pt != root) && (pt.color != 0) && (pt.parent.color == 1)) 
        { 
      
            parent_pt = pt.parent; 
            grand_parent_pt = pt.parent.parent; 
      
            /*  Case : A 
                Parent of pt is left child  
                of Grand-parent of pt */
            if (parent_pt == grand_parent_pt.left) 
            { 
      
                Node uncle_pt = grand_parent_pt.right; 
      
                /* Case : 1 
                   The uncle of pt is also red 
                   Only Recoloring required */
                if (uncle_pt != null && uncle_pt.color ==  
                                                       1) 
                { 
                    grand_parent_pt.color = 1; 
                    parent_pt.color = 0; 
                    uncle_pt.color = 0; 
                    pt = grand_parent_pt; 
                } 
      
                else
                { 
                    /* Case : 2 
                       pt is right child of its parent 
                       Left-rotation required */
                    if (pt == parent_pt.right) 
                    { 
                        leftRotation( parent_pt); 
                        pt = parent_pt; 
                        parent_pt = pt.parent; 
                    } 
      
                    /* Case : 3 
                       pt is left child of its parent 
                       Right-rotation required */
                    rightRotation(grand_parent_pt); 
                    swap(parent_pt.color,  
                               grand_parent_pt.color); 
                    pt = parent_pt; 
                } 
            } 
      
            /* Case : B 
               Parent of pt is right child  
               of Grand-parent of pt */
            else
            { 
                Node uncle_pt = grand_parent_pt.left; 
      
                /*  Case : 1 
                    The uncle of pt is also red 
                    Only Recoloring required */
                if ((uncle_pt != null) && (uncle_pt.color ==  
                                                        1)) 
                { 
                    grand_parent_pt.color = 1; 
                    parent_pt.color = 0; 
                    uncle_pt.color = 0; 
                    pt = grand_parent_pt; 
                } 
                else
                { 
                    /* Case : 2 
                       pt is left child of its parent 
                       Right-rotation required */
                    if (pt == parent_pt.left) 
                    { 
                        rightRotation(parent_pt); 
                        pt = parent_pt; 
                        parent_pt = pt.parent; 
                    } 
      
                    /* Case : 3 
                       pt is right child of its parent 
                       Left-rotation required */
                    leftRotation(grand_parent_pt); 
                    swap(parent_pt.color,  
                             grand_parent_pt.color); 
                    pt = parent_pt; 
                } 
            } 
        } 
      
        root.color = 0; 
    }      private void swap(int color, int color2) {
		// TODO Auto-generated method stub
    	int temp = color;
    	color = color2;
    	color2 = temp;
    	
		
	}
	private void insert(Node node, int item)
     {
        Node current = root;
        Node trailCurrent = new Node();
        Node newNode = new Node(item);
        if (root == null)
            root = newNode;
        else
        {
            current = root;

            while (current != null)
            {
                trailCurrent = current;

                if (current.key > item)
                    current = current.left;
                else
                    current = current.right;
            }
            if (trailCurrent.key > item)
            {
                trailCurrent.left = newNode;
                this.fixViolation(root, newNode);
            }
            else
            {
                trailCurrent.right = newNode;
                this.fixViolation(root, newNode);
            }
        }
     } 
    
    public void insert(int item) {
        if (this.root == null) {
            this.root = new Node(item);
        } else {
            this.insert(this.root, item);
        }
        this.root.color = 0;
        this.size++;     
    }
    /**
     * @param args the command line arguments
     */
    private void printHelper(Node root, String indent, boolean last) {
		// print the tree structure on the screen
	   	if (root != null) {
		   System.out.print(indent);
		   if (last) {
		      System.out.print("R----");
		      indent += "     ";
		   } else {
		      System.out.print("L----");
		      indent += "|    ";
		   }
            
           String sColor = root.color == 1?"RED":"BLACK";
		   System.out.println(root.key + "(" + sColor + ")");
		   printHelper(root.left, indent, false);
		   printHelper(root.right, indent, true);
		}
	}
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    	double hypot = Math.hypot(30, 60 - 10);
    	System.out.println(hypot);
    }
    
}

