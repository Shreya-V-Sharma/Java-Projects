package CSCI2110.Lab2;
import java.util.ArrayList;

//this class implements stack data structure by using arraylist
public class GenericStack<T> {

    //instance variable
    private ArrayList<T> stack;
    private int size;

    //constructor
    public GenericStack()
    {
        stack = new ArrayList<T>();
        int size = 0;
    }

    // get method for size
    public int size()
    {
        return size;
    }

    //peek method to return the last element added in "stack"
    public T peek()
    {
        return stack.get(size-1);
    }

    //pop method to remove and return the last element added in "stack"
    public T pop()
    {
        T pop = stack.get(size-1);
        stack.remove(size-1);
        size--;
        return pop;
    }

    //push method to add elements to the stack
    public void push(T element)
    {
        stack.add(element);
        size++;
    }

    //isEmpty method that returns true if the stack is empty and false otherwise
    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }

}
