USE prueba;

-- Create the Branch table
CREATE TABLE IF NOT EXISTS branch (
    id INT NOT NULL AUTO_INCREMENT,
    branch_id VARCHAR (255),
    branch_name VARCHAR(100),
    branch_location VARCHAR(255),
    PRIMARY KEY (id)
    );

    -- Create the Product table
    CREATE TABLE IF NOT EXISTS product (
        id INT NOT NULL AUTO_INCREMENT,
        product_id VARCHAR (255),
        product_name VARCHAR(100),
        product_description VARCHAR(255),
        product_price FLOAT,
        product_inventory_stock INTEGER,
        product_category VARCHAR(100),
        PRIMARY KEY (id)
        );

            -- Create the Product table
            CREATE TABLE IF NOT EXISTS user_table (
                id INT NOT NULL AUTO_INCREMENT,
                user_id VARCHAR (255),
                user_name VARCHAR(100),
                user_lastName VARCHAR(255),
                user_password VARCHAR(255),
                user_email VARCHAR(255),
                user_role VARCHAR(255),
                PRIMARY KEY (id)
                );