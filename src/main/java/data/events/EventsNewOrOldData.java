package data.events;

public enum EventsNewOrOldData {
    EVENTSNEW ("near"),
    EVENTSOLD ("archive");
    private String name;
    EventsNewOrOldData (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
