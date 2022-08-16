-- auto-generated definition
create table if not exists plan.department
(
    id   bigserial
        constraint department_pk
            primary key,
    name varchar(30) not null
);

alter table plan.department
    owner to postgres;
