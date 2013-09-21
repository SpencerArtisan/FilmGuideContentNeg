drop table FILM if exists;

create table FILM (ID integer identity primary key,
    VOTES integer not null,
    TITLE varchar(9) not null,
    RATING decimal(4,2) not null);
