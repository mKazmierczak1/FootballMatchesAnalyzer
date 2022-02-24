import java.util.ArrayList;

public class EventsData {
    private ArrayList<Event> events;

    public EventsData() {
        events = new ArrayList<Event>();
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.events = Events;
    }

    @Override
    public String toString() {
        return "EventsData {" +
                "\nevents =" + events +
                '}';
    }
}
