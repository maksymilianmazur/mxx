package klasyDodatkowe;

public enum MenuList {
    DEFAULT("WTF", -1),
    PPE("Punkty Poboru Energii", 0),
    PP("Punkty Pomiaru", 1),
    Siec("Sieć", 2),
    ProcDan("Procesor danych",3),
    Harmo("Harmonogramy",4),
    Uzytkownicy("Użytkownicy",20),
    KOP("Kalendarz opłaty mocowej",25),
    WielPom("Wielkości pomiarowe",5)
    ;

    private String key;
    private int value;

    MenuList(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public static MenuList find(String key) {
        for (MenuList value : MenuList.values()) {
            if (value.key.equals(key)) {
                return value;
            }
        }
        return DEFAULT;
    }

    public int getValue() {
        return value;
    }
}
