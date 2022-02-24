import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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

        Collections.sort(eventsList);                    // sort events list by most probable results

        printMostProbableResults(eventsList);           // print 10 most probable results

        System.out.println("How many events do you want to print? ");
        printMostProbableResults(eventsList, scanner.nextInt());        // print NumberOfEventsToPrint most probable results

        printAllTeamsAlphabetically(eventsList);                // print all teams alphabetically
    }

    static void printMostProbableResults(ArrayList<Event> EventsList) {
        for (int i = 0; i < numberOfEventsToPrint; i++)
            System.out.println(EventsList.get(i).toString());
    }

    static void printMostProbableResults(ArrayList<Event> EventsList, int NumberOfEventsToPrint) {
        if (NumberOfEventsToPrint > 0 && NumberOfEventsToPrint <= EventsList.size()) {
            for (int i = 0; i < NumberOfEventsToPrint; i++)
                System.out.println(EventsList.get(i).toString());
        }
        else
            System.out.println("You typed wrong value!");
    }

    static void printAllTeamsAlphabetically(ArrayList<Event> EventsList) {
        ArrayList<String> teamsList = new ArrayList<String>();
        HashSet<String> set = new HashSet<>();

        for (Event e: EventsList) {
            Competitor[] c = e.getCompetitors();

            set.add(c[0].getName());
            set.add(c[1].getName());
        }

        teamsList.addAll(set);
        Collections.sort(teamsList);

        System.out.println("Teams list:");

        for (String s: teamsList)
            System.out.println(s);
    }

}
