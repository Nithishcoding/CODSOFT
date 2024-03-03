import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class wordCounter3 
{
   public static void main(String []args)
   {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the text or file path");
    String input=sc.nextLine();

    String content="";
    
    try
    {
      content=readContent(input);

    }
    catch(FileNotFoundException e)
    {
        System.out.println("FILE NOT FOUND,TRY AGAIN");
        return;
    }

    String []words=content.split("[\\s\\p{Punct}]+");

    int count=0;

    for(String word:words)
     count++;
     
     System.out.println("Total no of words is "+count);
   } 

   public static String readContent(String input) throws FileNotFoundException
   {
    File file=new File(input);

    if(file.exists())
    {
        Scanner filesScanner=new Scanner(file);
        StringBuilder contentBuilder=new StringBuilder();

        while (filesScanner.hasNextLine()) 
        {
            contentBuilder.append(filesScanner.nextLine()).append("\n");
        }

        filesScanner.close();
        return contentBuilder.toString();
        
    }
    else
      return input;
   }
}
