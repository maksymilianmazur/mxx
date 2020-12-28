Feature:  test zakładki Procesor Danych
  Scenario: uzytkownik  włącza wszystkie podzakładki z zakładki Procesor danych
    When uzytkownik loguje sie do systemu LOGIN oraz HASLO
    And uzytkownik wybiera opcje menu Harmonogramy
    And uzytkownik wybiera harmonogram z listy
    And uzytkownik przechodzi przez podzakladki harmonogramow
    And uzytkownik zamyka przegladarke
