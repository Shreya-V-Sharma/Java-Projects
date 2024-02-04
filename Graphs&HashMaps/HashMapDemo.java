package CSCI2110.Assignment6;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the name of the file:");
        String filename = kb.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        HashMap<String,String> userPass = new HashMap<>();
        HashMap<String,String> userName = new HashMap<>();

        while(inputFile.hasNext())
        {
            String name = inputFile.next() + " " + inputFile.next();
            String username = inputFile.next();
            String password = inputFile.next();
            userPass.put(username,password);
            userName.put(username,name);
        }
        inputFile.close();

        for(int i = 2; i>=0;i--)
        {
            System.out.print("Login: ");
            String username = kb.next();
            System.out.print("Password: ");
            String password = kb.next();
            if (userPass.containsKey(username) && userPass.get(username).equals(password))
            {
                System.out.println("Login successful");
                System.out.println("Welcome " + userName.get(username));
                break;
            }
            else if(i==0)
            {
                System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                break;
            }
            else
            {
                System.out.println("Either the username or password is incorrect. You have " + i + " more attempts.");
            }
        }
    }
}
