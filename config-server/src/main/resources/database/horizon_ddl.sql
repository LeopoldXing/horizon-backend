DROP DATABASE IF EXISTS horizon;

CREATE DATABASE horizon
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_general_ci;

USE horizon;

-- horizon.users definition
DROP TABLE IF EXISTS users;
CREATE TABLE `users`
(
    `id`                  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `email`               varchar(100) DEFAULT NULL,
    `dwolla_customer_url` varchar(255) DEFAULT NULL,
    `dwolla_customer_id`  varchar(100) DEFAULT NULL,
    `first_name`          varchar(100) DEFAULT NULL,
    `last_name`           varchar(100) DEFAULT NULL,
    `address`             varchar(255) DEFAULT NULL,
    `city`                varchar(100) DEFAULT NULL,
    `postal_code`         varchar(100) DEFAULT NULL,
    `date_of_birth`       date         DEFAULT NULL,
    `ssn`                 varchar(50)  DEFAULT NULL,
    `state`               varchar(10)  DEFAULT NULL,
    `created_at`          datetime     DEFAULT NULL,
    `created_by`          varchar(100) DEFAULT NULL,
    `last_modified_at`    datetime     DEFAULT NULL,
    `last_modified_by`    varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- horizon.banks definition
DROP TABLE IF EXISTS banks;
CREATE TABLE `banks`
(
    `id`                 varchar(100) NOT NULL,
    `account_id`         varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    `funding_source_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `shareable_id`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `user_id`            varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `banks_unique` (`shareable_id`),
    KEY                  `banks_users_FK` (`user_id`),
    CONSTRAINT `banks_users_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- horizon.transactions definition
DROP TABLE IF EXISTS transactions;
CREATE TABLE `transactions`
(
    `id`               varchar(100) NOT NULL,
    `name`             varchar(100) NOT NULL,
    `amount` double NOT NULL,
    `channel`          varchar(100) DEFAULT NULL,
    `category`         varchar(100) DEFAULT NULL,
    `sender_id`        varchar(100) DEFAULT NULL,
    `receiver_id`      varchar(100) DEFAULT NULL,
    `sender_bank_id`   varchar(100) DEFAULT NULL,
    `receiver_bank_id` varchar(100) DEFAULT NULL,
    `email`            varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                `transactions_banks_FK` (`sender_bank_id`),
    KEY                `transactions_banks_FK_1` (`receiver_bank_id`),
    CONSTRAINT `transactions_banks_FK` FOREIGN KEY (`sender_bank_id`) REFERENCES `banks` (`id`),
    CONSTRAINT `transactions_banks_FK_1` FOREIGN KEY (`receiver_bank_id`) REFERENCES `banks` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
