-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema GuessNumberDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema GuessNumberDB
-- -----------------------------------------------------
DROP DATABASE IF EXISTS GuessNumberDB;
CREATE SCHEMA IF NOT EXISTS `GuessNumberDB` DEFAULT CHARACTER SET utf8 ;
USE `GuessNumberDB` ;

-- -----------------------------------------------------
-- Table `GuessNumberDB`.`Game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuessNumberDB`.`Game` ;

CREATE TABLE IF NOT EXISTS `GuessNumberDB`.`Game` (
  `GameId` INT NOT NULL AUTO_INCREMENT,
  `answer` LONGBLOB NOT NULL,
  `InProgress` TINYINT NOT NULL, 
  PRIMARY KEY (`GameId`),
  UNIQUE INDEX `GameId_UNIQUE` (`GameId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuessNumberDB`.`Round`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuessNumberDB`.`Round` ;

CREATE TABLE IF NOT EXISTS `GuessNumberDB`.`Round` (
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
    REFERENCES `GuessNumberDB`.`Game` (`GameId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `GuessNumberDB`.`Game`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuessNumberDB`;
INSERT INTO `GuessNumberDB`.`Game` (`GameId`, `answer`, `InProgress`) VALUES (1, '1234', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuessNumberDB`.`Round`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuessNumberDB`;
INSERT INTO `GuessNumberDB`.`Round` (`RoundId`, `guess`, `date`, `GameId`,`result` ) VALUES (1, '1234', '2018-12-21 11:02:03', 1, 'e:4| p:0');

COMMIT;

select *
from game;


