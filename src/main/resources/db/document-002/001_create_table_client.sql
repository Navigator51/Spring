create table if not exists plan.client
(
    id            bigserial
        constraint client_pk
            primary key,
    cash bigint,
    valuta varchar(30) not null,
    birthday date default now(),
    born_place varchar(30) default 'Lower Canibalovka'
);