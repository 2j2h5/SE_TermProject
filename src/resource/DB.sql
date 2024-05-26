CREATE DATABASE TERM_PROJECT;

USE TERM_PROJECT;

CREATE TABLE accounts (
    id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);


CREATE TABLE projects (
	id NUMERIC PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    responsiblePL VARCHAR(50),
    FOREIGN KEY (responsiblePL) REFERENCES accounts(id)
);


CREATE TABLE issues (
	id NUMERIC PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    priority VARCHAR(20),
    involvedProject NUMERIC,
    reporter VARCHAR(50),
    reportedDate DATETIME,
    state VARCHAR(20),
    fixer VARCHAR(50),
    assignee VARCHAR(50),
    FOREIGN KEY (involvedProject) REFERENCES projects(id),
    FOREIGN KEY (reporter) REFERENCES accounts(id),
    FOREIGN KEY (fixer) REFERENCES accounts(id),
    FOREIGN KEY (assignee) REFERENCES accounts(id)
);


CREATE TABLE comments (
	id NUMERIC PRIMARY KEY,
    content TEXT,
    writer VARCHAR(50),
    writedDate DATETIME,
    involvedIssue NUMERIC,
    FOREIGN KEY (writer) REFERENCES accounts(id),
    FOREIGN KEY (involvedIssue) REFERENCES issues(id)
);
