DROP DATABASE IF EXISTS `horizon`;

CREATE DATABASE `horizon` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `horizon`;

-- horizon.accounts definition
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`
(
    `id`                    bigint                                                        NOT NULL AUTO_INCREMENT,
    `plaid_account_id`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `bank_id`               bigint                                                        DEFAULT NULL,
    `name`                  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `official_name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `owner_id`              bigint                                                        NOT NULL,
    `current_balance`       decimal(10, 2)                                                NOT NULL,
    `available_balance`     decimal(10, 2)                                                DEFAULT NULL,
    `limit_balance`         decimal(10, 2)                                                DEFAULT NULL,
    `iso_currency_code`     varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `institution_id`        varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `shareable_id`          varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `funding_source_url`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `mask`                  varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL,
    `persistent_account_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `type`                  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `subtype`               varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`            datetime                                                      DEFAULT NULL,
    `created_by`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_at`      datetime                                                      DEFAULT NULL,
    `last_modified_by`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;
