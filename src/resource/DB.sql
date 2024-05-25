CREATE DATABASE TERM_PROJECT;

USE TERM_PROJECT;

CREATE TABLE accounts (
    ID VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);


CREATE TABLE projects (
    name VARCHAR(100) NOT NULL,
    description TEXT,
    responsiblePL VARCHAR(50),
    FOREIGN KEY (responsiblePL) REFERENCES accounts(ID)
);


CREATE TABLE issues (
    title VARCHAR(100) NOT NULL,
    description TEXT,
    priority VARCHAR(20),
    involvedProject VARCHAR(100),
    reporter VARCHAR(50),
    reportedDate DATETIME,
    state VARCHAR(20),
    fixer VARCHAR(50),
    assignee VARCHAR(50),
    FOREIGN KEY (involvedProject) REFERENCES projects(name),
    FOREIGN KEY (reporter) REFERENCES accounts(ID),
    FOREIGN KEY (fixer) REFERENCES accounts(ID),
    FOREIGN KEY (assignee) REFERENCES accounts(ID)
);


CREATE TABLE comments (
    content TEXT,
    writer VARCHAR(50),
    writedDate DATETIME,
    involvedIssue VARCHAR(100),
    FOREIGN KEY (writer) REFERENCES accounts(ID),
    FOREIGN KEY (involvedIssue) REFERENCES issues(title)
);
