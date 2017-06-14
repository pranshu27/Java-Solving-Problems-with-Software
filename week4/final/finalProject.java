import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of finalProject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class finalProject {
    
    public void totalBirths(FileResource fr)
    {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int girlNames = 0;
        int boyNames = 0;
        int totalNames = 0;
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord c:parser)
        {
            if(c.get(1).equals("M")) 
            {
                totalBoys+=Integer.parseInt(c.get(2));
                boyNames++;
            }
            if(c.get(1).equals("F"))
            {
                totalGirls+=Integer.parseInt(c.get(2));
                girlNames++;
            }
            
            
            
            totalNames++;
            totalBirths+=Integer.parseInt(c.get(2));
        }
        System.out.println("Total Births " + totalBirths);
        System.out.println("Total Boys " + totalBoys);
        System.out.println("Total Girls " + totalGirls);
        System.out.println("Total Names " + totalNames);
        System.out.println("Total Girl Names " + girlNames);
        System.out.println("Total Boy Names " + boyNames);
        
    }
    
    public void tester()
    {
        FileResource fr = new FileResource();
        totalBirths(fr);
        
        System.out.println(getRank(2012, "Mason", "M"));
    }
    
    public int getRank(int year, String name, String gender)
    {
        int girlNames = 0;
        int boyNames = 0;
        String filename = "yob" + year + "short.csv";
        //File f = new File("C:\\Users\\Pranshu\\Documents\\java\\week4\\testing\\filename");
        
        FileResource fr = new FileResource();
        
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord c:parser)
        {
            if(c.get(1).equals("M")) 
            {
                
                boyNames++;
            }
            if(c.get(1).equals("F"))
            {
               
                girlNames++;
            }
            
            if(c.get(0).equals(name))
            {
                if(gender.equals("M"))
                {
                    return boyNames;
                }
                
                else
                {
                    return girlNames;
                }
                
            }
            
            
        }
        return -1;
    }
}
