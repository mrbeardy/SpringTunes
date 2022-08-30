CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE INDEX ix_account_id ON account(id);

CREATE TABLE authority (
    id SERIAL PRIMARY KEY,
    role varchar(25) NOT NULL
);
CREATE INDEX ix_authority_id ON authority(id);

CREATE TABLE account_authority (
    id SERIAL PRIMARY KEY,
    account_id SERIAL REFERENCES account(id),
    authority_id SERIAL REFERENCES authority(id)
);

INSERT INTO account (id, username, password, enabled) VALUES 
(
    '1',
    'admin', 
    '$2a$10$gv0ZfUcfA0kZdMlpsSSWfutcWfA7JWtjyd4/QJ6NkKzIBdPZbcpKi', -- 'password'
    TRUE
),
(
    '2',
    'michael', 
    '$2a$10$gv0ZfUcfA0kZdMlpsSSWfutcWfA7JWtjyd4/QJ6NkKzIBdPZbcpKi', -- 'password'
    TRUE
);

INSERT INTO authority (id, role) VALUES
(
    '1',
    'ROLE_ADMIN'
),
(
    '2',
    'ROLE_USER'
);

INSERT INTO account_authority(account_id, authority_id) VALUES
(
    '1', -- Admin user ID
    '1'  -- Admin role
),
(
    '1', -- Admin user ID
    '2'  -- User role
),
(
    '2', -- Michael user ID
    '2'  -- User role
);