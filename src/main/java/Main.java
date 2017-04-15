import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String inputCSV = "/home/andrew/Desktop/station-copy.csv";
        String outputCSV = "/home/andrew/Desktop/station-formatted.csv";
        try
        {
            //Build reader instance
            //Default separator is comma
            //Default quote character is double quote
            CSVReader reader = new CSVReader(new FileReader(inputCSV), ',', '"', 1);

            //Build writer instance
            //Create new csv file
            CSVWriter writer = new CSVWriter(new FileWriter(outputCSV));

            List<Station> stations = new ArrayList<Station>();

            String[] record;
            while ((record = reader.readNext()) != null)
            {
                Station station = new Station();
                station.setOrgId(record[0]);
                station.setSiteId(record[2]);
                station.setSiteDescription(record[3]);
                station.setHUC8Code(record[6]);
                station.setLatitude(Double.valueOf(record[11]));
                station.setLongitude(Double.valueOf(record[12]));
                station.setCRS(record[17]);

                // default value is 0 if column lacks elevation data
                if (record[18].equals(""))
                    station.setElevation(0.0);
                else
                    station.setElevation(Double.valueOf(record[18]));

                station.setElevationUnit("ft");
                station.setStateCode(Integer.valueOf(record[25]));
                station.setCountyCode(Integer.valueOf(record[26]));

                stations.add(station);
            }

            List<String[]> data = toStringArray(stations);
            writer.writeAll(data);

            reader.close();
            writer.close();
        }
        catch (NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static List<String[]> toStringArray(List<Station> stationList)
    {
        List<String[]> stations = new ArrayList<String[]>();
        stations.add(new String[] {"org_id", "site_id", "site_desc", "HUC8_code", "latitude",
        "longitude", "CRS", "elevation", "elev_unit", "state_code", "county_code"});

        for (Station station : stationList)
        {
            stations.add(new String[] {station.getOrgId(), station.getSiteId(), station.getSiteDescription(),
            station.getHUC8Code(), station.getLatitude().toString(), station.getLongitude().toString(),
            station.getCRS(), station.getElevation().toString(), station.getElevationUnit(),
            station.getStateCode().toString(), station.getCountyCode().toString()});
        }

        return stations;
    }
}
