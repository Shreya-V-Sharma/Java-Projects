package CSCI2110.Assignment6;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TopologicalSorting {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the name of the file:");
        String filename = kb.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        int n = Integer.parseInt(inputFile.next());
        int[][] adj = new int[n][n];

        while(inputFile.hasNext())
        {
            int v1 = inputFile.next().charAt(0)-65;
            int v2 = inputFile.next().charAt(0)-65;
            adj[v1][v2] = 1;
        }
        inputFile.close();

        Queue<Integer> q = new PriorityQueue<>();
        int[] pred = new int[n];
        for(int i=0; i<n; i++)
        {
            int indegree = 0;
            for(int j=0; j<n; j++ )
            {
                indegree+=adj[j][i];
            }
            pred[i] = indegree;
            if(indegree==0)
            {
                q.add(i);
            }
        }
        int topnum = 1;
        int[] sorted = new int[n];
        while(!q.isEmpty())
        {
            int w = q.poll();
            sorted[topnum-1] = w;
            topnum++;
            for(int i = 0; i<n; i++)
            {
                if(adj[w][i]==1)
                {
                    pred[i]--;
                    if(pred[i]==0)
                    {
                        q.add(i);
                    }
                }
            }
        }

        for(int i = 0; i<n; i++)
        {
            System.out.println(i+1 + " " +(char)(sorted[i]+65));
        }

    }
}
