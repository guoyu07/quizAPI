package com.group15.category;

public enum Colour {
    AQUA("Aqua", "#80deea"),
    BLUE("Blue", "#4fc3f7"),
    PURPLE("Purple", "#b39ddb"),
    FUCHSIA("Fuchisa", "#f06292"),
    ORANGE("Orange", "#ffb74d"),
    YELLOW("Gold", "#fff176");

    private final String name;
    private final String hexCode;

    Colour(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    public String getName() {
        return name;
    }

    public String getHexCode() {
        return hexCode;
    }
}
