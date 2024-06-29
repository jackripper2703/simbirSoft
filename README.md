# Тестовое задания на вакансию Разработчик в тестировании для компании SimbirSoft
#### При выполнении работы необходимо использовать следующие технологии:

1. Selenium GRID (тесты запускать через GRID обязательно)
2. Использовать паттерн проектирования автотестов Page Object
3. Реализовать формирование отчетов о пройденных тестах через Allure
#### В задании необходимо:
1. Использовать Python/Java, подключить библиотеку Selenium Webdriver;
2. С помощью Selenium открыть браузер, открыть страницу страницу
   https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login;
3. Авторизоваться пользователем «Harry Potter»;
4. Вычислить N-е число Фибоначчи, где N - это текущий день месяца + 1.
   Пример: сегодня 08.02.2023, 9-е чисто Фибоначчи равно 21;
5. Выполнить пополнение счета (Deposit) на сумму равную вычисленному в
   п.4 числу;
6. Выполнить списание со счета (Withdrawl) на сумму равную вычисленному
   в п.4 числу;
7. Выполнить проверку баланса - должен быть равен нулю;
8. Открыть страницу транзакций и проверить наличие обеих транзакций;
9. Сформировать файл формата csv, в который выгрузить данные о
   проведенных транзакциях; \
   Файл должен содержать строки следующего формата: \
   <Дата-времяТранзакции Сумма ТипТранзакции>, где \
   Формат Дата-времяТранзакции - "ДД Месяц ГГГГ ЧЧ:ММ:СС" \
   Формат Сумма - число \
   Формат ТипТранзакции - значение из списка [Credit, Debit]
10. Оформить сформированный файл как вложение к отчету allure.

## Технические требования

- Java 21
- Maven 3.6+
- Установленный Allure CLI

### Установка
Клонируйте репозиторий: 
```sh
git clone https://github.com/jackripper2703/SimbirSoft.git
```
### Запуск selenium grid
1. Из корневой папки перейдите в директорию проекта:
```sh
cd src/test/resources/selenium
```
2. Выполните команду для запуска hub:
```sh
java -jar selenium-server-4.21.0.jar hub --config hubConfig.json
```
3. Из корневой папки перейдите в директорию проекта:
```sh
cd src/test/resources/selenium
```
4. Выполните команду для запуска node:
```sh
java -jar selenium-server-4.21.0.jar node --config nodeConfig.json
```
5. Откройте браузер и перейдите по адресу http://localhost:4444/grid/console, 
чтобы убедиться, что хаб и узел правильно настроены и работают.
6. Установите зависимости и запсук тестов:
```sh
mvn clean install
```
7. После завершения тестов, отчеты Allure можно сгенерировать и открыть с помощью следующих команд:
```sh
allure serve target/allure-results
```

## Структура проекта

### Директория `core`
- `BasePage.java`: Абстрактный класс, содержащий общие методы и свойства для всех страниц.
- `BaseTest.java`: Абстрактный класс, содержащий общие настройки и методы для всех тестов.

### Директория `pages`
- `AccountPage.java`: Страница аккаунта, содержит методы для пополнения баланса, снятия средств и перехода к списку транзакций.
- `AuthPage.java`: Страница авторизации, содержит метод для входа в аккаунт конкретного пользователя.
- `MainPage.java`: Главная страница, содержит методы для выбора роли пользователя.
- `Transaction.java`: Страница транзакций, содержит методы для проверки наличия транзакций и сбора их в список.

### Директория `tests`
- `BankingProjectTest.java`: Основной тест, проверяющий функционал ведения списка транзакций.

### Директория `utils`
- `ConfigProvider.java`: Интерфейс для работы с конфигурационными файлами.
- `Fibonacci.java`: Класс для вычисления числа Фибоначчи.
- `TransactionWriter.java`: Класс для записи транзакций в CSV файл и добавления его в отчет Allure.

### Конфигурационные файлы
- `application.conf`: Конфигурационный файл с базовыми настройками проекта.
- `pom.xml`: Файл конфигурации Maven с зависимостями и плагинами для проекта.



