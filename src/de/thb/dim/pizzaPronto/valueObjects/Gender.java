package de.thb.dim.pizzaPronto.valueObjects;

public enum Gender {
    M(1),
    F(2),
    D(3),
    U(4);

    private final int number;

    // Konstruktor ist private (wie bei Enums üblich)
    private Gender(int nr) {
        this.number = nr;
    }

    // Gibt die Nummer zurück
    public int toNumber() {
        return number;
    }

    @Override
    public String toString() {
        return switch (this) {
            case M -> "male";
            case F -> "female";
            case D -> "diverse";
            default -> "unknown";
        };
    }


}
