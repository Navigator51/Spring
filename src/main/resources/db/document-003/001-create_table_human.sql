create table if not exists shaise.plan.human (
                                                 id bigserial constraint human_pk primary key ,
                                                 birthday date,
                                                 born_place varchar(30));

alter table shaise.plan.employee
drop column if exists birthday;

alter table shaise.plan.employee
    drop column if exists born_place;

alter table shaise.plan.employee
    add column if not exists human_id bigint constraint employee_id_fk
        references shaise.plan.human;

alter table shaise.plan.client
    drop column if exists birthday;

alter table shaise.plan.client
    drop column if exists born_place;

alter table shaise.plan.client
    add column if not exists human_id bigint constraint client_id_fk
        references shaise.plan.human;


