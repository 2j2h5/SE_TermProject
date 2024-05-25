CREATE DATABASE TERM_PROJECT;

USE TERM_PROJECT;

CREATE TABLE accounts (
    ID VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);


CREATE TABLE projects (
    name VARCHAR(100) NOT NULL,
    description TEXT,
    responsiblePL_ID VARCHAR(50)
);


CREATE TABLE issues (
    title VARCHAR(100) NOT NULL,
    description TEXT,
    priority VARCHAR(20),
    involvedProject_name VARCHAR(100),
    reporter_ID VARCHAR(50),
    reportedDate DATETIME,
    state VARCHAR(20),
    fixer_ID VARCHAR(50),
    assignee_ID VARCHAR(50)
);


CREATE TABLE comments (
    content TEXT,
    writer_ID VARCHAR(50),
    writedDate DATETIME,
    involvedIssue_title VARCHAR(100)
);