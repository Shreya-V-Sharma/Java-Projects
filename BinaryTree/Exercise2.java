package CSCI2110.Lab6;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //taking in user input until they type done, make trees with every input and add them to the array list of binary tree named names
        Scanner kb = new Scanner(System.in);
        ArrayList<BinaryTree> names = new ArrayList<BinaryTree>();
        System.out.print("Enter name or done:");
        String name = kb.next();
        while(!name.equals("done"))
        {
            BinaryTree<String> nameTree = new BinaryTree<String>();
            nameTree.makeRoot(name);
            names.add(nameTree);
            System.out.print("Enter name or done:");
            name = kb.next();
        }

        //another list to keep track of binary trees whose children need to be added
        ArrayList<BinaryTree> names2 = new ArrayList<BinaryTree>();

        //the root of the binary tree we are making, the first thing entered by user
        BinaryTree<String> root =names.remove(0);

        //Add root to names, because we need to start adding children from root
        names2.add(root);

        //while the names list have trees
        while(names.size()>0)
        {
            //get(by removing) the first tree from names2, the tree we need to add children to
            BinaryTree node = names2.remove(0);

            //get first from names and attach to left
            node.attachLeft(names.get(0));

            //if there are 2 or more elements left
            if(names.size()>1)
            {
                //get the second element from names and attach to right
                node.attachRight(names.get(1));
                //remove from names, the first one, and add it to names 2, we need to add children to that tree
                names2.add(names.remove(0));
            }

            //remove from names, the first one, and add it to names 2, we need to add children to that tree
            //if the above if statement is true, then total two things would be removed from names, otherwise, one thing would be removed
            names2.add(names.remove(0));

        }

        //calling methods from binaryTree to test the tree above
        System.out.println();

        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(root));

        System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(root));

        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(root);
        System.out.println();

        System.out.print("Preorder:\t");
        BinaryTree.preorder(root);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(root);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(root);

    }
}
