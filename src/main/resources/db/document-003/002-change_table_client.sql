create type shaise.plan.gender_type as enum (
    'MAN',
    'WOMAN',
    'PIDAR',
    'TRANSGENDER',
    'LESBIAN',
    'NOT_BINARY_BEING'
    );

alter table shaise.plan.client
add column if not exists gender shaise.plan.gender_type;