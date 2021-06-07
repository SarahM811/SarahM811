-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema GuessNumberTestDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema GuessNumberTestDB
-- -----------------------------------------------------
DROP DATABASE IF EXISTS GuessNumberTestDB;
CREATE SCHEMA IF NOT EXISTS `GuessNumberTestDB` DEFAULT CHARACTER SET utf8 ;
USE `GuessNumberTestDB` ;

-- -----------------------------------------------------
-- Table `GuessNumberTestDB`.`Game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuessNumberTestDB`.`Game` ;

CREATE TABLE IF NOT EXISTS `GuessNumberTestDB`.`Game` (
  `GameId` INT NOT NULL AUTO_INCREMENT,
  `answer` LONGBLOB NOT NULL,
  `InProgress` TINYINT NOT NULL, 
  PRIMARY KEY (`GameId`),
  UNIQUE INDEX `GameId_UNIQUE` (`GameId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuessNumberTestDB`.`Round`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuessNumberTestDB`.`Round` ;

CREATE TABLE IF NOT EXISTS `GuessNumberTestDB`.`Round` (
  `RoundId` INT NOT NULL AUTO_INCREMENT,
  `guess` LONGBLOB NOT NULL,
  `date` DATETIME NOT NULL,
  `GameId` INT NOT NULL,
  `result` LONGBLOB NOT NULL,
  UNIQUE INDEX `RoundId_UNIQUE` (`RoundId` ASC) VISIBLE,
  PRIMARY KEY (`RoundId`),
  INDEX `fk_Round_gameId_idx` (`GameId` ASC) VISIBLE,
  CONSTRAINT `fk_Round_gameId`
    FOREIGN KEY (`GameId`)
    REFERENCES `GuessNumberTestDB`.`Game` (`GameId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `GuessNumberTestDB`.`Game`
-- -----------------------------------------------------
-- START TRANSACTION;
-- USE `GuessNumberTestDB`;
-- INSERT INTO `GuessNumberTestDB`.`Game` (`GameId`, `answer`, `InProgress`) VALUES (1, '1234', 0);

-- COMMIT;


-- -----------------------------------------------------
-- Data for table `GuessNumberTestDB`.`Round`
-- -----------------------------------------------------
-- START TRANSACTION;
-- USE `GuessNumberTestDB`;
-- INSERT INTO `GuessNumberTestDB`.`Round` (`RoundId`, `guess`, `date`, `GameId`,`result` ) VALUES (1, '1234', '2018-12-21 11:02:03', 1, 'e:4| p:0');

-- COMMIT;

select*
from game;
