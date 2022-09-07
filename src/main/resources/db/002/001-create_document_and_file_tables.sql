create table if not exists plan.document (
    id bigserial, 
    creation_date timestamp, 
    modify_date timestamp, 
    status varchar(255), 
    creator_id bigint, 
    sender_id bigint,     primary key (id));

create table if not exists plan.file (
    id bigserial, 
    creation_date timestamp, 
    file_type varchar(255), 
    modify_date timestamp, 
    name varchar(255), 
    document_id bigint, primary key (id));

create table if not exists plan.document_recipient (
    document_id bigint not null, 
    user_id bigint not null)