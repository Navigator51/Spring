create table if not exists shaise.plan.order_list
(client_id bigint not null constraint  order_list_fk  references shaise.plan.client,
"order" varchar(50) not null
)