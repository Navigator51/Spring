alter table shaise.plan.employee
    add column if not exists birthday date default now();

alter table shaise.plan.employee
    add column if not exists born_place varchar(30) default 'Lower Canibalovka';