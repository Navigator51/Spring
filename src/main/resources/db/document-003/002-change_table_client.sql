create type  shaise.plan.gender_type as enum (
    'ENUM_MAN',
    'ENUM_WOMAN',
    'ENUM_PIDAR',
    'ENUM_TRANSGENDER',
    'ENUM_LESBIAN',
    'ENUM_NOT_BINARY_BEING'
    );

alter table shaise.plan.client
add column if not exists gender shaise.plan.gender_type;