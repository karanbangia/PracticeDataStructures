package com.trees;

import org.junit.Test;

import java.util.*;

class QueuObj {
    Node node;
    int hd;
    QueuObj(Node node,int hd)
    {
        this.node=node;
        this.hd=hd;
    }

}
public class TopView {
    public List<Integer> view(Node root)
    {
        if(root==null)return null;
        Queue<QueuObj> q=new LinkedList<>();
        Map<Integer,Integer> hm=new TreeMap<>(Collections.reverseOrder());
        q.add(new QueuObj(root,0));
        while(!q.isEmpty())
        {
            QueuObj removed=q.poll();
            if(!hm.containsKey(removed.hd))
            {
                hm.put(removed.hd,removed.node.val);
            }
            if(removed.node.left!=null)
            {
                q.add(new QueuObj(removed.node.left,removed.hd+1));
            }
            if(removed.node.right!=null)
            {
                q.add(new QueuObj(removed.node.right,removed.hd-1));
            }
        }
        List<Integer> ret=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:hm.entrySet())
        {
            ret.add(entry.getValue());
        }
        return  ret;
    }
    @Test
    public void reverseLevelOrderTest() {
        Node root = new Node(2);
        BinaryTreeOperations operations = new BinaryTreeOperations();
        operations.insertNode(3, root);
        operations.insertNode(4, root);
        operations.insertNode(5, root);
        operations.insertNode(6, root);
        operations.insertNode(7, root);
        operations.insertNode(8, root);
        operations.insertNode(9, root);
        operations.insertNode(19, root);
        operations.insertNode(92, root);
        operations.insertNode(94, root);
        operations.insertNode(95, root);

        view(root).forEach(System.out::println);
        //9,19,92,94,95,5,6,7,8,3,4,

    }
}
