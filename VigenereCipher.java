package myPackage;

import java.util.Scanner;

public class VigenereCipher
{
    //Alex Spencer and Ryan Revels-Scholte and Shreya Sharma(Comments in Alex's code)
    //the run method
    public static void main (String[] args)
    {

        //Ryan Revels-Scholte
        //Was the askprint method and now in the run method because of variable
        //scope issues
        /**the code that prints out the question that ask user to input plain
         *(decrypted) or encrypted text.
         */
        Scanner kb = new Scanner(System.in);
        //This asks the user to input their text, it also asks the user to use onlt letters.
        System.out.println("Please input your text and make sure it consists of only letters.");
        String text = kb.nextLine();
        //This string asks the user to input theur key again only permitting aplhabet letter while excluding spaces.
        System.out.println("Please input your key, only letters will be permitted with no spaces.");
        String key = kb.next();
        //Asks the user if they want to encrypt or decrypt their text.
        System.out.println("Would you like to encrypt or decrypt your text?");
        String encOrDec = kb.next();

        //Alex Spencer
        //make the key same legth as the text using the repeatKey method
        key = repeatKey(key,text);
        //convert key to all caps using the converToCaps method
        key = convertToCaps(key);
        //covert key to all caps and store it in a different variable so the origianl
        //remains unchanged
        String text1 = convertToCaps(text);
        //if the choice entered by the user equals "encrypt" then encrypt the text
        if(encOrDec.equalsIgnoreCase("encrypt"))
        {
            //encrypt the text using encrypt method
            String encrypted = encrypt(key,text1);
            //convert the encrypted text back to original case
            encrypted = convertBack(encrypted, text);
            //print out the encrypted text
            System.out.println("Encrypted text: "+ encrypted);
        }
        //if the choice entered by the user equals "decrypt" then decrypt the text
        if(encOrDec.equalsIgnoreCase("decrypt"))
        {
            //decrypt the text using decrypt method
            String decrypted = decrypt(text1,key);
            //convert the decrypted text back to original case
            decrypted = convertBack(decrypted, text);
            //print out the decrypted text
            System.out.println("Decrypted text: " + decrypted);
        }
    }


    //Simei Xing and Shreya Sharma(the code for space in the text)
    //Method that repeats key to make it the same length as the text
    public static String repeatKey(String key, String text)
    {

        //If the key length is shorter than the text length then repeat
        if(key.length() < text. length())
        {
            // Length different between text and the key
            int diff = text.length() - key.length();
            //The length is between 0 and the different
            for(int i = 0; i < diff; i++)
            {
                //Find the remainder
                key += key.charAt(i % key.length());
            }
        }

        //If the key length is longer than the text length
        if (key.length() > text. length())
        {
            //Intercept key from 0 to text-1 to be the length
            key = key.substring(0, text.length()-1);
        }

        //Shreya Sharma
        //code to consider the spaces in the text and add spaces in the key and
        //shift the other chracters

        //define a new variable
        String repKey = "";
        //count for text indeces
        int i = 0;
        //count for key indeces
        int j = 0;
        //while loop until the length of the repeated key is same as
        //the text length
        while(repKey.length() < text.length())
        {
            //the character of text at index i
            char t= text.charAt(i);
            //if there is a space in the text
            if(Character.isWhitespace(t))
            {
                //add a space
                repKey += " ";
            }
            //else
            else
            {
                //add the characters of the key at j
                repKey += key.charAt(j);
                //increment the index of the key
                j++;
            }
            //increment the index of the text
            i++;
        }
        //return repeated key with spaces
        return repKey;
    }

    //Duy Nhan (Daniel) Vo
    /**Method that converts the text and/or key to all caps
     * @param lowercase the key and the text in lowercase
     * @return the text and the key in uppercase
     */
    public static String convertToCaps(String lowercase)
    {
        //Return string coverted to upper case
        return lowercase.toUpperCase();
    }

    //Shreya Sharma
    /**Method that encrypts the text using Ei = (Pi + Ki) mod 26
     * @param key the key in upper case
     * @param text the text in upper case
     * @return encrypted text
     */
    public  static String encrypt(String key, String text)
    {

        //define the variable encrypted and set it equal to empty string
        String encrypted = "";

        //a for loop to repeat the code for the whole length of the text
        for(int i = 0; i < text.length(); i++)
        {
            //get the character of the text and the key at the same interval
            char k = key.charAt(i);
            char t = text.charAt(i);

            //if the character of the text is a letter
            if(Character.isLetter(t) && Character.isLetter(k))
            {
                //perform the encryption equation Ei = (Pi + Ki) % 26, get an int
                int enc = (t + k) % 26;
                // get value of char in ASCII by adding 65 or 'A' to int
                enc += 'A';
                //convert to char using casting
                enc = (char)enc;
                //add the character to variable encrypted
                encrypted += (char)enc;
            }

            //else
            else
            {
                //add a space to the encrypted
                encrypted += " ";

            }
        }
        //return the variable encrypted
        return encrypted;
    }

    //Braeden Lightfoot and Shreya Sharma(if, else statement and adding space code)
    //method to decrypt the text using Di = (Ei - Ki + 26) mod 26
    public static String decrypt(String key, String text )
    {
        String decrypted = "" ;

        for (int i = 0 ; i < text.length(); i++)
        {
            //if the character of the text and key are a letter
            if(Character.isLetter(text.charAt(i)) && Character.isLetter(key.charAt(i)))
            {
                // converting in range 0-25
                int dec = (text.charAt(i) - key.charAt(i) + 26) %26;
                // convert into alphabets(ASCII)
                dec += 'A';
                decrypted+=(char)(dec);
            }

            //else
            else
            {
                //add a space to the decrypted
                decrypted += " ";
            }
        }
        //return decrypted text
        return decrypted;
    }

    //Shreya Sharma
    /**method to convert the all caps result to normal caps or the same caps as
     * the user entered it
     * @param encrypted the encrypted text
     * @param text the original text
     * @return normalCase the encrypted text in original case(case of the original text)
     */
    public static String convertBack(String encrypted, String text)
    {
        // define the variable and set it equal to empty string
        String normalCase = "";
        // for the length of the text
        for(int i = 0; i < encrypted.length(); i++)
        {
            //if the character at i of the original text is lower case
            if (Character.isLowerCase(text.charAt(i)))
            {
                //convert the encrypted text at i to lower case
                char lowerCase = Character.toLowerCase(encrypted.charAt(i));
                //add this character to the variable
                normalCase += lowerCase;
            }
            //if the character of the original is not lowercase
            else
            {
                //add the character of the encrypted(uppercase) to the variable
                normalCase += encrypted.charAt(i);
            }
        }
        //retun the variable containing the encrypted text in original case
        return normalCase;
    }

    //Work cited
//https://www.geeksforgeeks.org/vigenere-cipher/ - to aid in writing the code
//https://cryptii.com/pipes/vigenere-cipher - to check if the output is correct
}
