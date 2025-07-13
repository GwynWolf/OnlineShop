
CREATE TABLE IF NOT EXISTS `authors` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                              `position_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                              `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                              `meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                              `meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                              `meta_description` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                              `description` mediumtext COLLATE utf8mb4_unicode_ci,
                              `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              `position` int(11) NOT NULL DEFAULT '0',
                              `visible` tinyint(1) NOT NULL DEFAULT '0',
                              `socials` text COLLATE utf8mb4_unicode_ci,
                              PRIMARY KEY (`id`),
                              KEY `url` (`url`(100)),
                              KEY `name` (`name`(100))
);

CREATE TABLE IF NOT EXISTS `blog` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `author_id` int(11) DEFAULT NULL,
                           `name` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `meta_description` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `annotation` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                           `description` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                           `visible` tinyint(1) NOT NULL DEFAULT '0',
                           `show_table_content` tinyint(1) NOT NULL DEFAULT '0',
                           `date` timestamp NULL DEFAULT NULL,
                           `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           `main_category_id` int(11) DEFAULT NULL,
                           `read_time` int(11) DEFAULT NULL,
                           `updated_date` date DEFAULT NULL,
                           `rating` float(3,1) DEFAULT '0.0',
                           `votes` int(11) DEFAULT '0',
                           PRIMARY KEY (`id`),
                           KEY `enabled` (`visible`),
                           KEY `url` (`url`(100))
);
CREATE TABLE IF NOT EXISTS `blog_categories` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `parent_id` int(11) NOT NULL DEFAULT '0',
                                      `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `name_h1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `meta_description` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `annotation` mediumtext COLLATE utf8mb4_unicode_ci,
                                      `description` mediumtext COLLATE utf8mb4_unicode_ci,
                                      `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `position` int(11) NOT NULL DEFAULT '0',
                                      `visible` tinyint(1) NOT NULL DEFAULT '1',
                                      `external_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `level_depth` tinyint(1) NOT NULL DEFAULT '1',
                                      `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                      `created` timestamp NULL DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `parent_id` (`parent_id`),
                                      KEY `position` (`position`),
                                      KEY `visible` (`visible`),
                                      KEY `external_id` (`external_id`),
                                      KEY `created` (`created`),
                                      KEY `url` (`url`(100))
);
CREATE TABLE IF NOT EXISTS `blog_categories_relation` (
                                               `post_id` int(11) NOT NULL,
                                               `category_id` int(11) NOT NULL,
                                               `position` int(11) NOT NULL DEFAULT '0',
                                               PRIMARY KEY (`post_id`,`category_id`),
                                               KEY `position` (`position`),
                                               KEY `post_id` (`post_id`),
                                               KEY `category_id` (`category_id`)
);
CREATE TABLE IF NOT EXISTS `brands` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `meta_description` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `annotation` mediumtext COLLATE utf8mb4_unicode_ci,
                             `description` mediumtext COLLATE utf8mb4_unicode_ci,
                             `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `position` int(11) NOT NULL DEFAULT '0',
                             `visible` tinyint(1) NOT NULL DEFAULT '0',
                             `name_h1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '',
                             PRIMARY KEY (`id`),
                             KEY `url` (`url`(100)),
                             KEY `name` (`name`(100))
);
CREATE TABLE IF NOT EXISTS `callbacks` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                `message` mediumtext COLLATE utf8mb4_unicode_ci,
                                `processed` tinyint(1) NOT NULL DEFAULT '0',
                                `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                `admin_notes` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `categories` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `parent_id` int(11) DEFAULT NULL,
                                 `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `name_h1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `meta_description` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `annotation` mediumtext COLLATE utf8mb4_unicode_ci,
                                 `description` mediumtext COLLATE utf8mb4_unicode_ci,
                                 `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `position` int(11) NOT NULL DEFAULT '0',
                                 `visible` tinyint(1) NOT NULL DEFAULT '1',
                                 `show_table_content` tinyint(1) NOT NULL DEFAULT '0',
                                 `external_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `level_depth` tinyint(1) NOT NULL DEFAULT '1',
                                 `auto_meta_title` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `auto_meta_keywords` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `auto_meta_desc` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `auto_description` mediumtext COLLATE utf8mb4_unicode_ci,
                                 `auto_annotation` mediumtext COLLATE utf8mb4_unicode_ci,
                                 `last_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 `created` timestamp NULL DEFAULT NULL,
                                 `auto_h1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `parent_id` (`parent_id`),
                                 KEY `position` (`position`),
                                 KEY `visible` (`visible`),
                                 KEY `external_id` (`external_id`),
                                 KEY `created` (`created`),
                                 KEY `url` (`url`(100))
);
CREATE TABLE IF NOT EXISTS `categories_features` (
                                          `category_id` int(11) NOT NULL,
                                          `feature_id` int(11) NOT NULL,
                                          PRIMARY KEY (`category_id`,`feature_id`)
);
CREATE TABLE IF NOT EXISTS `comments` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `parent_id` int(11) NOT NULL DEFAULT '0',
                               `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `ip` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                               `object_id` int(11) NOT NULL DEFAULT '0',
                               `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `text` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                               `type` enum('product','post') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'product',
                               `approved` int(1) NOT NULL DEFAULT '0',
                               `lang_id` int(11) NOT NULL DEFAULT '0',
                               `user_id` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `product_id` (`object_id`),
                               KEY `type` (`type`),
                               KEY `parent_id` (`parent_id`)
);

