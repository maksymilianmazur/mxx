Feature:  test zakładki PP
  Scenario: uzytkownik  włącza wszystkie podzakładki z zakładki PunktuPomiaru
    When uzytkownik loguje sie do systemu LOGIN oraz HASLO
    And uzytkownik wybiera opcje menu Punkty Pomiaru
    And użytkownik wybiera PP z listy
    And użytkownik otwiera podzakładki z PP
    And uzytkownik zamyka przegladarke
