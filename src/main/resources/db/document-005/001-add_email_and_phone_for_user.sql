alter table if exists shaise.plan."user"
add column if not exists email varchar(30);

alter table if exists shaise.plan."user"
    add column if not exists phone_number varchar(15);
