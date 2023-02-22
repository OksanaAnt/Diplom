package data.events;

import java.util.Arrays;

public enum DateData {
    JANUARY ("января", 1),
    FEBRUARY ("февраля", 2),
    MARCH ("марта", 3),
    APRIL ("апреля", 4),
    MAY ("мая", 5),
    JUNE ("июня", 6),
    JULY ("июля", 7),
    AUGUST ("августа", 8),
    SEPTEMBER ("сентября", 9),
    OCTOBER ("октября", 10),
    NOVEMBER ("ноября", 11),
    DECEMBER ("декабря", 12);

    private String name;
    private  int number;

    DateData (String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static DateData getDateData(String name) {
        return Arrays.stream(DateData.values())
                .filter((DateData datedata) -> datedata.getName().equals(name))
                .findFirst().get();
        }
    }

