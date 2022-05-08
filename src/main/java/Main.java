public class Main {

    public static void main(String[] args) {
        InformationSearcher searcher = new InformationSearcherApplication("flights.json", "Cargos.json");

        System.out.println(searcher.getFlightInformationById(9203,
                DateUtil.parseDate("2021-06-15T07:03:47-02:00")).toString());
        System.out.println(searcher.getAirportInformation("SEA",
                DateUtil.parseDate("2021-06-15T07:03:47-02:00")));
    }
}
