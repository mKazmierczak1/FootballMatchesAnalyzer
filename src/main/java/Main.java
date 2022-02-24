import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    final static int numberOfEventsToPrint = 10;

    public static void main(String[] args) {
        final String filePath = "./src/main/resources/data.json";
        Scanner scanner = new Scanner(System.in);
        EventsData eventsData = new EventsData();

        try {
            Jsonb jsonb = JsonbBuilder.create();                                        // load date from file
            eventsData = jsonb.fromJson(new FileReader(filePath), EventsData.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Event> eventsList = eventsData.getEvents();

        Collections.sort(eventsList);               // sort events list by most probable results

        printMostProbableResults(eventsList);

        System.out.println("How many events do you want to print? ");
        printMostProbableResults(eventsList, scanner.nextInt());

    }

    static void printMostProbableResults(ArrayList<Event> EventsList) {
        for (int i = 0; i < numberOfEventsToPrint; i++)
            System.out.println(EventsList.get(i).toString());           // print 10 most probable results
    }

    static void printMostProbableResults(ArrayList<Event> EventsList, int NumberOfEventsToPrint) {
        if (NumberOfEventsToPrint > 0 && NumberOfEventsToPrint <= EventsList.size()) {
            for (int i = 0; i < NumberOfEventsToPrint; i++)
                System.out.println(EventsList.get(i).toString());       // print NumberOfEventsToPrint most probable results
        }
        else
            System.out.println("You typed wrong value!");
    }
}
