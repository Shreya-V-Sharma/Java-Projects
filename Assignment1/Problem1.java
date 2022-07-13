package Assignment1; /**
 * @author Shreya Sharma
 */

import java.util.Scanner;
public class Problem1
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String bannerNum = kb.next();
        double testsAvg = (25/100.0) * readAssessmentScores(3,false,kb);
        double assignmentsAvg = (30/100.0) * readAssessmentScores(5, true, kb);
        double practicumsAvg = (35/100.0) * readAssessmentScores(4,false,kb);
        double podsAvg =  (10/ 100.0) * readAssessmentScores(1,false,kb);
        double totalMarks = testsAvg + assignmentsAvg + practicumsAvg + podsAvg;
        String letterGrade = scoreToLetterGrade(totalMarks);
        System.out.print("Student: " + bannerNum + " - " + letterGrade);
    }

    /**
     * This method reads the input from user about the marks in a specific assessment and calculates the average
     * @param numAssessment number of assessment for a specific category
     * @param dropLowest tells the method to drop the lowest mark if true, otherwise keeps all marks
     * @param input scanner object to read the input
     * @return returns the average mark for the category
     */
    public static double readAssessmentScores(int numAssessment, boolean dropLowest, Scanner input)
    {
        int[] marks = new int[numAssessment];
        int sum = 0;
        for(int i = 0; i < numAssessment; i++)
        {
            marks[i] = input.nextInt();
        }
        if(dropLowest)
        {
            int min = marks[0];
            int indexMin = 0;
            int numAssignments = numAssessment;
            for(int i = 0; i < numAssessment; i++)
            {
                if(marks[i] < min)
                {
                    min = marks[i];
                    indexMin = i;
                }
            }
            marks[indexMin] = 0;
            numAssignments--;

            for(int i = 0; i < numAssessment; i++)
            {
                sum+=marks[i];
            }
            double avg = ((double)sum)/numAssignments;
            return avg;

        }
        else
        {
            for(int i = 0; i < numAssessment; i++)
            {
                sum+=marks[i];
            }
            double avg = ((double)sum)/numAssessment;
            return avg;
        }

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
}
