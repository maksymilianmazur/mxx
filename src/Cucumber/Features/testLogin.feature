Feature: sprawdzanie funkcjonalnosci logowania
  Scenario: uzytkownik ma mozliwosc zalogowania
    Then uzytkownik loguje sie do systemu LOGIN oraz HASLO
    And sprawdzenie poprawnosci logowania
    And uzytkownik zamyka przegladarke
