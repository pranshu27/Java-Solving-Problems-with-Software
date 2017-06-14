
/**
 * Write a description of pracice here.
 * 
 * @author (your name) 
 *i @versmion (a pversion number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class pracice {
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //System.out.println(countryInfo(parser, "France"));
        
        parser = fr.getCSVParser();
        
        //listExportersTwoProducts(parser, "flowers", "cotton");
        
        parser = fr.getCSVParser();
        
        System.out.println(numberOfExporters(parser, "cocoa"));
        
        parser = fr.getCSVParser();
        
        //bigExporters(parser, "$999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country)
    {
        String s1 = "";
        for(CSVRecord r:parser)
        {
            String country1 = r.get("Country");
            String exports  =r.get("Exports");
            String value = r.get("Value (dollars)");
            if(country1.equals(country))
            {
                s1 = country1 + ":" + exports + ":" + value;
            }
           
        }
        if(s1!=null)
        {
            return s1;
        }
        else
        {
            return "NOT FOUND";
        }
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        for(CSVRecord r:parser)
        {
            if(r.get("Exports").contains(exportItem1) == true && r.get("Exports").contains(exportItem2) == true)
            {
                System.out.println(r.get("Country"));
            }
            
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem)
    {
        int count = 0;
        for(CSVRecord r:parser)
        {
            if(r.get("Exports").contains(exportItem)==true) count++;
        }
        return count;
    }
    
    public void  bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord r:parser)
        {
            if(r.get("Value (dollars)").length()> amount.length())
            {
                System.out.println(r.get("Country") + " " + r.get("Value (dollars)"));
                
            }
        }
    }
}

