-- auto-generated definition
create table if not exists plan.employee
(
    id            bigserial
        constraint employee_pk
            primary key,
    department_id bigint      not null        constraint employee_department_id_fk
            references department,
    chief_id      bigint
        constraint employee_employee_id_fk
            references employee,
    name          varchar(30) not null,
    salary        integer
);


