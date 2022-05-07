import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        InformationSearcher searcher = new AirportInformationSearcher("flights.json", "Cargos.json");


        System.out.println(searcher.getFlightInformationById(9203,
                DateUtil.parseDate("2021-06-15T07:03:47-02:00")).toString());
        System.out.println(searcher.getFlightInformationById(4266,
                DateUtil.parseDate("2020-10-18T10:09:19-02:00")).toString());
        System.out.println(searcher.getFlightInformationById(6381,
                DateUtil.parseDate("2020-11-13T11:13:36-01:00")).toString());
        System.out.println(searcher.getFlightInformationById(7818,
                DateUtil.parseDate("2020-11-13T11:13:36-01:00")).toString());
        System.out.println(searcher.getFlightInformationById(7009,
                DateUtil.parseDate("2016-06-16T11:53:39-02:00")).toString());
                //System.out.println(searcher.getAirportInformation("LAX", date2));
    }
}
