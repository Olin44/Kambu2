# Welcome to Kambu_Project!

Aplikacja służąca do przeliczania kursów walut z użyciem API NBP.


# Użyte technologie

-  Java SE Development Kit 11
- Spring Framework
- Spring Boot
- Baza danych Mongo DB

# Konfiguracja
Baza danych MongoDB wystawiona na domyślnym porcie. 

# Opis endpointów:
**Endpoint 1:**
Działa pod adresem http://localhost:8080/currencies/ wypisuje listę walut, na których mogą zostać dokonane przeliczenia. Korzysta z http://api.nbp.pl/api/exchangerates/tables/a/.

**Endpoint 2:**
Przykładowe zapytanie:
http://localhost:8080/currencies/convert?from=HUF&to=HKD&value=100
parametry:
from -> skrót nazwy waluty, który posiadamy
to -> waluta, którą chcemy otrzymać
value -> ilość waluty, którą posiadamy(można podawać wartości w "groszach" po kropce)

**Endpoint 3:**
Przykładowe zapytanie:
http://localhost:8080/currencies/list?currencies=INR&currencies=EUR&currencies=MXN
parametry currencies będące skrótami nazw walut, metoda przyjmuje dowolną liczbę parametrów i wyświetla listę walut(skrót, i średnia cena)


# Przykładowe zapytania CURL

**Polecenie 1:**
curl -X GET "http://localhost:8080/currencies/"

**Polecenie 2:**
- curl -X GET "http://localhost:8080/currencies/convert?- from=HUF&to=HKD&value=100"
- curl -X GET "http://localhost:8080/currencies/convert?from=HUF&to=THB&value=600"
- curl -X GET "http://localhost:8080/currencies/convert?from=CNY&to=HKD&value=100"
- curl -X GET "http://localhost:8080/currencies/convert?from=INR&to=EUR&value=800"

**Polecenie 3:**
- curl -X GET "http://localhost:8080/currencies/list?currencies=EUR"
- curl -X GET "http://localhost:8080/currencies/list?- --currencies=INR&currencies=EUR"
- curl -X GET "http://localhost:8080/currencies/list?currencies=INR&currencies=EUR&currencies=MXN"


