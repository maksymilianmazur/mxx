Feature:  test zakładki Sieć
  Scenario: uzytkownik  włącza wszystkie podzakładki z zakładki Sieć
    When uzytkownik loguje sie do systemu Z4100542 oraz Jan123!#Pap
    And uzytkownik wybiera opcje menu Sieć
    And użytkownik wybiera nazwe z listy
    And użytkownik otwiera podzakładki z Sieci
    And uzytkownik zamyka przegladarke