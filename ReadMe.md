### 1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их.Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

![Alt text](images/image0.png)
![Alt text](images/image-01.png)
***
### 2. Создать директорию, переместить файл туда.

![Alt text](images/image.png)
***

## 3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
![Alt text](images/image-1.png)
![Alt text](images/image-2.png)

***

### 4. Установить и удалить deb-пакет с помощью dpkg.

#### 4.1 Вначале установим пакет .dep
![Alt text](images/image-5.png)
#### 4.2 Произошла ошибка зависимостей необходимо установить зависимости : mc-data
![Alt text](images/image-6.png)
#### 4.3 Готовывй результат 
![Alt text](images/image-7.png)
#### 4.4 Удалим пакет с помощью dpkg
![Alt text](images/image-8.png)
***
### 5. Выложить историю команд в терминале ubuntu
Приложено выше скринами
***

### 6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
![Alt text](images/DiagramClass.png)

### 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
![Alt text](images/image-3.png)
![Alt text](images/image-4.png)
***
### 8-9. Создать таблицы с иерархией из диаграммы в БД.Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения.
[SQL файл](SQL/sqlAnimals.sql)

```
USE humanfriends;

CREATE TABLE IF NOT EXISTS Cats(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Type VARCHAR(255) NOT NULL,
    BirthDay DATE NOT NULL,
    Commands VARCHAR(255) NOT NULL
);

INSERT Cats(Name, Type, BirthDay, Commands)
VALUES
('Tobik', 'Cat', '2008-10-23', 'Sit, Stay'),
('Barsik', 'Cat', '2020-08-23', 'Sit, Pounce'),
('Gavr', 'Cat', '2008-10-23', 'Sit, Scratch');

CREATE TABLE IF NOT EXISTS Dogs(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Type VARCHAR(255) NOT NULL,
    BirthDay DATE NOT NULL,
    Commands VARCHAR(255) NOT NULL
);

INSERT Dogs(Name, Type, BirthDay, Commands)
VALUES
('Tor', 'Dog', '2019-11-09', 'Sit, Stay, Fetch'),
('Luna', 'Dog', '2020-08-23', 'Sit, Pounce'),
('Sharik', 'Dog', '2008-10-23', 'Sit, Scratch');

CREATE TABLE IF NOT EXISTS Hamsters(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Type VARCHAR(255) NOT NULL,
    BirthDay DATE NOT NULL,
    Commands VARCHAR(255) NOT NULL
);

INSERT Hamsters(Name, Type, BirthDay, Commands)
VALUES
('Hammy', 'Hamster', '2020-01-02', 'Roll, Hide'),
('Ganny', 'Hamster', '2021-01-02', 'Roll, Hide'),
('Tonny', 'Hamster', '2022-01-02', 'Roll, Hide');

CREATE TABLE IF NOT EXISTS Horses(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Type VARCHAR(255) NOT NULL,
    BirthDay DATE NOT NULL,
    Commands VARCHAR(255) NOT NULL
);
INSERT Horses(Name, Type, BirthDay, Commands)
VALUES
('Thunder', 'Horse', '2015-12-09', 'Trot, Canter'),
('Jonny', 'Horse', '2020-12-09', 'Trot, Canter'),
('Pon', 'Horse', '2022-12-09', 'Trot, Canter');

CREATE TABLE IF NOT EXISTS Camels(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Type VARCHAR(255) NOT NULL,
    BirthDay DATE NOT NULL,
    Commands VARCHAR(255) NOT NULL
);
INSERT Camels(Name, Type, BirthDay, Commands)
VALUES
('Sandy', 'Camel', '2016-01-02', 'Walk, Carry'),
('Bandy', 'Camel', '2020-01-02', 'Walk, Carry'),
('Goody', 'Camel', '2022-01-02', 'Walk, Carry');

CREATE TABLE IF NOT EXISTS Donkeys(
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Type VARCHAR(255) NOT NULL,
    BirthDay DATE NOT NULL,
    Commands VARCHAR(255) NOT NULL
);

INSERT Donkeys(Name, Type, BirthDay, Commands)
VALUES
('Burro', 'Donkey', '2019-01-23', 'Walk, Kick'),
('Durro', 'Donkey', '2020-01-23', 'Walk, Kick'),
('Gurro', 'Donkey', '2021-01-23', 'Walk, Kick');

CREATE TABLE IF NOT EXISTS Pets AS (
SELECT Name, Type, BirthDay, Commands FROM Cats
UNION  
SELECT Name, Type, BirthDay, Commands FROM Dogs
UNION  
SELECT Name, Type, BirthDay, Commands FROM Hamsters
);

DELETE FROM Camels;

CREATE TABLE IF NOT EXISTS Pack_animals AS (
SELECT Name, Type, BirthDay, Commands FROM Horses
UNION  
SELECT Name, Type, BirthDay, Commands FROM Donkeys
UNION  
SELECT Name, Type, BirthDay, Commands FROM Camels
);

```
***
### 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

```
DELETE FROM Camels;

CREATE TABLE IF NOT EXISTS Pack_animals AS (
SELECT Name, Type, BirthDay, Commands FROM Horses
UNION  
SELECT Name, Type, BirthDay, Commands FROM Donkeys
UNION  
SELECT Name, Type, BirthDay, Commands FROM Camels
);
```
Объединил и верблюдов т.к. на результат это не повлияет
***
### 11.Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

```
CREATE TABLE IF NOT EXISTS young_animals AS (
SELECT Name, Type, BirthDay, TIMESTAMPDIFF(MONTH, BirthDay, CURDATE()) AS Age_Mounth 
FROM animals
WHERE TIMESTAMPDIFF(MONTH, BirthDay, CURDATE()) BETWEEN 12 AND 36
);
```
***
### 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

```
CREATE TABLE IF NOT EXISTS animals AS (
SELECT Name, Type, BirthDay, Commands, 'Horses' AS Belong FROM Horses
UNION  
SELECT Name, Type, BirthDay, Commands, 'Donkeys' AS Belong FROM Donkeys
UNION  
SELECT Name, Type, BirthDay, Commands, 'Camels' AS Belong FROM Camels
UNION 
SELECT Name, Type, BirthDay, Commands, 'Cats' AS Belong FROM Cats
UNION  
SELECT Name, Type, BirthDay, Commands, 'Dogs' AS Belong FROM Dogs
UNION  
SELECT Name, Type, BirthDay, Commands, 'Hamsters' AS Belong FROM Hamsters
);
```
### 13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
