-- 创建电商数据库
CREATE DATABASE IF NOT EXISTS `mall`;

USE `mall`;

-- 创建用户表
CREATE TABLE IF NOT EXISTS `users` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `name`      varchar(20)         NOT NULL ,
    `password`  varchar(20)         NOT NULL ,
    `phone`     varchar(20)         NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

-- 收货地址表
CREATE TABLE IF NOT EXISTS `addresses` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `uid`       int(10)             NOT NULL ,
    `phone`     varchar(20)         NOT NULL ,
    `name`      varchar(20)         NOT NULL ,
    `province`  varchar(20)         NOT NULL ,
    `city`      varchar(20)         NOT NULL ,
    `street`    varchar(20)         NOT NULL ,
    `detail`    varchar(200)        NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

-- 支付信息表
CREATE TABLE IF NOT EXISTS `payments` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `oid`       int(10)             NOT NULL ,
    `uid`       int(10)             NOT NULL ,
    `method`    varchar(20)         NOT NULL ,
    `amount`    int(20)             NOT NULL ,
    `status`    int(1)              NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

-- 商品表
CREATE TABLE IF NOT EXISTS `goods` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `name`      varchar(50)         NOT NULL ,
    `desc`      varchar(1024)       NOT NULL ,
    `picture`   varchar(200)        NOT NULL ,
    `price`     int(20)             NOT NULL ,
    `status`    int(1)              NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

-- 库存表
CREATE TABLE IF NOT EXISTS `stores` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `gid`       int(10)             NOT NULL ,
    `amount`    int(20)             NOT NULL ,
    `sold`      int(10)             NOT NULL ,
    `update`    DATETIME            NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

-- 物流信息表
CREATE TABLE IF NOT EXISTS `logistics` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `oid`       int(10)             NOT NULL ,
    `aid`       int(10)             NOT NULL ,
    `status`    int(1)              NOT NULL ,
    `update`    DATETIME            NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

-- 订单表
CREATE TABLE IF NOT EXISTS `orders` (
    `id`        int(10)             NOT NULL AUTO_INCREMENT,
    `gids`      varchar(200)        NOT NULL ,
    `create`    DATETIME            NOT NULL ,
    `amount`    int(20)             NOT NULL ,
    `status`    int(1)              NOT NULL ,
    `pid`       int(10)             NOT NULL ,
    `lid`       int(10)             NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;
