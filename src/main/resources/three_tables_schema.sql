-- User Table
CREATE TABLE user (
    id BIGSERIAL PRIMARY KEY,
    telegram_id VARCHAR(50) UNIQUE NOT NULL,
    username VARCHAR(100),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tab Table (Categories/Groups)
CREATE TABLE tab (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- Expense Table
CREATE TABLE expense (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    tab_id BIGINT NOT NULL,
    description VARCHAR(500) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    expense_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
    FOREIGN KEY (tab_id) REFERENCES tab(id) ON DELETE CASCADE
);

-- Indexes
CREATE INDEX idx_user_telegram_id ON user(telegram_id);
CREATE INDEX idx_tab_user_id ON tab(user_id);
CREATE INDEX idx_expense_user_id ON expense(user_id);
CREATE INDEX idx_expense_tab_id ON expense(tab_id);
CREATE INDEX idx_expense_date ON expense(expense_date);

