package com.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

public class BinaryTreeOperations {

    public Node insertNode(int val, Node root) {
        Node newNode = new Node(val);
        if (root == null) {
            return newNode;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node removedNode = null;
        while (!queue.isEmpty()) {
            removedNode = queue.poll();
            Node left = removedNode.getLeft();
            Node right = removedNode.getRight();
            if (left == null) {
                removedNode.setLeft(newNode);
                break;
            } else {
                queue.add(left);
            }
            if (right == null) {
                removedNode.setRight(newNode);
                break;
            } else {
                queue.add(right);
            }
        }
        return root;
    }

    public void deleteNode(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getVal() == key) {
                root = null;
                return;
            } else {
                return;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node keyNode = null;
        Node removedNode = null;
        while (!queue.isEmpty()) {
            removedNode = queue.poll();
            if (removedNode.getVal() == key) {
                keyNode = removedNode;
            }
            Node left = removedNode.getLeft();
            Node right = removedNode.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        if (keyNode != null) {
            keyNode.setVal(removedNode.getVal());
            deleteDeepestNode(root, removedNode);
        }

    }

    private void deleteDeepestNode(Node root, Node lastNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node removedNode = null;
        while (!queue.isEmpty()) {
            removedNode = queue.poll();
            if (removedNode == lastNode) {
                removedNode = null;
                return;
            }

            if (removedNode.left != null) {
                if (removedNode.left == lastNode) {
                    removedNode.left = null;
                    return;
                } else {
                    queue.add(removedNode.left);
                }
            }
            if (removedNode.right != null) {
                if (removedNode.right == lastNode) {
                    removedNode.right = null;
                } else {
                    queue.add(removedNode.right);
                }
            }
        }


    }

    public void inorderTraveralRecursive(Node root) {
        if (root == null) {
            return;
        }
        inorderTraveralRecursive(root.getLeft());
        System.out.print(root.getVal() + " ");
        inorderTraveralRecursive(root.getRight());
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node removedNode = queue.poll();
            System.out.print(removedNode.getVal() + " ");
            if (removedNode.left != null) {
                queue.add(removedNode.left);
            }
            if (removedNode.right != null) {
                queue.add(removedNode.right);
            }
        }
    }

    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.getVal() == key) {
            return true;
        }
        return search(root.getLeft(), key) || search(root.getRight(), key);
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiamter = diameter(root.left);
        int rdiameter = diameter(root.right);
        return Math.max(Math.max(ldiamter, rdiameter), lheight + rheight + 1);
    }

    public void reverseLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        int h = height(root);
        for (int i = h; i > 0; i--) {
            printIthLevel(root, i);
        }
    }

    public void reverseLevelOrderOptimized(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node removedNode = queue.poll();
            stack.push(removedNode);
            if (removedNode.right != null) {
                queue.add(removedNode.right);
            }
            if (removedNode.left != null) {
                queue.add(removedNode.left);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }

    }

    private void printIthLevel(Node root, int i) {
        if (root == null) {
            return;
        }
        if (i == 1) {
            System.out.print(root.val + " ");
        } else if (i > 1) {
            printIthLevel(root.left, i - 1);
            printIthLevel(root.right, i - 1);
        }
    }

    public Node mirrorTree(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public boolean heightBalancedTree(Node root) {
        if (root == null) {
            return true;
        }
        if (!heightBalancedTree(root.left)) {
            return false;
        }
        if (!heightBalancedTree(root.right)) {
            return false;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    boolean flag = true;

    public boolean heightBalancedTreeOptimized(Node root) {
        if (root == null) {
            return true;
        }
        heightBalancedTreeOptimizedHelper(root);
        return flag;
    }

    private int heightBalancedTreeOptimizedHelper(Node root) {
        if (root == null) {
            return 0;
        }
        int leftTree = heightBalancedTreeOptimizedHelper(root.left);
        int rightTree = heightBalancedTreeOptimizedHelper(root.right);

        int max = 1 + Math.max(leftTree, rightTree);
        if (Math.abs(leftTree - rightTree) > 1) {
            flag = false;
        }
        return max;
    }

    public void inorderTraveralInterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        stack.push(currNode);
        currNode = currNode.left;
        while (currNode != null || !stack.isEmpty()) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                Node removedNode = stack.pop();
                System.out.print(removedNode.val + " ");
                currNode = removedNode.right;
            }
        }
    }

    public void postorderTraversalIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        s1.push(root);
        Stack<Node> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Node removedNode = s1.pop();
            s2.push(removedNode);
            if (removedNode.left != null) {
                s1.push(removedNode.left);
            }
            if (removedNode.right != null) {
                s1.push(removedNode.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    @Test
    public void insertNodeTest() {
        Node root = new Node(2);
        root.setLeft(new Node(3));
        root.setRight(new Node(4));
        root.getLeft().setLeft(new Node(5));
        root.getLeft().setRight(new Node(6));
        //before
        inorderTraveralRecursive(root);//5,3,6,2,4
//        2
//       / \
//      3   4
//     / \
//     5  6
        System.out.println("\n");
        //after
        inorderTraveralRecursive(insertNode(7, root));//5,3,6,2,7,4
        System.out.println();
        inorderTraveralInterative(root);
    }

    @Test
    public void deleteNodeTest() {
        Node root = new Node(2);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(8, root);
        insertNode(9, root);
        //before
        inorderTraveralRecursive(root);
        deleteNode(root, 2);
        System.out.println("\n");
        //after
        inorderTraveralRecursive(root);
    }

    @Test
    public void levelOrderTraversalTest() {
        Node root = new Node(2);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(8, root);
        insertNode(9, root);

        levelOrderTraversal(root);
    }

    @Test
    public void searchTest() {
        Node root = new Node(2);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(8, root);
        insertNode(9, root);

        Assert.assertTrue(search(root, 9));
    }

    @Test
    public void heightTest() {
        Node root = new Node(2);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(8, root);
        insertNode(9, root);
        insertNode(19, root);
        insertNode(92, root);
        insertNode(94, root);
        insertNode(95, root);

        Assert.assertEquals(4, height(root));
    }

    @Test
    public void diameterTest() {
        Node root = new Node(2);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(8, root);
        insertNode(9, root);
        insertNode(19, root);
        insertNode(92, root);
        insertNode(94, root);
        insertNode(95, root);

        Assert.assertEquals(7, diameter(root));
    }

    @Test
    public void reverseLevelOrderTest() {
        Node root = new Node(2);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(8, root);
        insertNode(9, root);
        insertNode(19, root);
        insertNode(92, root);
        insertNode(94, root);
        insertNode(95, root);

        reverseLevelOrder(root);
        //9,19,92,94,95,5,6,7,8,3,4,
        System.out.println();
        reverseLevelOrderOptimized(root);
    }

    @Test
    public void mirrorTreeTest() {
        Node root = new Node(1);
        insertNode(3, root);
        insertNode(2, root);
        insertNode(5, root);
        insertNode(4, root);
        //before
        levelOrderTraversal(root);
        System.out.println();
        mirrorTree(root);
        //after
        levelOrderTraversal(root);
    }

    @Test
    public void postOrderTest() {
        Node root = new Node(1);
        insertNode(2, root);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);

        postorderTraversalIterative(root);
    }

}
