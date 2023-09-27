USE prueba;

-- Create the Branch table
CREATE TABLE IF NOT EXISTS branch (
    id INT NOT NULL AUTO_INCREMENT,
    branch_id VARCHAR (255),
    branch_name VARCHAR(100),
    branch_location VARCHAR(255),
    PRIMARY KEY (id)
    );