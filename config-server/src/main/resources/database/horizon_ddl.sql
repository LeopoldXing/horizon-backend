DROP
DATABASE IF EXISTS `horizon`;

CREATE
DATABASE `horizon` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE
`horizon`;


-- horizon.categories definition
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`
(
    `id`               bigint                                                        NOT NULL AUTO_INCREMENT,
    `category_name`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `description`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `category_code`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`       datetime                                                      DEFAULT NULL,
    `created_by`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at` datetime                                                      DEFAULT NULL,
    `last_modified_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.country_code definition
DROP TABLE IF EXISTS `country_code`;
CREATE TABLE `country_code`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `code`             varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `country_name`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`       datetime                                                      DEFAULT NULL,
    `created_by`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at` datetime                                                      DEFAULT NULL,
    `last_modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `country_code_unique` (`code`),
    UNIQUE KEY `country_code_unique_1` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.plaid_customers definition
DROP TABLE IF EXISTS `plaid_customers`;
CREATE TABLE `plaid_customers`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `shareable_url`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `phone_number`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`       datetime                                                      DEFAULT NULL,
    `created_by`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at` datetime                                                      DEFAULT NULL,
    `last_modified_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.dwolla_customer definition
DROP TABLE IF EXISTS `dwolla_customer`;
CREATE TABLE `dwolla_customer`
(
    `id`                  bigint NOT NULL AUTO_INCREMENT,
    `dwolla_customer_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `customer_type`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `customer_status`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`          datetime                                                      DEFAULT NULL,
    `created_by`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at`    datetime                                                      DEFAULT NULL,
    `last_modified_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.users definition
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`                 bigint NOT NULL AUTO_INCREMENT,
    `email`              varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `first_name`         varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_name`          varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `address`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `city`               varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `state`              varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `postal_code`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `date_of_birth`      date                                                          DEFAULT NULL,
    `ssn`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `plaid_customer_id`  bigint                                                        DEFAULT NULL,
    `dwolla_customer_id` bigint                                                        DEFAULT NULL,
    `created_at`         datetime                                                      DEFAULT NULL,
    `created_by`         varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at`   datetime                                                      DEFAULT NULL,
    `last_modified_by`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                  `users_dwolla_customer_FK` (`dwolla_customer_id`),
    KEY                  `users_plaid_customers_FK` (`plaid_customer_id`),
    CONSTRAINT `users_dwolla_customer_FK` FOREIGN KEY (`dwolla_customer_id`) REFERENCES `dwolla_customer` (`id`),
    CONSTRAINT `users_plaid_customers_FK` FOREIGN KEY (`plaid_customer_id`) REFERENCES `plaid_customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.banks definition
DROP TABLE IF EXISTS `banks`;
CREATE TABLE `banks`
(
    `id`               bigint                                                        NOT NULL AUTO_INCREMENT,
    `name`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `url`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `status`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`       datetime                                                      DEFAULT NULL,
    `created_by`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at` datetime                                                      DEFAULT NULL,
    `last_modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.link_bank_country_code definition
DROP TABLE IF EXISTS `link_bank_country_code`;
CREATE TABLE `link_bank_country_code`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `bank_id`          bigint NOT NULL,
    `country_code_id`  bigint NOT NULL,
    `created_at`       datetime                                                      DEFAULT NULL,
    `created_by`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at` datetime                                                      DEFAULT NULL,
    `last_modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                `link_bank_country_code_banks_FK` (`bank_id`),
    KEY                `link_bank_country_code_country_code_FK` (`country_code_id`),
    CONSTRAINT `link_bank_country_code_banks_FK` FOREIGN KEY (`bank_id`) REFERENCES `banks` (`id`),
    CONSTRAINT `link_bank_country_code_users_FK` FOREIGN KEY (`country_code_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.accounts definition
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`
(
    `id`                    bigint                                                        NOT NULL AUTO_INCREMENT,
    `name`                  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `official_name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `ownerId`               bigint                                                        NOT NULL,
    `current_balance`       decimal(10, 2)                                                NOT NULL,
    `available_balance`     decimal(10, 2)                                                DEFAULT NULL,
    `limit_balance`         decimal(10, 2)                                                DEFAULT NULL,
    `iso_currency_code`     varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `institution_id`        bigint                                                        DEFAULT NULL,
    `shareable_id`          varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `funding_source_url`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `mask`                  varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `persistent_account_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `type`                  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `sub_type`              varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`            datetime                                                      DEFAULT NULL,
    `created_by`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at`      datetime                                                      DEFAULT NULL,
    `last_modified_by`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                     `accounts_banks_FK` (`institution_id`),
    KEY                     `accounts_users_FK` (`ownerId`),
    CONSTRAINT `accounts_banks_FK` FOREIGN KEY (`institution_id`) REFERENCES `banks` (`id`),
    CONSTRAINT `accounts_users_FK` FOREIGN KEY (`ownerId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- horizon.transactions definition
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions`
(
    `id`                  bigint                                                        NOT NULL AUTO_INCREMENT,
    `name`                varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `amount`              decimal(10, 2)                                                NOT NULL,
    `currency`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `routing_number`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `beneficiary_name`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `sender_id`           bigint                                                        DEFAULT NULL,
    `receiver_id`         bigint                                                        DEFAULT NULL,
    `date`                date                                                          DEFAULT NULL,
    `datetime`            datetime                                                      DEFAULT NULL,
    `authorized_date`     date                                                          DEFAULT NULL,
    `authorized_datetime` datetime                                                      DEFAULT NULL,
    `status`              varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `sender_bank_id`      bigint                                                        DEFAULT NULL,
    `receiver_bank_id`    bigint                                                        DEFAULT NULL,
    `categoryId`          bigint                                                        DEFAULT NULL,
    `channel`             varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `email`               varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`          datetime                                                      DEFAULT NULL,
    `created_by`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at`    datetime                                                      DEFAULT NULL,
    `last_modified_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                   `transactions_banks_FK` (`sender_bank_id`),
    KEY                   `transactions_banks_FK_1` (`receiver_bank_id`),
    KEY                   `transactions_users_FK` (`sender_id`),
    KEY                   `transactions_users_FK_1` (`receiver_id`),
    KEY                   `transactions_categories_FK` (`categoryId`),
    CONSTRAINT `transactions_banks_FK` FOREIGN KEY (`sender_bank_id`) REFERENCES `banks` (`id`),
    CONSTRAINT `transactions_banks_FK_1` FOREIGN KEY (`receiver_bank_id`) REFERENCES `banks` (`id`),
    CONSTRAINT `transactions_categories_FK` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`),
    CONSTRAINT `transactions_users_FK` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`),
    CONSTRAINT `transactions_users_FK_1` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
