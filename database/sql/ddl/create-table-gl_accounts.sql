-- Create General Ledger Accounts Table
USE kontenplan_db;

DROP TABLE IF EXISTS gl_accounts;

CREATE TABLE gl_accounts
(
    no          CHAR(20) NOT NULL,
    type        ENUM ('class', 'category', 'account') NOT NULL ,
    name        VARCHAR(255),
    description TEXT,
    balance     DECIMAL(18, 2),
    parent_no   CHAR(20),

    PRIMARY KEY (no),

    CONSTRAINT fk_gl_accounts_gl_accounts
        FOREIGN KEY (parent_no) REFERENCES gl_accounts (no)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;