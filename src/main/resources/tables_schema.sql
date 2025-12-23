-- Enable UUID extension if not exists
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id VARCHAR(50) PRIMARY KEY DEFAULT replace(uuid_generate_v4()::text, '-', ''),
    telegram_id VARCHAR(50) UNIQUE NOT NULL,
    username VARCHAR(100),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tag (
    id VARCHAR(50) PRIMARY KEY DEFAULT replace(uuid_generate_v4()::text, '-', ''),
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    user_id VARCHAR(50) NOT NULL,
    color VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_tag_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);


CREATE TABLE expense (
    id VARCHAR(50) PRIMARY KEY DEFAULT replace(uuid_generate_v4()::text, '-', ''),
    user_id VARCHAR(50) NOT NULL,
    tag_id VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    expense_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_expense_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_expense_tag
        FOREIGN KEY (tag_id)
        REFERENCES tag(id)
        ON DELETE CASCADE
);


CREATE INDEX idx_users_telegram_id ON users(telegram_id);
CREATE INDEX idx_tag_user_id ON tag(user_id);
CREATE INDEX idx_expense_user_id ON expense(user_id);
CREATE INDEX idx_expense_tag_id ON expense(tag_id);
CREATE INDEX idx_expense_date ON expense(expense_date);
