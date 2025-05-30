## 1. Перечень автоматизируемых сценариев

1.	Проверка обработки карты с истекшим сроком действия.
2.	Проверка успешной оплаты для одобренной карты.
3.	Проверка оплаты отклоненной карты.
4.	Проверка валидации пустых полей формы.
5.	Проверка обработки карты с неверным форматом (15 цифр).
6.	Проверка недопустимого месяца.
7.	Проверка неверного формата карты с датой последнего месяца.
8.	Проверка карты с истекшим сроком действия. 
9.	Проверка карты с будущим годом.
10.	Проверка не валидных данных года с одной цифрой.
11.	Проверка не валидных данных месяца с одной цифрой.
12. Проверка поля имени с кириллическими символами.
13.	Проверка поля имени с специальными символами.
14.	Проверка поля имени с числовыми символами.
15.	Проверка поля имени с большим количеством символов.
16.	Проверка номера карты, равного нулю.
17.	Проверка CVC, равного нулю.
18. Проверка CVC с одной цифрой.
19.	Проверка, что поле карты пустое после очистки.
20.	Проверка, что поле месяца пустое после очистки.
21.	Проверка, что поле года пустое после очистки.
22.	Проверка, что поле CVC пустое после очистки.


## 2. Перечень используемых инструментов с обоснованием выбора
IntelliJ IDEA — это интегрированная среда разработки (комплекс программных средств для написания, исполнения, отладки и оптимизации кода) для Java, JavaScript, Python и других языков программирования.

Gradle — это инструмент для управления проектами.

Selenide — это библиотека, которая позволяет осуществлять автоматизированное тестирование веб-приложений.

Docker — это технология, которая позволяет быстро развернуть эмулятор на Node.js, подготовить тестовую среду и обеспечить доступ к базе данных.

JUnit  — это платформа для разработки и выполнения автоматических тестов.

Allure — это инструмент для создания отчётов, обеспечивает хорошую визуализацию и возможность анализа результатов автотестирования.

## 3. Перечень и описание возможных рисков при автоматизации
Изменения в UI: Изменения в интерфейсе приложения могут привести к сбоям в тестах, так как селекторы могут перестать работать.
Зависимость от данных: Автоматизированные тесты могут зависеть от наличия определенных данных в тестовой среде. Если данные будут изменены или удалены, тесты могут не пройти.

Непредвиденные ошибки: Ошибки в коде тестов или в самом приложении могут привести к ложным срабатываниям тестов.
Необходимость в поддержке: Автоматизированные тесты требуют постоянного обслуживания, чтобы оставаться актуальными и надежными.

Ошибки в конфигурации окружения: Неправильная настройка тестового окружения может привести к ошибкам при выполнении тестов.

## 4. Интервальная оценка с учётом рисков в часах
Написание и настройка тестов - 15 часов

Настройка окружения для запуска тестов - 2 часа

Генерация отчетов и анализ результатов - 5 часов

ИТОГО: 22 часа

## 5. План сдачи работ
Настойка проекта и написание автотестов - 4 дня

Отчеты по автоматизации: 1 день
