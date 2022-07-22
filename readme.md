


Задание базируется на new-job/IP-Addr-Counter.md at master · Ecwid/new-job

### Задание
Дан простой текстовый файл с IPv4 адресами. Одна строка – один адрес, примерно так:
145.67.23.4
8.34.5.23
89.54.3.124
89.54.3.124
3.45.71.5
...

Файл в размере не ограничен и может занимать десятки и сотни гигабайт.
Пример большого файла можно скачать по ссылке тут ​​new-job/IP-Addr-Counter.md at master · Ecwid/new-job (в самом низу).

### Необходимый функционал:
Необходимо посчитать количество уникальных адресов в этом файле, затратив как можно меньше памяти и времени.

Консольное приложение, которое на вход получает путь к файлу, а на выходе показывает количество уникальных айпишников. Ввод пути на ваше усмотрение (через аргументы командной строки или через System.in)

### Детали реализации:
В качестве языка программирования используем Java 11\14
Обязательно использование Maven

В задании должен быть рабочий метод main(), это должно быть готовое приложение, а не просто библиотека

Результат выполненной работы
Итоговый код должен быть размещен на github.com
В качестве решения должен быть создан Pull Request, который содержит ВЕСЬ (!) код.

Шаблон именования PR: {Name}_{Surname}_Task_1_Middle+
Репозиторий должен быть публичный, чтобы ментор имел к нему доступ.

Репозиторий обязательно должен содержать README.md, в котором должно быть описание решения, инструкция по запуску решения локально и его использованию, все ваши вопросы и заметки, которые должен увидеть ментор.

### На что обратить внимание при выполнении задания:
Грамотность организации кода
Использование SOLID, KISS, DRY, YAGNI принципов
Покрытие тестами