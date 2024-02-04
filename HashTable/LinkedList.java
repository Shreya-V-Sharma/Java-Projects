package CSCI2110.Lab8;

//Generic LinkedList class
//Builds upon the generic Node class
public class LinkedList<T>{
	//instance variables
	private Node<T> front;
	private int count;

	//constructor - creates an empty linked list
	public LinkedList(){
		front=null;
		count=0;
	}

	//getFront
	public Node<T> getFront(){return front;}

	//method1 - add an item to the front of the linked list
	public void add(T item){
		Node<T> newN = new Node<T>(item, front);
		front = newN;
		count++;
	}

	//method2 - return the size of the linked list
	public int size(){return count;}

	//method3 - check if the linked list is empty
	public boolean isEmpty(){return (count==0);}

	//method4 - scan the list and display the items
	public void enumerate(){
		Node<T> curr = front;
		while (curr!=null){
			System.out.print(curr.getData() + "-->");
			curr = curr.getNext();
		}
		System.out.println();
	}

	//method5 - get the item at a given index
	public T getAt(int index)
	{
		Node<T> curr = front;
		if (index<0 || index>=count){
			System.out.println("Index out of bounds");
			return null;
		}

		else{
			for(int i=0;i<index;i++)	
				curr=curr.getNext();
		}
		return curr.getData();
	}

	//method6 - insert an item at a given index
	public void insertAt(T item, int index){
		if (index<0||index>count){
			System.out.println("Error. Index out of bounds");
			return;
		}
		else{
			if (index==0){
				add(item);
				return;
			}
			Node<T> prev=front;
			for(int i=0; i<index-1; i++)
				prev=prev.getNext();
			Node<T> newN = new Node<T>(item, prev.getNext());
			prev.setNext(newN);
			count++;
		}
	}

	//method7 - set a node(given item and a given index)
	public void setAt(T item, int index){
		if (index<0||index>=count){
			System.out.println("Can't set. Index out of bounds");
			return;
		}
		Node<T> curr = front;
		for(int i=0;i<index;i++)
			curr = curr.getNext();
		curr.setData(item);
	}

	//method8 - SEARCH METHOD: return the index of the first occurrence of a given item
	//if item is not found, return -1
	public int indexOf(T item){
		Node<T> curr = front;
		for(int i=0; i<count; i++){
			if (item.equals(curr.getData()))
				return i; //item found; break out of the loop
			curr = curr.getNext();		
		}
		return -1;
	}

	//method9 - remove an item at a given index
	public T removeAt(int index){
		T result = null;
		if (index<0||index>=count){
			System.out.println("Can't remove. Index out of bounds");
			return null;
		}
		if (index==0) //first node has to be removed
		{
			result = front.getData();
			front = front.getNext();
		}
		else //not the first node
		{
			Node<T> prev = front;
			for (int i=0; i<index-1; i++)
				prev = prev.getNext();
			result = prev.getNext().getData();
			prev.setNext(prev.getNext().getNext());
		}
		count--;
		return result;
	}

	//method10 - remove the node of the first occurrence of a given item
	public void remove(T item){
		int i = indexOf(item);
		if (i==-1)
			System.out.println("No such item");
		else
			removeAt(i);
	}

	//method11 - remove all occurrences of a given item
	public void removeAll(T item){
		Node<T> curr = front, prev = null;
		while (curr!=null){
			if (front.getData().equals(item)){ //front node has item
				curr = curr.getNext();
				front=front.getNext();
				count--;
			}
			else if (curr==front){ //front node does not have item
						//but curr is at front
				prev=curr;
				curr=curr.getNext();
			}
			else //currr is somewhere in the middle
			{
				if (curr!=null) //make sure curr is not null
				{
					if(curr.getData().equals(item)){
						prev.setNext(curr.getNext());
						curr=prev.getNext();
						count--;
					}
					else{
						prev=curr;
						curr=curr.getNext();
					}
				}
			}
		}
	}

	//display in reverse
	public void displayReverse(Node<T> front){
		if (front==null) return;
		else{
			displayReverse(front.getNext());
			System.out.print(front.getData() + " ");
		}
	}

	//display even
	public void displayEven(Node<T> front){
	if (front==null)
		return;
	else if (front.getNext()==null){
		System.out.print(front.getData()+ " ");
	}
	else{
		System.out.print(front.getData() + " ");
		displayEven(front.getNext().getNext());
	}
	}

	//display odd
	public void displayOdd(Node<T> front){
	if (front==null)
		return;
	else if (front.getNext()==null) 
		return;
	else if (front.getNext().getNext()==null){
		System.out.print(front.getNext().getData() + " ");
	}
	else{
//		System.out.print(front.getNext().getData()+ " ");
		displayOdd(front.getNext().getNext());
		System.out.print(front.getNext().getData() + " ");
	}
	}
}

