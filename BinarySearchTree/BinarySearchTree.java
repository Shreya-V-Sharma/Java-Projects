package CSCI2110.Lab7;

/**
 * Generic Binary Search Tree Class
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>>{
    // declare required fields
	private BinaryTree<T> tree;
	private int size;

    /**
    Constructor 1
    No arg constructor
    */
    public BinarySearchTree(){
		tree = new BinaryTree<T>();
		size=0;
	}

	public BinaryTree<T> getTree(){
		return tree;
	}

	public boolean isEmpty(){
		return tree.isEmpty();
	}

	public int size(){
		return size;
	}

	public BinaryTree<T> search(T key){
		BinaryTree<T> t = tree;

        if (isEmpty()) return null;

        while (t!=null){
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
        return null;
	}

	public void insert(T item){
        //initialize new BT and sets left, right, parent and data to null
		BinaryTree<T> newNode = new BinaryTree<T>();
		newNode.setData(item);

		if (size==0){
            tree = newNode;
            size++;
            return;
        }

		BinaryTree<T> t = tree;
		boolean done = false;

        while (!done){
			int c = item.compareTo(t.getData());
			if (c==0){
				System.out.println("Duplicate key. Can't insert");
				return;
			}
            //need to go left
			else if (c<0){
                //place to insert found
				if (t.getLeft()==null){
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
                    //otherwise go left one branch
					t = t.getLeft();
			}
            //c>0; need to go right
			else{
                //place to insert found
				if (t.getRight()==null){
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}

	public BinaryTree<T> findPredecessor(BinaryTree<T> node){
		if (node==null)
            return null;

		if (node.getLeft()==null)
            return null;

		BinaryTree<T> pred = node.getLeft();

        while (pred.getRight()!=null)
			pred = pred.getRight();

        return pred;
	}

	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach){
		if (deleteNode==null)
            return;

		BinaryTree<T> parent = deleteNode.getParent();

		if (parent == null)
            return;

        if (attach == null){
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}

        if (deleteNode==parent.getRight()){
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else{
			parent.detachLeft();
			deleteNode.setParent(null);

			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}

		deleteNode.clear();
	}

	public void delete(T key){
		if (size==0){
            System.out.println("Can't delete. Empty tree");
            return;}

		BinaryTree<T> deleteNode = search(key);

        if (deleteNode==null){
            System.out.println("Key not found. Can't delete");
            return;
        }

		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null){
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null){
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
        else if (deleteNode.getRight()==null){
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}

		size--;
	}

	//This is a method to find the tree/node with the highest value in it's data, and returns that data
	//since the tree is sorted, the most right node/leaf will have the highest value
    public T findMax(){

		//the tree is empty, there is no max, so return null
		if(tree.isEmpty())
		{
			return null;
		}
		//else(tree is not empty)
		else
		{
			//strat at the root of the tree
			BinaryTree<T> t = tree;
			//while you can go right, and there is node/tree/subtree on the eight
			while(t.getRight()!=null)
			{
				//get the right subtree/tree
				t = t.getRight();
			}
			//since the loop has ended, we have reached the most right node/tree, which will have the highest data, so return that
			return t.getData();
		}

    }

	//method to find minimum value of the tree
	//done the same way as findMax() but instead of using right, we are using left, because the most left will have the lowest value
    public T findMin(){
		if(tree.isEmpty())
		{
			return null;
		}
		else
		{
			BinaryTree<T> t = tree;
			while(t.getLeft()!=null)
			{
				t = t.getLeft();
			}
			return t.getData();
		}

    }

    //Helper method to search the tree of this class
    public BinaryTree<T> recursiveSearch(T key){
        return recursiveSearch(this.getTree(),key);
    }


	//method to recursively find tree/node in tree t with a given key
    public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key) {
		//while searching if we hit null, then we didn't find the key, just return null
    	if(t==null)
		{
			System.out.println("Not found!");
			return null;
		}
		//compare the key to the key of the current tree
		int c = key.compareTo(t.getData());

		//if key is less than current tree's key then find key in left subtree
		if(c<0)
		{
			return recursiveSearch(t.getLeft(),key);
		}
		//if key is more than current tree's key then find key in right subtree
		else if(c>0)
		{
			return recursiveSearch(t.getRight(),key);
		}
		//if equal then key is found, return that tree
		else
		{
			System.out.println("Found!");
			return t;
		}
    }
}
