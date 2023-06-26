CREATE TABLE IF NOT EXISTS metrics (
    id SMALLINT PRIMARY KEY,
    endpoint VARCHAR(255) UNIQUE,
    requestpermin DOUBLE,
    errorrate DOUBLE,
    successrate DOUBLE
);

INSERT INTO metrics (id, endpoint, requestpermin, errorrate, successrate)
VALUES (1, "resource1", 1100.0, 11.3, 93.5);

INSERT INTO metrics (id, endpoint, requestpermin, errorrate, successrate)
VALUES (2, "resource2", 1200.0, 43.3, 54.5);

INSERT INTO metrics (id, endpoint, requestpermin, errorrate, successrate)
VALUES (3, "resource3", 1300.0, 45.3, 43.5);