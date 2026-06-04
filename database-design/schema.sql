-- ROLES TABLE
CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

-- USERS TABLE
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT NOT NULL,
    
    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES roles(id)
);

-- RESTAURANT TABLES
CREATE TABLE restaurant_tables (
    id BIGSERIAL PRIMARY KEY,
    table_number INT NOT NULL UNIQUE,
    capacity INT NOT NULL,
    status VARCHAR(50) NOT NULL
);

-- MENU CATEGORIES
CREATE TABLE menu_categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- MENU ITEMS
CREATE TABLE menu_items (
    id BIGSERIAL PRIMARY KEY,
    category_id BIGINT NOT NULL,
    name VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    availability BOOLEAN DEFAULT TRUE,
    description TEXT,
    image_url VARCHAR(500),

    CONSTRAINT fk_menu_category
        FOREIGN KEY (category_id)
        REFERENCES menu_categories(id)
);

-- ORDERS
CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    table_id BIGINT NOT NULL,
    waiter_id BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    remarks TEXT,

    CONSTRAINT fk_order_table
        FOREIGN KEY (table_id)
        REFERENCES restaurant_tables(id),

    CONSTRAINT fk_order_waiter
        FOREIGN KEY (waiter_id)
        REFERENCES users(id)
);

-- ORDER ITEMS
CREATE TABLE order_items (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    menu_item_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_orderitem_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id),

    CONSTRAINT fk_orderitem_menuitem
        FOREIGN KEY (menu_item_id)
        REFERENCES menu_items(id)
);

-- BILLS
CREATE TABLE bills (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT UNIQUE NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    tax DECIMAL(10,2) NOT NULL,
    discount DECIMAL(10,2) DEFAULT 0,
    total DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_bill_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id)
);

-- PAYMENTS
CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    bill_id BIGINT UNIQUE NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_status VARCHAR(50) NOT NULL,
    transaction_reference VARCHAR(255),
    paid_at TIMESTAMP,

    CONSTRAINT fk_payment_bill
        FOREIGN KEY (bill_id)
        REFERENCES bills(id)
);