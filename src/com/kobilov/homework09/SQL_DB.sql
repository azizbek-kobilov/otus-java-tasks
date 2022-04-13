
CREATE DATABASE testing_system;

CREATE TABLE questions
(
    id          SERIAL           PRIMARY KEY,
    question    VARCHAR(100)     NOT NULL
);

CREATE TABLE answers
(
    id              SERIAL           PRIMARY KEY,
    answer          VARCHAR(100)     NOT NULL,
    question_id     INTEGER          REFERENCES questions(id)
);

INSERT INTO questions(question)
VALUES
    ('Сколько месяцев в году?'),
    ('Сколько дней в неделе?'),
    ('Сколько секунд в минуте?');

INSERT INTO answers(answer, question_id)
VALUES
    ('5', 1),
    ('8', 1),
    ('12', 1),
    ('13', 2),
    ('7', 2),
    ('4', 2),
    ('60', 3),
    ('35', 3),
    ('22', 3);
