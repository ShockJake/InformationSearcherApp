import information.AirportInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.DateUtil;

import static org.junit.jupiter.api.Assertions.*;

public class AirportInformationTest {
    private final InformationSearcher searcher = new InformationSearcherApplication("flights.json",
            "Cargos.json");

    @Test
    @DisplayName("Check information about airports")
    void getFlightInformationById1() {
        assertEquals(searcher.getAirportInformation("SEA",
                        DateUtil.parseDate("2021-06-15T07:03:47-02:00")).toString(),
                new AirportInformation("SEA", DateUtil.parseDate("2021-06-15T07:03:47-02:00"),
                        1, 0, 0, 1279).toString());

        assertEquals(searcher.getAirportInformation("GDN",
                        DateUtil.parseDate("2021-06-15T07:03:47-02:00")).toString(),
                new AirportInformation("GDN", DateUtil.parseDate("2021-06-15T07:03:47-02:00"),
                        0, 2, 6375, 0).toString());

        assertEquals(searcher.getAirportInformation("ANC",
                        DateUtil.parseDate("2020-10-18T10:09:19-02:00")).toString(),
                new AirportInformation("ANC", DateUtil.parseDate("2020-10-18T10:09:19-02:00"),
                        1, 0, 0, 2263).toString());

        assertEquals(searcher.getAirportInformation("MIT",
                        DateUtil.parseDate("2020-10-18T10:09:19-02:00")).toString(),
                new AirportInformation("MIT", DateUtil.parseDate("2020-10-18T10:09:19-02:00"),
                        0, 2, 4496, 0).toString());

        assertEquals(searcher.getAirportInformation("LAX",
                        DateUtil.parseDate("2020-11-13T11:13:36-01:00")).toString(),
                new AirportInformation("LAX", DateUtil.parseDate("2020-11-13T11:13:36-01:00"),
                        2, 0, 0, 7329).toString());

        assertEquals(searcher.getAirportInformation("YYT",
                        DateUtil.parseDate("2016-06-16T11:53:39-02:00")).toString(),
                new AirportInformation("YYT", DateUtil.parseDate("2016-06-16T11:53:39-02:00"),
                        1, 0, 0, 5123).toString());
    }
}
