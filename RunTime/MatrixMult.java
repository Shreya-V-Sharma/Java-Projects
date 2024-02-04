package CSCI2110.Lab3;
import java.util.Scanner;


public class MatrixMult {
    public static void main(String[] args)
    {
        //take user input for the size of the matrix and make 2 square matrix of that size using int 2D arrays
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();
        int fill = kb.nextInt();
        int[][] one = new int[size][size];
        int[][] two = new int[size][size];

        //fill the 2D arrays using the number provided by the user
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                one[i][j] = fill;
                two[i][j] = fill;
            }
        }
        //code to find execution time
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        //calling matrix multiplication method, passing in the 2 matrix created above and saving result in 2D int array
        int[][] output= matrixMult(one,two);

        //code to find execution time
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        //outputing the size of matrix and execution time
        System.out.println("Size: " + size + " Time: " + executionTime + " ms");
        
    }

    //method to perform matrix multiplication
    public static int[][] matrixMult(int[][] a, int[][] b)
    {
        //if matrix can be multiplied ( numbers of rows in first matrix is equal to the number of columns in the second matrix)
        if(a.length == b[0].length)
        {
            //make output array of size number of roes of a and number of columns of B
            int[][] c = new int[a.length][b[0].length];

            //for each of the rows of c
            for (int i = 0; i < c.length; i++) {
                //for each of the columns of c
                for (int j = 0; j < c[0].length; j++) {
                    int sum = 0;
                    //iterating in one row of a and one column of b
                    for (int k = 0; k < a.length; k++)
                    {
                        //summing multiplication of the elements of a and b
                        sum += a[i][k]*b[k][j];
                    }
                    //initializing elements of output 2D array c
                    c[i][j] = sum;
                }
            }
            return c;
        }
        //else return null
        return null;
    }

}
