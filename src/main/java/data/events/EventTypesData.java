package data.events;

public enum EventTypesData {
    DOD ("ДОД");
    private String name;
    EventTypesData (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
