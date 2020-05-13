-- TODO 5 jeśli podczas podnoszenia kontekstu, Spring Boot
-- znajdzie plik data.sql, będzie próbował zapełnić bazę danymi z tego pliku.
-- Schemat bazy został utworzony przez hibenrate.
-- Gdybyśmy chcieli utworzyć schemat za pomocą pliku, potrzebujemy dodać
-- plik schema.sql z CREATE TABLE..., i wyłączyć tworzenie schematu przez hibenrate:
-- (plik application.properties) spring.jpa.hibernate.ddl-auto=none
INSERT INTO hobbit VALUES (1, 'Frodo', 'Baggins');
INSERT INTO hobbit VALUES (2, 'Bilbo', 'Baggins');
INSERT INTO hobbit VALUES (3, 'Belladonna (Took)', 'Baggins');
INSERT INTO hobbit VALUES (4, 'Berylla (Boffin)', 'Baggins');
INSERT INTO hobbit VALUES (5, 'Bingo', 'Baggins');
INSERT INTO hobbit VALUES (6, 'Adalgrim', 'Tuk');
INSERT INTO hobbit VALUES (7, 'Ferdibrand', 'Tuk');
INSERT INTO hobbit VALUES (8, 'Ferumbras II', 'Tuk');
INSERT INTO hobbit VALUES (9, 'Ferumbras II', 'Tuk');
INSERT INTO hobbit VALUES (10, 'Fortinbras I', 'Tuk');