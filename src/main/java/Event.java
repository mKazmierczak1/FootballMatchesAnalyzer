public class Event implements Comparable<Event> {

    private String sport_event_id;
    private String start_date;
    private String sport_name;
    private String competition_name;
    private String competition_id;
    private String season_name;
    private Competitor[] competitors;
    private Venue venue;
    private float probability_home_team_winner;
    private float probability_draw;
    private float probability_away_team_winner;

    public Event(String sport_event_id, String start_date, String sport_name, String competition_name, String competition_id, String season_name, Competitor[] competitors, Venue venue, float probability_home_team_winner, float probability_draw, float probability_away_team_winner) {
        this.sport_event_id = sport_event_id;
        this.start_date = start_date;
        this.sport_name = sport_name;
        this.competition_name = competition_name;
        this.competition_id = competition_id;
        this.season_name = season_name;
        this.competitors = competitors;
        this.venue = venue;
        this.probability_home_team_winner = probability_home_team_winner;
        this.probability_draw = probability_draw;
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public Event() {
        competitors = new Competitor[2];
    }

    public String getSport_event_id() {
        return sport_event_id;
    }

    public void setSport_event_id(String sport_event_id) {
        this.sport_event_id = sport_event_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Competitor[] competitors) {
        this.competitors = competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public float getProbability_home_team_winner() {
        return probability_home_team_winner;
    }

    public void setProbability_home_team_winner(float probability_home_team_winner) {
        this.probability_home_team_winner = probability_home_team_winner;
    }

    public float getProbability_draw() {
        return probability_draw;
    }

    public void setProbability_draw(float probability_draw) {
        this.probability_draw = probability_draw;
    }

    public float getProbability_away_team_winner() {
        return probability_away_team_winner;
    }

    public void setProbability_away_team_winner(float probability_away_team_winner) {
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public float getMostProbableResult() {
        if (probability_home_team_winner > probability_draw && probability_home_team_winner > probability_away_team_winner)
            return probability_home_team_winner;
        else if (probability_draw > probability_away_team_winner)
            return probability_draw;
        else
            return probability_away_team_winner;
    }

    private String highestProbableResultName(float mostProbableResult) {
        if (mostProbableResult == probability_home_team_winner)
            return "HOME_TEAM_WIN";
        else if(mostProbableResult == probability_draw)
            return "DRAW";
        else
            return "AWAY_TEAM_WIN";
    }

    private String formatStartDate() {
        String[] date = this.start_date.split("T");
        date[1] = date[1].substring(0, 8);
        return date[0] + " " + date[1];
    }

    @Override
    public String toString() {
        float mostProbableResult = this.getMostProbableResult();
        return "Start date: " + this.formatStartDate() + ",\n"
                + competitors[0].toString() + " vs. " + competitors[1].toString() + ",\n"
                + (venue != null ? venue.toString() : "No data about venue!") + ",\n"
                + "Highest probable result: " + this.highestProbableResultName(mostProbableResult) + " (" + mostProbableResult + ")\n";
    }

    /*
    Start date: 2021-08-10 17:00:00,
    Slavia Prague (Czech Republic) vs. Ferencvarosi Budapest (Hungary),
    Venue: Sinobo Stadium,
    Highest probable result : HOME_TEAM_WIN (65.9)
     */

    @Override
    public int compareTo(Event o) {
        if (this.getMostProbableResult() < o.getMostProbableResult())
            return 1;
        else if (this.getMostProbableResult() == o.getMostProbableResult())
            return 0;
        else
            return -1;
    }
}
