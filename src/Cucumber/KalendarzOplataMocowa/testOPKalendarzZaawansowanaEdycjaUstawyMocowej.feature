Feature:  test kalendarza opłaty mocowej zgodnie z uprawnieniami użytkownika
  Scenario: uzytkownik wykonuje zmiany w kalendarzu opłaty mocowej w przeszłości oraz przyszłości
    When uzytkownik loguje sie do systemu LOGIN oraz HASLO
    And uzytkownik wybiera opcje menu Użytkownicy
    And uzytkownik ustawia uprawnienia edycji kalendarza dla uzytkownika Z4100542 na 'Zaawansowana Edycja Ustawy Mocowej'
    And uzytkownik wybiera opcje menu Kalendarz opłaty mocowej
    And uzytkownik edytuje godziny mocowe w przyszłości zgodnie ze swoimi uprawnieniami
    And uzytkownik potwierdza wprowadzone zmiany w kalendarzu
    And uzytkownik zamyka przegladarke
