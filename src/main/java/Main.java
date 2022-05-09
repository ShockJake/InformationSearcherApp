import java.util.Scanner;

public class Main {

    private static void printUsage() {
        System.out.println("Usage:\njava -cp InformationSearcher.jar Main <flightsFileName> <cargoFileName>");
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            printUsage();
            System.exit(1);
        }
        InformationSearcher searcher = new InformationSearcherApplication(args[0], args[1]);

        Scanner scanner = new Scanner(System.in);

        System.out.println("[+] Files are parsed successfully");

        System.out.println("What do you want to do:");
        System.out.println("1 - Get information about flight\n2 - Get information about Airport");
        if (scanner.nextInt() == 1) {
            System.out.println("\nPlease provide a flight number:");
            int requestFlightNumber =  scanner.nextInt();
            System.out.println("\nPlease provide a flight date in this format <YYYY-MM-ddThh:mm:sszzz>" +
                    "\t Example: 2020-10-18T10:09:19-02:00");
            String requestDate = scanner.next();
            System.out.println(searcher.getFlightInformationById(requestFlightNumber,
                    DateUtil.parseDate(requestDate)).getInformation());

        }
        else if (scanner.nextInt() == 2) {
            System.out.println("\nPlease provide a Airport IATACode:");
            String requestIATACode =  scanner.next();
            System.out.println("\nPlease provide a date in this format <YYYY-MM-ddThh:mm:sszzz>" +
                    "\t Example: 2020-10-18T10:09:19-02:00");
            String requestDate = scanner.next();
            System.out.println(searcher.getAirportInformation(requestIATACode,
                    DateUtil.parseDate(requestDate)).getInformation());

        }
    }
}
