create table Person (
    id uuid default random_uuid() PRIMARY KEY,
    name varchar(100) NOT NULL,
    phone varchar(100) NOT NULL,
    email varchar(100)
);
create table Hotel (
    id uuid default random_uuid() PRIMARY KEY,
    name varchar(100) NOT NULL,
    phone varchar(100) NOT NULL,
    email varchar(100),
    rooms_available int NOT NULL
);
create table Reservation (
    id uuid default random_uuid() PRIMARY KEY,
    hid varchar(100),
    uid varchar(100),
    number_Of_Rooms_Booked int NOT NULL,
    FOREIGN KEY (hid) REFERENCES Hotel(id),
    FOREIGN KEY (uid) REFERENCES Person(id)
);