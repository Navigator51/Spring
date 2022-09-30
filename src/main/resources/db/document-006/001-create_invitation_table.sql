drop type if exists shaise.plan.invitation_status_type;

create type  plan.invitation_status_type as enum (
    'SENT',
    'ACCEPTED',
    'REJECTED'
    );


create table if not exists plan.invitation
(
    id bigserial  constraint invitation_pk
        primary key,
    sender_id bigint not null,
    recipient_id bigint not null,
    status plan.invitation_status_type,
    creation_date timestamp,
    modify_date timestamp
);