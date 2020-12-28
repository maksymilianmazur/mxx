Feature:  test kalendarza opłaty mocowej zgodnie z uprawnieniami użytkownika
  Scenario: uzytkownik wykonuje zmiany w kalendarzu opłaty mocowej w przyszłości
    When uzytkownik loguje sie do systemu Z4100542 oraz Jan123!#Pap
    And uzytkownik wybiera opcje menu Użytkownicy
    And uzytkownik ustawia uprawnienia dotyczące edycji kalendarza dla uzytkownika na  Z4100542 'Edycja Ustawy Mocowej'
    And uzytkownik wybiera opcje menu Kalendarz opłaty mocowej
    And uzytkownik edytuje godziny mocowe zgodnie ze swoimi uprawnieniami
    And uzytkownik potwierdza wprowadzone zmiany
    And uzytkownik zamyka przegladarke
