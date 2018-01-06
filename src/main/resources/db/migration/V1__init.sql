CREATE SCHEMA IF NOT EXISTS users;

CREATE TABLE IF NOT EXISTS users.users (
	id BIGINT,
	nickname VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	creation_date  timestamp,
	password TEXT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	state VARCHAR(100) NOT NULL,
	type  VARCHAR(100) NOT NULL,
	is_account_non_expired boolean NOT NULL,
	is_credentials_non_expired boolean NOT NULL,
	is_enabled boolean NOT NULL
);




create sequence  hibernate_sequence start with 1 increment by 1;

