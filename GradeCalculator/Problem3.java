package Assignment1; /**
 * @author Shreya Sharma
 */

import java.util.Scanner;
import java.util.Arrays;
public class Problem3 {
    public static void main(String[] args)
    {

        Scanner kb = new Scanner(System.in);
        int numStudents = kb.nextInt();

        //array for banner numbers
        String[] bannerNum = new String[numStudents];

        //2D arrays for marks of each student on tests, assignments, practicums, and pods
        int[][] testMarks = new int[numStudents][3];
        int[][] assignmentMarks = new int[numStudents][5];
        int[][] practicumMarks = new int[numStudents][4];
        int[][] podMarks = new int[numStudents][1];

        //for loop to read the input
        for(int i = 0; i < numStudents; i++) {
            bannerNum[i] = kb.next();
            readAssessmentScores(3, false, kb, i, testMarks);
            readAssessmentScores(5, true, kb, i, assignmentMarks);
            readAssessmentScores(4, false, kb, i, practicumMarks);
            readAssessmentScores(1, false, kb, i, podMarks);
        }

        //find avg by dividing by num assignments
        double[] testAvg = findAvg(testMarks,3);
        double[] assignmentAvg = findAvg(assignmentMarks,4);
        double[] practicumAvg = findAvg(practicumMarks,4);
        double[] podAvg = findAvg(podMarks,1);

        //find class average
        double classTest = findClassAvg(testAvg, numStudents);
        double classAssignment = findClassAvg(assignmentAvg, numStudents);
        double classPracticum = findClassAvg(practicumAvg, numStudents);
        double classPod = findClassAvg(podAvg, numStudents);

        //find median
        double testMedian = getMedian(testAvg);
        double assignmentMedian = getMedian(assignmentAvg);
        double practicumMedian = getMedian(practicumAvg);
        double podMedian = getMedian(podAvg);


        //find weighted average
        findWeightedAvg(testAvg,(25/100.0));
        findWeightedAvg(assignmentAvg,(30/100.0));
        findWeightedAvg(practicumAvg,(35/100.0));
        findWeightedAvg(podAvg,(10/100.0));

        //find total and find letter grade
        double[] total = findTotal(numStudents,testAvg,assignmentAvg, practicumAvg, podAvg);
        String[] letter = new String[numStudents];
        for(int i = 0; i< numStudents; i++)
        {
            letter[i] = scoreToLetterGrade(total[i]);
        }

        //print grades of students
        for (int i = 0; i< numStudents; i++)
        {
            System.out.println(bannerNum[i] + " " + letter[i]);
        }
        //print class averages
        System.out.println("Class Averages: ");
        System.out.printf("Tests: %.2f - Assignments: %.2f - Practicums: %.2f - PoDs: %.2f", classTest,classAssignment , classPracticum, classPod);
        System.out.println();
        System.out.println("Class Medians: ");
        System.out.printf("Tests: %.2f - Assignments: %.2f - Practicums: %.2f - PoDs: %.2f", testMedian,assignmentMedian , practicumMedian, podMedian);

    }

    /**
     * This method reads the input from user about the marks in a specific assessment
     * @param numAssessment number of assessment for a specific category
     * @param dropLowest tells the method to drop the lowest mark if true, otherwise keeps all marks
     * @param input scanner object to read the input
     * @param rowIndex the index of row that represents which student we are putting mark into the 2D array
     * @param assessment the 2D array we are using to put mark into
     */
    public static void readAssessmentScores(int numAssessment, boolean dropLowest, Scanner input, int rowIndex, int[][] assessment)
    {
        for(int i = 0; i < numAssessment; i++)
        {
            assessment[rowIndex][i] = input.nextInt();
        }
        if(dropLowest)
        {
            for(int i = 0; i<assessment.length; i++)
            {
                int min = assessment[i][0];
                int indexMin = 0;
                for(int j = 0; j<numAssessment; j++)
                {
                    if(assessment[i][j]< min)
                    {
                        min = assessment[i][j];
                        indexMin = j;
                    }
                }
                assessment[i][indexMin] = 0;
            }
        }
    }

