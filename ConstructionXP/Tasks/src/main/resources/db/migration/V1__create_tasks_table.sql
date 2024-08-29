CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       description VARCHAR(255) NOT NULL,
                       start_date DATE NOT NULL,
                       end_date DATE NOT NULL,
                       status VARCHAR(50) NOT NULL,
                       resources TEXT
);
