alter table shaise.plan.human
add column if not exists creation_date_time timestamp with time zone;

alter table shaise.plan.human
add column if not exists last_modified_date_time timestamp with time zone;