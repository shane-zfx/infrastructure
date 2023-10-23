package com.unidt.entity;

/**
 * @author: shane
 * @date: 2023-10-23 16:13:26
 * @version: 1.0
 */
public class TreeNode<T> {

    private TreeNode<T> root;
    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
    }


}
