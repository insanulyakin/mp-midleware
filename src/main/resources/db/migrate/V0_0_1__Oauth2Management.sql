create table if not exists oauth_access_token (
  authentication_id VARCHAR(255) not null PRIMARY KEY,
  token_id          VARCHAR(255) not null,
  token             bytea,
  user_name         VARCHAR(255) not null,
  client_id         VARCHAR(255),
  authentication    bytea,
  refresh_token     VARCHAR(255),
  raw_token         text         not null
);

create table if not exists oauth_refresh_token (
  token_id       VARCHAR(255),
  token          text,
  authentication bytea
);