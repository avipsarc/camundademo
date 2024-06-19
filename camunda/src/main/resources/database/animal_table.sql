CREATE TABLE IF NOT EXISTS animal_table (
        animal VARCHAR(255) PRIMARY KEY,
        imageUrl VARCHAR(255) NOT NULL,
        image bytea,
        creationTimestamp TIMESTAMP,
        updationTimestamp TIMESTAMP
);
