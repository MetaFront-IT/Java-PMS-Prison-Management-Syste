کد های dataBase
CREATE TABLE Prisoner(
                         id serial primary key,
                         first_name varchar(50),
                         last_name varchar(50),
                         national_code varchar(50),
                         birth_date DATE,
                         gender varchar(8),
                         status varchar(8),
                         sentence_id int,
                         cell_id int
);

CREATE TABLE Sentences(
    id SERIAL PRIMARY KEY,
    crime_id INT,
    prisoner_id INT,
    start_date DATE,
    end_date DATE,
    status VARCHAR(15)
);

CREATE TABLE Crime(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50)
);

CREATE TABLE Cell(
    id SERIAL PRIMARY KEY,
    cell_number INT,
    block_id INT
);

CREATE TABLE Block(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE Guard(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    national_code varchar(50),
    shift varchar(20),
    block_id int,

    CONSTRAINT fk_block_id
                 FOREIGN KEY (block_id)
                 REFERENCES Block(id)
);

CREATE TABLE Transfer(
    id SERIAL PRIMARY KEY,
    prisoner_id INT,
    from_cell INT,
    to_cell INT,
    guard_id INT,
    transfer_date DATE,
    description VARCHAR(150),

    CONSTRAINT fk_prisoner_id
                    FOREIGN KEY (prisoner_id)
                    REFERENCES prisoner(id),
    CONSTRAINT fk_from_cell_id
                     FOREIGN KEY (from_cell)
                     REFERENCES Cell(id),
    CONSTRAINT fk_to_cell_id
                     FOREIGN KEY (to_cell)
                     REFERENCES Cell(id)
);

CREATE TABLE Visitor(
    id SERIAL PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    national_code varchar(50),
    relation_to_prisoner varchar(50)
);

CREATE TABLE Visit(
    id SERIAL PRIMARY KEY,
    prisoner_id INT,
    visitor_id INT,
    visit_date DATE,
    visit_time TIME,
    CONSTRAINT fk_prisoner_id
                    FOREIGN KEY (prisoner_id)
                    REFERENCES prisoner(id),
    CONSTRAINT fk_visitor_id
                    FOREIGN KEY (visitor_id)
                    REFERENCES prisoner(id)
);

ALTER TABLE Prisoner
    ADD CONSTRAINT fk_sentence_id
        foreign key (sentence_id)
            REFERENCES Sentences(id),
    ADD CONSTRAINT fk_cell_id
        FOREIGN KEY (cell_id)
            REFERENCES Cell(id);

ALTER TABLE Sentences
    ADD CONSTRAINT fk_crime_id
        FOREIGN KEY (crime_id)
            REFERENCES Crime(id),
    ADD CONSTRAINT fk_prisoner_id
        FOREIGN KEY (prisoner_id)
            REFERENCES Prisoner(id);

ALTER TABLE Cell
    ADD
        CONSTRAINT fk_block_id
            FOREIGN KEY (block_id)
                REFERENCES Block(id);

ALTER TABLE Transfer
ADD CONSTRAINT fk_guard_id
FOREIGN KEY (guard_id)
REFERENCES Guard(id);

ALTER TABLE cell
ADD COLUMN capacity int;

ALTER TABLE Visit
Add COLUMN status varchar(20);


ALTER TABLE prisoner
ALTER COLUMN status TYPE VARCHAR(20);

ALTER TABLE Visit
    drop CONSTRAINT fk_visitor_id;

ALTER TABLE visit
ADD CONSTRAINT fk_visitor_id
FOREIGN KEY (visitor_id)
REFERENCES Visitor(id);
