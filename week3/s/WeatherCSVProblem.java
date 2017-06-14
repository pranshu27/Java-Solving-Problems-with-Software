 

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;



public class WeatherCSVProblem {

   

    public  void tester() {
        FileResource f = new FileResource();
        CSVParser parser = f.getCSVParser();
        CSVRecord r = lowestHumidityInFile(parser);
        System.out.println(r.get("Humidity"));
        
      /* CSVRecord result = null;
       DirectoryResource dr = new DirectoryResource();
       for(File f:dr.selectedFiles())
       {
           System.out.println(result.get("Humidity"));
           FileResource fr = new FileResource(f);
           CSVParser parser = fr.getCSVParser();
           CSVRecord r = lowestHumidityInFile(parser);
           if(result == null)
           {
               result = r;
            }
            else
            {
                Double a = Double.parseDouble(r.get("Humidity"));
                Double b = Double.parseDouble(result.get("Humidity"));
                if(a<b)
                {
                    result = r;
                }
                
        }
    }
        
        System.out.println(result.get("Humidity"));

*/
 }   

    public CSVRecord coldestHourInFile(CSVParser parser) {

        CSVRecord resultRecord = null;

        for (CSVRecord record : parser) {

            if (resultRecord == null) {
                resultRecord = record;
            } else {
                double temperatureF = Double.parseDouble(record.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(resultRecord.get("TemperatureF"));
                resultRecord = (temperatureF < coldestTemp) ? record : resultRecord;
            }

        }

        return resultRecord;

    }

    /**
     * should return a string that is the name of the file
     * from selected files that has the coldest temperature
     */
    public String fileWithColdestTemperature() {

        CSVRecord coldestRecord = null;
        DirectoryResource dr = new DirectoryResource();
        String filename = "";

        for (File f : dr.selectedFiles()) {

            FileResource fr = new FileResource(f);

            CSVRecord record = coldestHourInFile(fr.getCSVParser());

            double recordTemp = Double.parseDouble(record.get("TemperatureF"));

            if (recordTemp == -9999) {
                continue;
            }

            if (coldestRecord == null) {
                coldestRecord = record;
                filename = f.getAbsolutePath();
            } else {
                double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));

                if (recordTemp < coldestTemp) {
                    coldestRecord = record;
                    filename = f.getAbsolutePath();
                }
            }

        }

        return filename;
    }

    /**
     * This method returns the CSVRecord that has the lowest humidity
     *
     * @param parser
     */
    public CSVRecord lowestHumidityInFile(CSVParser parser) {

        CSVRecord resultRecord = null;

        for (CSVRecord record : parser) {

            if (record.get("Humidity").equals("N/A")) {
                continue;
            }

            if (resultRecord == null) {
                resultRecord = record;
            } else {

                double temperatureF = Double.parseDouble(record.get("Humidity"));
                double coldestTemp = Double.parseDouble(resultRecord.get("Humidity"));
                resultRecord = (temperatureF < coldestTemp) ? record : resultRecord;

            }

        }

        return resultRecord;
    }

    /**
     * @param parser
     * @return
     */
    public double averageTemperatureInFile(CSVParser parser) {

        double averageTemp = 0.0;
        double sum = 0;
        int counter = 0;
        for (CSVRecord record : parser) {


            double recordTemp = Double.parseDouble(record.get("TemperatureF"));

            if (recordTemp == -9999) {
                continue;
            } else {
                sum += Double.parseDouble(record.get("TemperatureF"));
                counter++;
            }


        }

        averageTemp = sum / counter;

        return averageTemp;
    }

    /**
     * This method returns a double that represents the average temperature of only
     * those temperatures when the humidity was greater than or equal to value
     *
     * @param parser
     * @param level
     */
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, double level) {

        double averageTemp;
        double sum = 0;
        int counter = 0;

        for (CSVRecord record : parser) {

            double humidity = Double.parseDouble(record.get("Humidity"));

            if (humidity >= level) {
                sum += Double.parseDouble(record.get("TemperatureF"));
                counter++;
            }

        }

        averageTemp = sum / counter;

        return averageTemp;

    }

}