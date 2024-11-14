CREATE SCHEMA ecommerce_trendhive;

use ecommerce_trendhive;

DROP TABLE products;
-- Product Microservice 
CREATE TABLE products (
	productId BIGINT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(255) NOT NULL,
    productDescription TEXT,
    productPrice DECIMAL(10, 2) NOT NULL,
    productCategory VARCHAR(100),
    productBrand VARCHAR(100),
    productSKU VARCHAR(50),
    productStatus VARCHAR(100),
    productCreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    productUpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Cart Microservice
CREATE TABLE cart (
	cartId BIGINT PRIMARY KEY AUTO_INCREMENT,
    userId BIGINT NOT NULL,
    totalQuantity INT NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50),
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE cartItems (
	cartItemId BIGINT PRIMARY KEY AUTO_INCREMENT,
    cartId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    cartItemPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cartId) REFERENCES cart(cartId) ON DELETE CASCADE
);

-- Order Microservice
CREATE TABLE orders (
	orderId BIGINT PRIMARY KEY AUTO_INCREMENT,
    userId BIGINT NOT NULL,
    orderStatus VARCHAR(50) NOT NULL,		-- e.g., "Pending", "Shipped", "Completed"
    totalAmount DECIMAL(15, 2) NOT NULL,
    paymentMethod VARCHAR(50),				-- e.g., "Credit Card", "Debit Card", "PayPal", "Google Pay", "PhonePe"
    orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deliveryDate TIMESTAMP,
    deliveryAddress VARCHAR(255),
    CONSTRAINT fk_user FOREIGN KEY (userId) REFERENCES user(userId)
);

CREATE TABLE orderItems (
	orderItemId BIGINT PRIMARY KEY AUTO_INCREMENT,
    orderId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(15, 2) NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (orderId) REFERENCES orders(orderId),
    CONSTRAINT fk_product FOREIGN KEY (productId) REFERENCES products(productId)
);

-- User Microservice
CREATE TABLE user (
	userId BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    dateOfBirth DATE,
    phoneNumber VARCHAR(20),
    address VARCHAR(255)
);

-- Inventory Microservice
CREATE TABLE inventory (
	inventoryId BIGINT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(255) NOT NULL,
    productDescription TEXT,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    warehouseLocation VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Payment Microservice
CREATE TABLE payments (
	paymentId BIGINT NOT NULL AUTO_INCREMENT,
	orderId BIGINT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    paymentStatus VARCHAR(50),
    paymentMethod VARCHAR(50) NOT NULL,
    transactionId VARCHAR(100),
    paymentDate DATETIME,
    confirmationNumber VARCHAR(100),
    cardNumber VARCHAR(20),
    cardExpiry VARCHAR(5),
    cardCvv VARCHAR(5),
    PRIMARY KEY (paymentId),
    FOREIGN KEY (orderId) REFERENCES orders(orderId)
);

-- Delivery Microservice
CREATE TABLE delivery (
	deliveryId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderId BIGINT NOT NULL,
    deliveryAddress VARCHAR(255) NOT NULL,
    deliveryDate DATE,
    deliveryStatus VARCHAR(50),
    deliveryProvider VARCHAR(100),
    trackingId VARCHAR(100),
    recipientContact VARCHAR(15),
    estimatedArrival DATE,
    confirmationNumber VARCHAR(100),
    FOREIGN KEY (orderId) REFERENCES orders(orderId)
);

-- Notification Microservice
CREATE TABLE notifications (
	notificationId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,                                    -- ID of the user to whom the notification is addressed
    notificationType VARCHAR(50) NOT NULL,                     -- Type of notification (e.g., EMAIL, SMS, PUSH)
    messageContent TEXT NOT NULL,                              -- Main content of the notification
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,             -- Timestamp of when the notification was created
    status VARCHAR(20) DEFAULT 'PENDING',                      -- Status of the notification (e.g., SENT, PENDING, FAILED)
    priority VARCHAR(10) DEFAULT 'MEDIUM'                      -- Priority level (e.g., HIGH, MEDIUM, LOW)
);

-- Search Filter Microservice
CREATE TABLE search_filter (
	filterId BIGINT AUTO_INCREMENT PRIMARY KEY,
    filterName VARCHAR(255) NOT NULL,
    filterType VARCHAR(100) NOT NULL,           		-- Type/category of filter (e.g., Date, Category)
    filterValue VARCHAR(255),                   		-- Value to match search criteria (e.g., date range or text)
    userId BIGINT NOT NULL,                     		-- ID of the user associated with the filter
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Rating and Review Microservice
CREATE TABLE ratingAndReview (
	reviewId BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL, -- Foreign key referencing the user who submitted the review
    productId BIGINT NOT NULL, -- Foreign key referencing the product being reviewed
    rating INT NOT NULL, -- Rating score (e.g., from 1 to 5)
    reviewText TEXT, -- Optional review text provided by the user
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES user(userId),
    FOREIGN KEY (productId) REFERENCES products(productId)
);
