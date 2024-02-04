package CSCI2110.Lab8;

//Generic Node class
public class Node<T>{
	//instance variables
	private T data;
	private Node<T> next;

	//constructor
	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
	//getters
	public T getData(){return data;}
	public Node<T> getNext(){return next;}

	//setters
	public void setData(T data){this.data = data;}
	public void setNext(Node<T> next){this.next = next;}
} 
