import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    final static int numberOfEventsToPrint = 10;

    public static void main(String[] args) {
        final String filePath = "./src/main/resources/data.json";

        EventsData eventsData = new EventsData();

        try {
            Jsonb jsonb = JsonbBuilder.create();                                        // load date from file
            eventsData = jsonb.fromJson(new FileReader(filePath), EventsData.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Event> eventsList = eventsData.getEvents();

        Collections.sort(eventsList);               // sort events list by most probable results

        printTenMostProbableResults(eventsList);

    }

    static void printTenMostProbableResults(ArrayList<Event> EventsList) {
        for (int i = 0; i < numberOfEventsToPrint; i++)
            System.out.println(EventsList.get(i).toString());       // print 10 most probable results
    }
}
