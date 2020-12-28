Feature: sprawdzanie funkcjonalnosci logowania
  Scenario: uzytkownik ma mozliwosc zalogowania
    Then uzytkownik loguje sie do systemu Z4100542 oraz Jan123!#Pap
    And sprawdzenie poprawnosci logowania
    And uzytkownik zamyka przegladarke