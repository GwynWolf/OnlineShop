CREATE TABLE IF NOT EXISTS `categories` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `parent_id` BIGINT DEFAULT NULL,
                                 `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `slug` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `position` int(11) NOT NULL DEFAULT '0',
                                 `visible` tinyint(1) NOT NULL DEFAULT '1',
                                 `updatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`id`),
                                 KEY `parent_id` (`parent_id`),
                                 KEY `position` (`position`),
                                 KEY `visible` (`visible`),
                                 KEY `created` (`createdAt`),
                                 KEY `url` (`url`(100)),
                                 INDEX (position)
);
CREATE TABLE IF NOT EXISTS `categories_features` (
                                          `category_id` int(11) NOT NULL,
                                          `feature_id` int(11) NOT NULL,
                                          PRIMARY KEY (`category_id`,`feature_id`)
);

CREATE TABLE IF NOT EXISTS `deliveries` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `description` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                                 `free_from` decimal(10,2) DEFAULT '0.00',
                                 `price` decimal(10,2) DEFAULT '0.00',
                                 `enabled` tinyint(1) NOT NULL DEFAULT '0',
                                 `position` int(11) NOT NULL DEFAULT '0',
                                 `separate_payment` tinyint(1) DEFAULT '0',
                                 `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `settings` mediumtext COLLATE utf8mb4_unicode_ci,
                                 `module_id` int(11) DEFAULT NULL,
                                 `paid` tinyint(1) DEFAULT NULL,
                                 `hide_front_delivery_price` tinyint(1) DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `position` (`position`)
);
CREATE TABLE IF NOT EXISTS `delivery_payment` (
                                       `delivery_id` int(11) NOT NULL,
                                       `payment_method_id` int(11) NOT NULL,
                                       PRIMARY KEY (`delivery_id`,`payment_method_id`)
);

CREATE TABLE IF NOT EXISTS `order_history` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `order_id` int(11) NOT NULL,
                                    `manager_id` int(11) DEFAULT NULL,
                                    `new_status_id` int(11) DEFAULT NULL,
                                    `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    `text` text COLLATE utf8mb4_unicode_ci,
                                    PRIMARY KEY (`id`),
                                    KEY `order_id` (`order_id`)
);
CREATE TABLE IF NOT EXISTS `orders` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `delivery_id` int(11) DEFAULT '0',
                             `delivery_price` decimal(10,2) NOT NULL DEFAULT '0.00',
                             `payment_method_id` int(11) DEFAULT '0',
                             `paid` tinyint(1) NOT NULL DEFAULT '0',
                             `payment_date` datetime DEFAULT NULL,
                             `closed` tinyint(1) NOT NULL DEFAULT '0',
                             `date` datetime DEFAULT NULL,
                             `user_id` int(11) DEFAULT '0',
                             `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `phone` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '',
                             `phone_to_delete` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `comment` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `status_id` int(11) NOT NULL DEFAULT '0',
                             `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '',
                             `payment_details` mediumtext COLLATE utf8mb4_unicode_ci,
                             `ip` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `undiscounted_total_price` decimal(10,2) NOT NULL DEFAULT '0.00',
                             `total_price` decimal(10,2) NOT NULL DEFAULT '0.00',
                             `note` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `separate_delivery` tinyint(1) DEFAULT '0',
                             `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `lang_id` int(11) NOT NULL DEFAULT '0',
                             `referer_channel` enum('email','search','social','referral','unknown') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `referer_source` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `login` (`user_id`),
                             KEY `written_off` (`closed`),
                             KEY `date` (`date`),
                             KEY `status` (`status_id`),
                             KEY `payment_status` (`paid`),
                             KEY `code` (`url`(100)),
                             KEY `phone` (`phone`)
);
CREATE TABLE IF NOT EXISTS `orders_labels` (
                                    `order_id` int(11) NOT NULL,
                                    `label_id` int(11) NOT NULL,
                                    PRIMARY KEY (`order_id`,`label_id`)
);
CREATE TABLE IF NOT EXISTS `orders_status` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                    `is_close` tinyint(1) NOT NULL DEFAULT '0',
                                    `color` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'ffffff',
                                    `position` int(11) NOT NULL DEFAULT '0',
                                    `status_1c` enum('not_use','new','accepted','to_delete') COLLATE utf8mb4_unicode_ci DEFAULT 'not_use',
                                    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `pages` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `name_h1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `meta_description` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `description` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                            `position` int(11) NOT NULL DEFAULT '0',
                            `visible` tinyint(1) NOT NULL DEFAULT '0',
                            `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`),
                            KEY `order_num` (`position`),
                            KEY `url` (`url`(100))
);
CREATE TABLE IF NOT EXISTS `payment_methods` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `module` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '',
                                      `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `description` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                                      `currency_id` int(11) NOT NULL DEFAULT '0',
                                      `settings` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                                      `auto_submit` tinyint(1) DEFAULT '0',
                                      `enabled` tinyint(1) NOT NULL DEFAULT '0',
                                      `position` int(11) NOT NULL DEFAULT '0',
                                      `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `novaposhta_cost__cash_on_delivery` tinyint(1) DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `position` (`position`)
);
CREATE TABLE IF NOT EXISTS `products` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(255) NOT NULL,                     -- Название (обязательное)
                                          `slug` VARCHAR(255) NOT NULL UNIQUE,              -- Уникальный слаг (автогенерация из name)
                                          `description` TEXT DEFAULT NULL,                  -- Описание (опционально)
                                          `price` DECIMAL(10,2) NOT NULL DEFAULT 0.00,      -- Цена (>= 0)
                                          `category_id` INT NOT NULL,                       -- Ссылка на Category (обязательное)
                                          `is_active` TINYINT(1) NOT NULL DEFAULT 1,        -- Статус (по умолчанию true)
                                          `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Дата создания
                                          `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Дата обновления
                                          PRIMARY KEY (`id`)

);
CREATE TABLE IF NOT EXISTS `products_categories` (
                                          `product_id` int(11) NOT NULL,
                                          `category_id` int(11) NOT NULL,
                                          `position` int(11) NOT NULL DEFAULT '0',
                                          PRIMARY KEY (`product_id`,`category_id`),
                                          KEY `position` (`position`),
                                          KEY `product_id` (`product_id`),
                                          KEY `category_id` (`category_id`)
);

UPDATE categories SET parent_id = NULL WHERE parent_id = 0;
INSERT INTO categories (name, slug, parent_id, visible) VALUES
                                                            ('Electronics', 'electronics', NULL, 1),
                                                            ('Phones', 'phones', 1, 1),
                                                            ('Laptops', 'laptops', 1, 1),
                                                            ('Clothing', 'clothing', NULL, 1),
                                                            ('Men Clothing', 'men-clothing', 4, 1);