create table users (
  id                bigserial    not null   primary key,
  email             varchar(100) not null   unique,
  password          varchar(150) not null,
  nama              varchar(100) not null,
  jabatan           varchar(100) not null,
  app               varchar(150) not null
);