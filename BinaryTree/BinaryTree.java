//This class contains the methods for the BinaryTree class.
//For the lab Exercise 1, you need to complete the TO-DO methods
package CSCI2110.Lab6;

import java.util.ArrayList;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree() {
		parent = left = right = null;
		data = null;
	}

	public void makeRoot(T data) {
		if (!isEmpty()) {
			System.out.println("Can't make root. Already exists");
		} else
			this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree) {
		left = tree;
	}

	public void setRight(BinaryTree<T> tree) {
		right = tree;
	}

	public void setParent(BinaryTree<T> tree) {
		parent = tree;
	}

	public T getData() {
		return data;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void attachLeft(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (left != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (right != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft != null)
			retLeft.setParent(null);
		return retLeft;
	}

	public BinaryTree<T> detachRight() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retRight = right;
		right = null;
		if (retRight != null)
			retRight.setParent(null);
		return retRight;
	}

	public boolean isEmpty() {
		if (data == null)
			return true;
		else
			return false;
	}

	public void clear() {
		left = right = parent = null;
		data = null;
	}

	public BinaryTree<T> root() {
		if (parent == null)
			return this;
		else {
			BinaryTree<T> next = parent;
			while (next.getParent() != null)
				next = next.getParent();
			return next;
		}
	}

	// this method returns the number of nodes/trees in a BinaryTree
	public static <T> int nodes(BinaryTree<T> t) {
		//base case, if the node is not a binaryTree, return 0
		//when we access the child nodes of the leaves(have no child)
		if(t==null)
		{
			return 0;
		}
		//glue case, return 1 + the nodes in the left subtree + nodes in right subtree
		else
		{
			return 1+ nodes(t.getLeft()) + nodes(t.getRight());
		}

	}

	// this method returns the height of a BinaryTree
	// (the number of edges separating a root node/tree from its most distant,
	// descendant leaf)
	public static <T> int height(BinaryTree<T> t) {
		//base case, if there is no binary tree, then return -1
		//because if there is one node, the height would be 0, so we can't return 0
		if(t==null)
		{
			return -1;
		}
		//glue case, return 1 +  the height of right subtree or left subtree whichever one is greater
		else
		{
			return 1+ Math.max(height(t.getRight()), height(t.getLeft()));
		}
	}

	// this method tests whether a tree is height balanced
	public static <T> boolean heightBalanced(BinaryTree<T> t) {
		//base case, if there no binary tree, then height is balanced
		if(t==null)
		{
			return true;
		}

		//glue code, get the high of right and left subtrees
		//if their difference is less than or equal to 1 and that nodes' left and right are height balanced then return true
		int rheight = height(t.getRight());
		int lheight = height(t.getLeft());
		if( Math.abs(rheight - lheight) <= 1 && heightBalanced(t.getLeft()) && heightBalanced(t.getRight()))
		{
			return true;
		}
		return false;

	}

	public static <T> void preorder(BinaryTree<T> t) {
		if (t != null) {
			System.out.print(t.getData() + "\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t) {
		if (t != null) {
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t) {
		if (t != null) {
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}

	// this method uses a modified BFS to print the data associated with all
	// nodes/trees in level order
	public static <T> void levelOrder(BinaryTree<T> t) {
		//the array list that keeps track of the trees that needs to be printed
		ArrayList<BinaryTree<T>> q = new ArrayList<BinaryTree<T>>();
		q.add(t);
		//While that array is not empty
		while(q.size()>0)
		{
			//print the data of the first tree node
			System.out.print(q.get(0).data + "\t");
			//if it has left node
			if(q.get(0).getLeft() != null)
			{
				//add that to q
				q.add(q.get(0).getLeft());
			}
			//if it has right node
			if(q.get(0).getRight() != null)
			{
				//add that to q
				q.add(q.get(0).getRight());
			}
			//now that we are done(printed and added its children if any) with this tree node
			//now second node will be moved to first position
			q.remove(0);
		}
	}
}
