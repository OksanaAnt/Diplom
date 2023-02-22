package data.events;

public enum EventTypeTextData {
    TEXTDOD ("День открытых дверей"),
    TEXTVEBINAR("Открытый вебинар");
    private String name;
    EventTypeTextData (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