CREATE TABLE IF NOT EXISTS `currencies` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `sign` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `code` char(3) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `rate_from` decimal(10,2) NOT NULL DEFAULT '1.00',
                                 `rate_to` decimal(10,2) NOT NULL DEFAULT '1.00',
                                 `cents` int(1) NOT NULL DEFAULT '2',
                                 `position` int(11) NOT NULL DEFAULT '0',
                                 `enabled` tinyint(1) NOT NULL DEFAULT '1',
                                 PRIMARY KEY (`id`),
                                 KEY `position` (`position`)
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

CREATE TABLE IF NOT EXISTS `features` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `position` int(11) NOT NULL DEFAULT '0',
                               `in_filter` tinyint(1) DEFAULT '0',
                               `auto_name_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `auto_value_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `external_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `url_in_product` tinyint(1) DEFAULT '0',
                               `to_index_new_value` tinyint(1) DEFAULT '0',
                               `description` mediumtext COLLATE utf8mb4_unicode_ci,
                               `visible` tinyint(1) DEFAULT '1',
                               `show_in_product` int(2) NOT NULL DEFAULT '1',
                               PRIMARY KEY (`id`),
                               KEY `position` (`position`),
                               KEY `in_filter` (`in_filter`)
);
CREATE TABLE IF NOT EXISTS `features_aliases` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT,
                                       `variable` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                       `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `position` int(11) NOT NULL DEFAULT '0',
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `variable` (`variable`(100)),
                                       KEY `position` (`position`)
);
CREATE TABLE IF NOT EXISTS `features_aliases_values` (
                                              `id` int(11) NOT NULL AUTO_INCREMENT,
                                              `feature_alias_id` int(11) NOT NULL,
                                              `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                              `feature_id` int(11) DEFAULT '0',
                                              PRIMARY KEY (`id`),
                                              KEY `feature_id` (`feature_id`),
                                              KEY `feature_alias_id` (`feature_alias_id`),
                                              KEY `value` (`value`(100))
);
CREATE TABLE IF NOT EXISTS `features_values` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `feature_id` int(11) NOT NULL,
                                      `value` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `translit` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                      `position` int(11) NOT NULL DEFAULT '0',
                                      `to_index` tinyint(1) DEFAULT '0',
                                      `external_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      UNIQUE KEY `feature_id_translit` (`feature_id`,`translit`(100)),
                                      KEY `feature_id` (`feature_id`),
                                      KEY `position` (`position`),
                                      KEY `value` (`value`(64))
);
CREATE TABLE IF NOT EXISTS `features_values_aliases_values` (
                                                     `feature_alias_id` int(11) NOT NULL,
                                                     `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                                                     `feature_id` int(11) NOT NULL,
                                                     `lang_id` int(11) NOT NULL,
                                                     `feature_value_id` int(11) NOT NULL,
                                                     KEY `feature_alias_id` (`feature_alias_id`),
                                                     KEY `feature_id` (`feature_id`),
                                                     KEY `lang_id` (`lang_id`)
);
CREATE TABLE IF NOT EXISTS `feedbacks` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `ip` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                `message` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                                `processed` tinyint(1) NOT NULL DEFAULT '0',
                                `lang_id` int(11) NOT NULL DEFAULT '0',
                                `is_admin` tinyint(1) NOT NULL DEFAULT '0',
                                `parent_id` int(11) NOT NULL DEFAULT '0',
                                PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `images` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `product_id` int(11) NOT NULL DEFAULT '0',
                             `filename` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `position` int(11) NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`),
                             KEY `product_id` (`product_id`),
                             KEY `position` (`position`),
                             KEY `filename` (`filename`(100))
);

