Feature:  test kalendarza opłaty mocowej zgodnie z uprawnieniami użytkownika
  Scenario: uzytkownik nie posiada uprawnien do edytowania, przegladanie kalendarza
    When uzytkownik loguje sie do systemu LOGIN oraz HASLO
    And uzytkownik wybiera opcje menu Użytkownicy
    And uzytkownik ustawia uprawnienia dotyczące możliwości edycji kalendarza dla uzytkownika Z4100542
    And uzytkownik wybiera opcje menu Kalendarz opłaty mocowej
    And uzytkownik odczytuje godziny mocowe
    And uzytkownik zgodnie z uprawnieniami nie posiada mozliwosci edycji
    And uzytkownik zamyka przegladarke
