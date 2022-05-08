import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightInformationTest {
    private final InformationSearcher searcher = new InformationSearcherApplication("flights.json",
            "Cargos.json");

    @Test
    @DisplayName("Check empty flight information")
    void getFlightInformationByIdEmpty() {
        assertEquals(searcher.getFlightInformationById(0,
                DateUtil.parseDate("2000-11-13T11:13:36-01:00")).toString(), new FlightInformation().toString());
        assertEquals(searcher.getFlightInformationById(10,
                DateUtil.parseDate("2005-11-13T11:13:36-01:00")).toString(), new FlightInformation().toString());
        assertEquals(searcher.getFlightInformationById(20,
                DateUtil.parseDate("2010-11-13T11:13:36-01:00")).toString(), new FlightInformation().toString());
        assertEquals(searcher.getFlightInformationById(8130128,
                DateUtil.parseDate("3000-11-13T11:13:36-01:00")).toString(), new FlightInformation().toString());
    }

    @Test
    @DisplayName("Check information about all flights")
    void getFlightInformationById1() {
        assertEquals(searcher.getFlightInformationById(9203,
                        DateUtil.parseDate("2021-06-15T07:03:47-02:00")),
                new FlightInformation(9203, DateUtil.parseDate("2021-06-15T07:03:47-02:00"),
                        1361.0816326530612, 2125.2403628117913, 3486.3219954648525));
        assertEquals(searcher.getFlightInformationById(4266,
                        DateUtil.parseDate("2020-10-18T10:09:19-02:00")),
                new FlightInformation(4266, DateUtil.parseDate("2020-10-18T10:09:19-02:00"),
                        1770.0748299319728, 1728.5895691609976, 3498.6643990929706));
        assertEquals(searcher.getFlightInformationById(6381,
                        DateUtil.parseDate("2020-11-13T11:13:36-01:00")),
                new FlightInformation(6381, DateUtil.parseDate("2020-11-13T11:13:36-01:00"),
                        534.0385487528345, 2864.8321995464853, 3398.8707482993195));
        assertEquals(searcher.getFlightInformationById(7818,
                        DateUtil.parseDate("2020-11-13T11:13:36-01:00")),
                new FlightInformation(7818, DateUtil.parseDate("2020-11-13T11:13:36-01:00"),
                        1209.8503401360545, 2076.0408163265306, 3285.891156462585));
        assertEquals(searcher.getFlightInformationById(7009,
                        DateUtil.parseDate("2016-06-16T11:53:39-02:00")),
                new FlightInformation(7009, DateUtil.parseDate("2016-06-16T11:53:39-02:00"),
                        1233.920634920635, 3016.4285714285716, 4250.349206349207));

    }
}