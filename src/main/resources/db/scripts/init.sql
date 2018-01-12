DROP DATABASE IF EXISTS test_spring_integration;

CREATE DATABASE test_spring_integration;

USE test_spring_integration;


### Creation of junior devs table ###
DROP TABLE IF EXISTS junior_devs;
CREATE TABLE IF NOT EXISTS junior_devs (
  id_bin  BINARY(16),
  id_text VARCHAR(36) GENERATED ALWAYS AS
  (insert(
      insert(
          insert(
              insert(hex(id_bin), 9, 0, '-'),
              14, 0, '-'),
          19, 0, '-'),
      24, 0, '-')
  ) VIRTUAL,
  firstname    VARCHAR(200),
  initials VARCHAR(200),
  surname VARCHAR(200),
  current_ranking INT,
  creation_date TIMESTAMP DEFAULT now(),
  PRIMARY KEY (id_bin)
);



### Creation of medior devs table ###
DROP TABLE IF EXISTS medior_devs;
CREATE TABLE IF NOT EXISTS medior_devs (
  id_bin  BINARY(16),
  id_text VARCHAR(36) GENERATED ALWAYS AS
  (insert(
      insert(
          insert(
              insert(hex(id_bin), 9, 0, '-'),
              14, 0, '-'),
          19, 0, '-'),
      24, 0, '-')
  ) VIRTUAL,
  firstname    VARCHAR(200),
  initials VARCHAR(200),
  surname VARCHAR(200),
  current_ranking INT,
  creation_date TIMESTAMP DEFAULT now(),
  PRIMARY KEY (id_bin)
);


### Creation of senior devs table ###
DROP TABLE IF EXISTS senior_devs;
CREATE TABLE IF NOT EXISTS senior_devs (
  id_bin  BINARY(16),
  id_text VARCHAR(36) GENERATED ALWAYS AS
  (insert(
      insert(
          insert(
              insert(hex(id_bin), 9, 0, '-'),
              14, 0, '-'),
          19, 0, '-'),
      24, 0, '-')
  ) VIRTUAL,
  firstname    VARCHAR(200),
  initials VARCHAR(200),
  surname VARCHAR(200),
  current_ranking INT,
  creation_date TIMESTAMP DEFAULT now(),
  PRIMARY KEY (id_bin)
);
