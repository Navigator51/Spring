create table if not exists plan.user
(
    id                 bigserial constraint pk primary key,
    about              varchar(255),
    born_date          date,
    creation_date_time timestamp,
    middle_name        varchar(255),
    modify_date_time   timestamp,
    name               varchar(255) not null,
    surname            varchar(255),
    gender shaise.plan.gender_type
);