CREATE TABLE IF NOT EXISTS `labels` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `color` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                             `position` int(11) NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `managers` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `lang` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'ru',
                               `login` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                               `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                               `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                               `permissions` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                               `cnt_try` tinyint(4) NOT NULL DEFAULT '0',
                               `last_try` date DEFAULT NULL,
                               `comment` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT '',
                               `menu_status` tinyint(1) NOT NULL DEFAULT '1',
                               `menu` mediumtext COLLATE utf8mb4_unicode_ci,
                               `last_activity` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               PRIMARY KEY (`id`),
                               KEY `login` (`login`(100))
);
CREATE TABLE IF NOT EXISTS `menu` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `group_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                           `visible` tinyint(1) NOT NULL DEFAULT '1',
                           `position` int(11) NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`),
                           KEY `visible` (`visible`),
                           KEY `position` (`position`)
);
CREATE TABLE IF NOT EXISTS `menu_items` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `menu_id` int(11) NOT NULL DEFAULT '0',
                                 `parent_id` int(11) NOT NULL DEFAULT '0',
                                 `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `url` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                                 `is_target_blank` tinyint(1) NOT NULL DEFAULT '0',
                                 `visible` tinyint(1) NOT NULL DEFAULT '1',
                                 `position` int(11) NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`),
                                 KEY `menu_id` (`menu_id`),
                                 KEY `parent_id` (`parent_id`),
                                 KEY `visible` (`visible`),
                                 KEY `position` (`position`)
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
CREATE TABLE IF NOT EXISTS `products_features_values` (
                                               `product_id` int(11) NOT NULL,
                                               `value_id` int(11) NOT NULL,
                                               UNIQUE KEY `product_id_value_id` (`product_id`,`value_id`),
                                               KEY `product_id` (`product_id`),
                                               KEY `value_id` (`value_id`)
);
CREATE TABLE IF NOT EXISTS `purchases` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `order_id` int(11) NOT NULL DEFAULT '0',
                                `product_id` int(11) DEFAULT '0',
                                `variant_id` int(11) DEFAULT '0',
                                `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '',
                                `variant_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '',
                                `undiscounted_price` decimal(10,2) NOT NULL DEFAULT '0.00',
                                `price` decimal(10,2) NOT NULL DEFAULT '0.00',
                                `amount` int(11) NOT NULL DEFAULT '0',
                                `sku` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '',
                                `units` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '',
                                PRIMARY KEY (`id`),
                                KEY `order_id` (`order_id`),
                                KEY `product_id` (`product_id`),
                                KEY `variant_id` (`variant_id`)
);
CREATE TABLE IF NOT EXISTS `related_blogs` (
                                    `post_id` int(11) NOT NULL,
                                    `related_id` int(11) NOT NULL,
                                    `position` int(11) NOT NULL DEFAULT '0',
                                    PRIMARY KEY (`post_id`,`related_id`),
                                    KEY `position` (`position`)
);
CREATE TABLE IF NOT EXISTS `related_products` (
                                       `product_id` int(11) NOT NULL,
                                       `related_id` int(11) NOT NULL,
                                       `position` int(11) NOT NULL DEFAULT '0',
                                       PRIMARY KEY (`product_id`,`related_id`),
                                       KEY `position` (`position`)
);

CREATE TABLE IF NOT EXISTS `settings` (
                               `setting_id` int(11) NOT NULL AUTO_INCREMENT,
                               `param` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `value` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                               PRIMARY KEY (`setting_id`),
                               UNIQUE KEY `param` (`param`(100))
);
CREATE TABLE IF NOT EXISTS `settings_lang` (
                                    `param` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
                                    `lang_id` int(11) NOT NULL DEFAULT '0',
                                    `value` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
                                    PRIMARY KEY (`lang_id`,`param`),
                                    KEY `name` (`param`),
                                    KEY `lang_id` (`lang_id`)
);

CREATE TABLE IF NOT EXISTS `users` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `phone` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                            `group_id` int(11) NOT NULL DEFAULT '0',
                            `last_ip` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                            `remind_code` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `remind_expire` timestamp NULL DEFAULT NULL,
                            `preferred_delivery_id` int(11) DEFAULT NULL,
                            `preferred_payment_method_id` int(11) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `email` (`email`(100))
);
CREATE TABLE IF NOT EXISTS `variants` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `product_id` int(11) NOT NULL,
                               `sku` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `weight` decimal(10,2) DEFAULT '0.00',
                               `price` decimal(14,2) NOT NULL DEFAULT '0.00',
                               `compare_price` decimal(14,2) DEFAULT NULL,
                               `stock` mediumint(9) DEFAULT NULL,
                               `position` int(11) NOT NULL DEFAULT '0',
                               `external_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `currency_id` int(11) NOT NULL DEFAULT '0',
                               `units` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
                               `volume` decimal(10,5) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `product_id` (`product_id`),
                               KEY `price` (`price`),
                               KEY `stock` (`stock`),
                               KEY `position` (`position`),
                               KEY `external_id` (`external_id`),
                               KEY `sku` (`sku`(100))
);

UPDATE categories SET parent_id = NULL WHERE parent_id = 0;

-- Таблица фильтров (например: Цвет, Объем, Производитель)
CREATE TABLE IF NOT EXISTS filter_options (
                                              id INT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL,
                                              category_id INT NOT NULL,
                                              is_main BOOLEAN NOT NULL DEFAULT FALSE,
                                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                              FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);

-- Таблица значений фильтров (например: Красный, Синий)
CREATE TABLE IF NOT EXISTS filter_values (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             option_id INT NOT NULL,
                                             value VARCHAR(255) NOT NULL,
                                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                             FOREIGN KEY (option_id) REFERENCES filter_options(id) ON DELETE CASCADE
);

-- Таблица связей товара с фильтрами
CREATE TABLE IF NOT EXISTS product_filter_values (
                                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                                     product_id INT NOT NULL,
                                                     option_id INT NOT NULL,
                                                     value_id INT NOT NULL,

                                                     FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
                                                     FOREIGN KEY (option_id) REFERENCES filter_options(id) ON DELETE CASCADE,
                                                     FOREIGN KEY (value_id) REFERENCES filter_values(id) ON DELETE CASCADE
);
