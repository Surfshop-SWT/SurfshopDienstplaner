# Wichtig

### Für erstellen der Datenbank in MYSQL

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema surfshop2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema surfshop2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `surfshop2` DEFAULT CHARACTER SET utf8 ;
USE `surfshop2` ;

-- -----------------------------------------------------
-- Table `surfshop2`.`benutzer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `surfshop2`.`benutzer` ;

CREATE TABLE IF NOT EXISTS `surfshop2`.`benutzer` (
  `bid` INT NOT NULL AUTO_INCREMENT,
  `vorname` VARCHAR(45) NULL DEFAULT NULL,
  `nachname` VARCHAR(45) NULL DEFAULT NULL,
  `emailadresse` VARCHAR(45) NULL DEFAULT NULL,
  `telefonnummer` VARCHAR(45) NULL DEFAULT NULL,
  `urlaubstage` INT NULL DEFAULT NULL,
  `benutzername` VARCHAR(45) NULL DEFAULT NULL,
  `passwort` VARCHAR(45) NULL DEFAULT NULL,
  `arbeitszeit` VARCHAR(45) NULL DEFAULT NULL,
  `chef` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`bid`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `surfshop2`.`tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `surfshop2`.`tag` ;

CREATE TABLE IF NOT EXISTS `surfshop2`.`tag` (
  `tid` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NULL DEFAULT NULL,
  `tagart` VARCHAR(45) NULL DEFAULT NULL,
  `benutzer_bid` INT NOT NULL,
  PRIMARY KEY (`tid`),
  INDEX `fk_tag_benutzer_idx` (`benutzer_bid` ASC) VISIBLE,
  CONSTRAINT `fk_tag_benutzer`
    FOREIGN KEY (`benutzer_bid`)
    REFERENCES `surfshop2`.`benutzer` (`bid`))
ENGINE = InnoDB
AUTO_INCREMENT = 1461
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `surfshop2`.`kommentar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `surfshop2`.`kommentar` ;

CREATE TABLE IF NOT EXISTS `surfshop2`.`kommentar` (
  `kid` INT NOT NULL AUTO_INCREMENT,
  `inhalt` VARCHAR(300) NULL DEFAULT NULL,
  `tag_tid` INT NOT NULL,
  PRIMARY KEY (`kid`),
  INDEX `fk_kommentar_tag1_idx` (`tag_tid` ASC) VISIBLE,
  CONSTRAINT `fk_kommentar_tag1`
    FOREIGN KEY (`tag_tid`)
    REFERENCES `surfshop2`.`tag` (`tid`))
ENGINE = InnoDB
AUTO_INCREMENT = 33
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


# Information
## Login-Daten

Benutername: root
Passwort: root

Mit diesem User können neue Benutzer angelegt werden wenn die Datenbank initial leer ist. Diesem User ist es nicht
möglich einen Kommentar zu setzen.