package CSCI2110.Lab4;
/**
This class  describes a simple Node class. It was provided by Srini (Dr. 
Srini Sampalli).
*/

public class Node<T>{
	private T data;
	private Node<T> next;
    
	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
    
	public T getData(){
		return data;
	}
    
	public Node<T> getNext(){
		return this.next;
	}
    
	public void setData(T data){
		this.data = data;
	}
    
	public void setNext(Node<T> next){
		this.next = next;
	}
}
