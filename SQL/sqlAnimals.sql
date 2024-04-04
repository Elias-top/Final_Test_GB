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

CREATE TABLE IF NOT EXISTS young_animals AS (
SELECT Name, Type, BirthDay, TIMESTAMPDIFF(MONTH, BirthDay, CURDATE()) AS Age_Mounth 
FROM animals
WHERE TIMESTAMPDIFF(MONTH, BirthDay, CURDATE()) BETWEEN 12 AND 36
);

SELECT * FROM Pack_animals;
