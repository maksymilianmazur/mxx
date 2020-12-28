Feature:  test zakładki Procesor Danych
  Scenario: uzytkownik  włącza wszystkie podzakładki z zakładki Procesor danych
    When uzytkownik loguje sie do systemu Z4100542 oraz Jan123!#Pap
    And uzytkownik wybiera opcje menu Procesor danych
    And uzytkownik wybiera licznik wirtualny oraz przechodzi przez jego podzakladki
    And uzytownik wybiera walidatory oraz przechodzi przez jego podzakladki
    And uzytkownik wybiera biblioteki oraz przechodzi przez jego podzakladki
    And uzytkownik zamyka przegladarke
