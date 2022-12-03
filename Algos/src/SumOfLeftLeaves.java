package com.test.web3labs;


import java.util.Objects;

//  Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class SumOfLeftLeaves {
    private int sum;
    public int sumOfLeftLeaves(TreeNode root) {
         sum = 0;
        sumLeftLeaves(root, true);
         return sum;
    }

    private void sumLeftLeaves(TreeNode root, boolean leftNode) {
        if(Objects.isNull(root)) return;
        if(leftNode &&
                Objects.isNull(root.left) &&
                Objects.isNull(root.right)) sum += root.val;

        sumLeftLeaves(root.left, true);
        sumLeftLeaves(root.right, false);
    }

    public int sumNumbers(TreeNode root) {
        sumNumbersRootToLeaf(root, "");
        return sum;
    }

    public void sumNumbersRootToLeaf(TreeNode root, String value) {
        if(Objects.isNull(root)) return;
        value+= String.valueOf(root.val);

        if(Objects.isNull(root.left) &&
                Objects.isNull(root.right))  {

            sum += Integer.parseInt(value);
            value = value.substring(0, value.length() - 1);
        }
        sumNumbersRootToLeaf(root.left, value);
        sumNumbersRootToLeaf(root.right, value);
    }

    public static void main(String[] args) {
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumOfLeftLeaves.sumNumbers(root));
    }
}
