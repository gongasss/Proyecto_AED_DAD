# Proyecto conjunto AED / DAD

## Parte AED (Backend)

### Uso de la base de datos

- En el ZIP proporcionado hay múltiples archivos SQL, uno para cada tabla, esto se debe a que la tabla lap_times tiene más de 500.000 registros y esto puede suponer mucho tiempo (horas) a la hora de importar los datos, así que teniendo los ficheros por separado es posible decidir si insertar estos datos o no. Adicionalmente, **también hay un fichero único para todas las tablas dentro de la carpeta ficheroUnico**.

### Aspectos a tener en cuenta

- La entidad Results relaciona las entidades Driver y Race (relación Many to Many)
- Todas las entidades tienen su Dao.
- Las consultas HQL se encuentran en el Dao de la entidad a la que corresponde la consulta (la entidad que devuelve).
- Se utiliza un Mediator para encapsular todos los DAO en una sola clase y no instanciar cada uno de ellos desde el Main.
- La base de datos se ha creado manualmente siguiendo la estructura de los ficheros .csv descargados de internet (más info abajo).
- Para importar los datos se ha utilizado la herramienta para importar de MySQL Workbench para algunos ficheros, para otros que necesitaban ser procesados antes de insertarse, como Results.csv o Races.csv, se ha creado una clase que contiene la lógica necesaria para tratar estos datos e insertarlos en la base de datos utilizando el Dao. Esto ha sido necesario ya que habían valores "\N" que representan valores null, lo que impide insertar esas filas desde la herramienta de MySQLWorkbench directamente.

## Base de datos utilizada

https://www.kaggle.com/datasets/rohanrao/formula-1-world-championship-1950-2020

## Código SQL (Creación de tablas y BD)

```sql
create database formula1;

use formula1;

-- Tabla: circuits
CREATE TABLE circuits (
    circuitId INT PRIMARY KEY,
    circuitRef VARCHAR(50),
    name VARCHAR(100),
    location VARCHAR(100),
    country VARCHAR(50),
    lat FLOAT,
    lng FLOAT,
    alt INT,
    url VARCHAR(255)
);

-- Tabla: constructors_results
CREATE TABLE constructors_results (
    constructorResultsId INT PRIMARY KEY,
    raceId INT,
    constructorId INT,
    points FLOAT,
    status VARCHAR(50)
);

-- Tabla: constructor_standings
CREATE TABLE constructor_standings (
    constructorStandingsId INT PRIMARY KEY,
    raceId INT,
    constructorId INT,
    points FLOAT,
    position INT,
    positionText VARCHAR(10),
    wins INT
);

-- Tabla: constructors
CREATE TABLE constructors (
    constructorId INT PRIMARY KEY,
    constructorRef VARCHAR(50),
    name VARCHAR(100),
    nationality VARCHAR(50),
    url VARCHAR(255)
);

-- Tabla: driver_standings
CREATE TABLE driver_standings (
    driverStandingsId INT PRIMARY KEY,
    raceId INT,
    driverId INT,
    points FLOAT,
    position INT,
    positionText VARCHAR(10),
    wins INT
);

-- Tabla: drivers
CREATE TABLE drivers (
    driverId INT PRIMARY KEY,
    driverRef VARCHAR(50),
    number INT,
    code VARCHAR(10),
    forename VARCHAR(50),
    surname VARCHAR(50),
    dob DATE,
    nationality VARCHAR(50),
    url VARCHAR(255)
);

-- Tabla: lap_times
CREATE TABLE lap_times (
    raceId INT,
    driverId INT,
    lap INT,
    position INT,
    time VARCHAR(10),
    milliseconds INT,
    PRIMARY KEY (raceId, driverId, lap)
);

-- Tabla: pit_stops
CREATE TABLE pit_stops (
    raceId INT,
    driverId INT,
    stop INT,
    lap INT,
    time TIME,
    duration FLOAT,
    milliseconds INT,
    PRIMARY KEY (raceId, driverId, stop)
);

-- Tabla: qualifying
CREATE TABLE qualifying (
    qualifyId INT PRIMARY KEY,
    raceId INT,
    driverId INT,
    constructorId INT,
    number INT,
    position INT,
    q1 VARCHAR(10),
    q2 VARCHAR(10),
    q3 VARCHAR(10)
);

-- Tabla: races
CREATE TABLE races (
    raceId INT PRIMARY KEY,
    year INT,
    round INT,
    circuitId INT,
    name VARCHAR(100),
    date DATE,
    time TIME,
    url VARCHAR(255),
    fp1_date DATE,
    fp1_time TIME,
    fp2_date DATE,
    fp2_time TIME,
    fp3_date DATE,
    fp3_time TIME,
    quali_date DATE,
    quali_time TIME,
    sprint_date DATE,
    sprint_time TIME
);

-- Tabla para results.csv
CREATE TABLE results (
    resultId INT PRIMARY KEY,
    raceId INT NOT NULL,
    driverId INT NOT NULL,
    constructorId INT NOT NULL,
    number INT,
    grid INT,
    position INT,
    positionText VARCHAR(10),
    positionOrder INT,
    points DECIMAL(5, 2),
    laps INT,
    time VARCHAR(20),
    milliseconds BIGINT,
    fastestLap INT,
    _rank INT,
    fastestLapTime VARCHAR(10),
    fastestLapSpeed DECIMAL(8, 3),
    statusId INT
);

use formula1;

-- Tabla para seasons.csv
CREATE TABLE seasons (
    year INT PRIMARY KEY,
    url VARCHAR(255) NOT NULL
);

-- Tabla para sprint_results.csv
CREATE TABLE sprint_results (
    resultId INT PRIMARY KEY,
    raceId INT NOT NULL,
    driverId INT NOT NULL,
    constructorId INT NOT NULL,
    number INT,
    grid INT,
    position INT,
    positionText VARCHAR(10),
    positionOrder INT,
    points DECIMAL(5, 2),
    laps INT,
    time VARCHAR(20),
    milliseconds BIGINT,
    fastestLap INT,
    fastestLapTime VARCHAR(10),
    statusId INT
);

-- Tabla para status.csv
CREATE TABLE status (
    statusId INT PRIMARY KEY,
    status VARCHAR(50) NOT NULL
);


```
