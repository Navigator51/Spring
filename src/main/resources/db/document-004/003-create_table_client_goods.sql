create table if not exists shaise.plan.goods(
    id bigserial constraint goods_pk primary key,
    cash bigint,
    valuta varchar(30),
    name varchar(30),
    description varchar(50)
);

create table if not exists shaise.plan.client_goods (
    client_id bigint not null constraint c_id_fk
        references shaise.plan.client,
        goods_id bigint not null constraint g_id_fk
        references shaise.plan.goods
)