-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fog_projekt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fog_projekt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog_projekt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fog_projekt` ;

-- -----------------------------------------------------
-- Table `fog_projekt`.`custom_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_projekt`.`custom_products` (
  `idcustom_products` INT NOT NULL AUTO_INCREMENT,
  `product_length` INT NOT NULL,
  `product_width` INT NOT NULL,
  `roof_type` VARCHAR(45) NOT NULL,
  `roof_material` VARCHAR(45) NOT NULL,
  `shed_length` INT NULL DEFAULT NULL,
  `shed_width` INT NULL DEFAULT NULL,
  `product_price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idcustom_products`))
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_projekt`.`done_materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_projekt`.`done_materials` (
  `idmaterials` INT NOT NULL AUTO_INCREMENT,
  `material_name` VARCHAR(45) NOT NULL,
  `unit_amount` INT NOT NULL,
  `unit_type` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`idmaterials`),
  UNIQUE INDEX `idmaterials_UNIQUE` (`idmaterials` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_projekt`.`done_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_projekt`.`done_products` (
  `iddone_products` INT NOT NULL AUTO_INCREMENT,
  `product_length` INT NOT NULL,
  `product_width` INT NOT NULL,
  `product_price` INT NOT NULL,
  `product_amount` INT NULL DEFAULT NULL,
  `product_type` VARCHAR(45) NOT NULL DEFAULT 'done',
  `product_title` VARCHAR(65) NOT NULL,
  `product_description` VARCHAR(415) NOT NULL,
  PRIMARY KEY (`iddone_products`),
  UNIQUE INDEX `iddone_products_UNIQUE` (`iddone_products` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_projekt`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_projekt`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  `order_id` INT NOT NULL DEFAULT '0',
  `balance` INT NULL DEFAULT NULL,
  `telephone` INT NULL DEFAULT NULL,
  `zipcode` INT NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `house_number` VARCHAR(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog_projekt`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_projekt`.`orders` (
  `idorders` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `product_type` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `user_orderid` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idorders`),
  UNIQUE INDEX `idorders_UNIQUE` (`idorders` ASC) VISIBLE,
  INDEX `fk_producttypedone_orders_link_idx` (`product_type` ASC) VISIBLE,
  INDEX `fk_orders_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `fog_projekt`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_projekt`.`workable_materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_projekt`.`workable_materials` (
  `idworkable_materials` INT NOT NULL AUTO_INCREMENT,
  `material_name` VARCHAR(45) NOT NULL,
  `material_type` VARCHAR(45) NOT NULL,
  `material_length` INT NOT NULL,
  `material_width` INT NOT NULL,
  `material_height` INT NOT NULL,
  `material_price` INT NOT NULL,
  PRIMARY KEY (`idworkable_materials`),
  UNIQUE INDEX `idworkable_materials_UNIQUE` (`idworkable_materials` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
