drop type if exists shaise.plan.role_type;

create type  shaise.plan.role_type as enum (
    'ROLE_USER',
    'ROLE_ADMIN',
    'ROLE_SUPER_MEGA_GALAXY_ADMIN'
        );


create table if not exists plan.role (
    id bigserial,
    role_name shaise.plan.role_type not null unique , primary key (id));
    
alter table if exists plan.user add column if not exists login varchar(255) not null unique default '';

alter table if exists plan.user add column if not exists password varchar(255) not null default '';

alter table if exists plan.user add column if not exists role_id bigint;

alter table if exists plan.document_recipient add constraint FKqdyp5ovlu0pm0kta4o1t5hro foreign key (user_id) references shaise.plan.user;

alter table if exists plan.document_recipient add constraint FKgeltn7cj6a83s9ib3pn5wik foreign key (document_id) references shaise.plan.document;

alter table if exists plan.file add constraint FKqbd7l92rst6ysfqvep4uitu foreign key (document_id) references shaise.plan.document;

alter table if exists plan.user add constraint FKn82ha3ccdebhoka8fgdqeyy foreign key (role_id) references plan.role