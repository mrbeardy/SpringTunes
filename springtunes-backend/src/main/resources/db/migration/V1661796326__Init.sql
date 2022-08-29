CREATE TABLE users (
    id UUID DEFAULT gen_random_uuid (),
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    role VARCHAR(25) NOT NULL DEFAULT 'ROLE_USER',
    enabled BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE INDEX ix_users_id ON users (id);

INSERT INTO users (username, role, password, enabled) VALUES 
(
    'admin', 
    'ROLE_ADMIN', 
    '$2a$10$gv0ZfUcfA0kZdMlpsSSWfutcWfA7JWtjyd4/QJ6NkKzIBdPZbcpKi', -- 'password'
    TRUE
),
(
    'michael', 
    'ROLE_USER',
    '$2a$10$gv0ZfUcfA0kZdMlpsSSWfutcWfA7JWtjyd4/QJ6NkKzIBdPZbcpKi', -- 'password'
    TRUE
);