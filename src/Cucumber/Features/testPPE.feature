Feature:  test zakładki PPE
  Scenario: uzytkownik  włącza wszystkie podzakładki z zakładki PunktPoboruEnergii
    When uzytkownik loguje sie do systemu 01Z00354 oraz energa3!
    And uzytkownik wybiera opcje menu Punkty Poboru Energii
    And użytkownik wybiera PPE z listy
    And użytkownik otwiera podzakładki z PPE
    And uzytkownik zamyka przegladarke

