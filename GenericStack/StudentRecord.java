package CSCI2110.Lab2;

//This class represents a student record that includes first name, last name and the BannerID of the student
public class StudentRecord {

    //instance variables defining the student's fist name, last name and BannerID
    private String firstName;
    private String lastName;
    private int bannerID;

    //Constructor
    public StudentRecord(String fName, String lName, int b00)
    {
        firstName = fName;
        lastName = lName;
        bannerID = b00;
    }

    // get and set methods
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getBannerID()
    {
        return bannerID;
    }
    public void setFirstName(String  fName)
    {
        firstName = fName;
    }
    public void setLastName(String lName)
    {
        lastName = lName;
    }
    public void setBannerID(int b00)
    {
        bannerID = b00;
    }

    //toString method
    public String toString()
    {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nBannerID: " + bannerID;
    }



}