    /**
     * This method finds the sum of the different marks of each student
     * @param marks the 2D array of marks
     * @param numAssignment the number of assignment
     * @return average of the marks in the same row
     */
    public static double[] findAvg(int[][] marks, int numAssignment)
    {
        for(int i = 0; i <marks.length; i++)
        {
            int sum = 0;
            for(int j = 0; j < marks[0].length; j++)
            {
                sum += marks[i][j];
            }
            marks[i][0] = sum;
        }
        double[] avg = new double[marks.length];
        for(int i = 0; i < marks.length; i++)
        {
            avg[i] = (double)(marks[i][0])/numAssignment;
        }
        return avg;
    }

    /**
     * This method finds the class average by adding all the average marks and diving by number of students
     * @param avgMarks array of averages of marks
     * @param numStudents number of students
     * @return average of the marks
     */
    public static double findClassAvg(double[] avgMarks, int numStudents)
    {
        double classAvg = 0;
        for(int i = 0; i < numStudents;i++ )
        {
            classAvg += avgMarks[i];
        }
        return classAvg/numStudents;
    }

    /**
     * this method multiply average mark by its weight
     * @param avgMarks the array with average of the marks
     * @param weight the weight of the assessment
     */
    public static void findWeightedAvg(double[] avgMarks, double weight)
    {
        for(int i = 0; i < avgMarks.length; i++)
        {
            avgMarks[i] = weight *((avgMarks[i]));
        }
    }

    public static double[] findTotal(int numStudents, double[] test, double[] assignment, double[] practicum, double[] pod)
    {
        double[] weightedAvg = new double[numStudents];
        for(int i = 0; i < numStudents; i++)
        {
            weightedAvg[i] = test[i] + assignment[i] + practicum[i] + pod[i];
        }
        return weightedAvg;
    }

    /**
     * This method calculates the letter grade based on the final average(uses the dal grade conversion)
     * @param finalAverage the final or total average of student in numbers
     * @return letter grade based on final average
     */
    public static String scoreToLetterGrade(double finalAverage)
    {
        if(finalAverage >= 90 && finalAverage <= 100)
        {
            return "A+";
        }
        if(finalAverage >= 85 && finalAverage < 90)
        {
            return "A";
        }
        if(finalAverage >= 80 && finalAverage < 85)
        {
            return "A-";
        }
        if(finalAverage >= 77 && finalAverage < 80)
        {
            return "B+";
        }
        if(finalAverage >= 73 && finalAverage < 77)
        {
            return "B";
        }
        if(finalAverage >= 70 && finalAverage < 73)
        {
            return "B-";
        }
        if(finalAverage >= 65 && finalAverage < 70)
        {
            return "C+";
        }
        if(finalAverage >= 60 && finalAverage <65)
        {
            return "C";
        }
        if(finalAverage >= 55 && finalAverage <60)
        {
            return "C-";
        }
        if(finalAverage >= 50 && finalAverage <55)
        {
            return "D";
        }
        if(finalAverage >= 0 && finalAverage <50)
        {
            return "F";
        }
        else
        {
            return null;
        }
    }

    /**
     * This method finds the mean of average marks
     * @param averageMarks the array with average marks of a specific category
     * @return the median of the array of average marks
     */
    public static double getMedian(double[] averageMarks)
    {
        double[] avgMarks = new double[averageMarks.length];
        for(int i=0;i<averageMarks.length;i++ )
        {
            avgMarks[i] = averageMarks[i];
        }
        Arrays.sort(avgMarks);
        double median = 0;
        int arrLength = avgMarks.length;
        if((arrLength)%2 == 0)
        {
            median = (avgMarks[(arrLength)/2] + avgMarks[((arrLength)/2) - 1])/2;
        }
        else
        {
            int middleIndex = arrLength/2;
            median = avgMarks[middleIndex];
        }
        return median;
    }
}
