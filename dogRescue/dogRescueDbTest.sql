-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dogRescueDb1Test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dogRescueDb1Test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dogRescueDb1Test` DEFAULT CHARACTER SET utf8 ;
USE `dogRescueDb1Test` ;

-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Size`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Size` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idSize_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Role` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `roleType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idRole_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`User` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`User` (
 `id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `roleid` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idUser_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_user_roleid_idx` (`roleid` ASC) VISIBLE,
   CONSTRAINT `fk_user_roleid`
    FOREIGN KEY (`roleid`)
    REFERENCES `dogRescueDb1Test`.`Role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`role_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`role_user` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`role_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `roleid` INT NOT NULL,
  `userid` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_roleuser_roleid_idx` (`roleid` ASC) VISIBLE,
  INDEX `fk_roleuser_userid_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_roleuser_roleid`
    FOREIGN KEY (`roleid`)
    REFERENCES `dogRescueDb1Test`.`Role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roleuser_userid`
    FOREIGN KEY (`userid`)
    REFERENCES `dogRescueDb1Test`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Breed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Breed` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Breed` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `userId` INT NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_breed_userId_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_breed_userId`
    FOREIGN KEY (`userId`)
    REFERENCES `dogRescueDb1Test`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`LifeStage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`LifeStage` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`LifeStage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stage` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idType_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`PaymentType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`PaymentType` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`PaymentType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idPurchaseType_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`State`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`State` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`State` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idState_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Dog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Dog` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Dog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sizeId` INT NOT NULL,
  `breedId` INT NOT NULL,
  `Age` INT NOT NULL,
  `adoptionPrice` DECIMAL NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `lifeStageId` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `trainLevelId` INT NOT NULL,
  `Featured` TINYINT NOT NULL DEFAULT 0,
  `isavailable` TINYINT NOT NULL DEFAULT 1,
  `imagepath` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dog_sizeId_idx` (`sizeId` ASC) VISIBLE,
  INDEX `fk_dog_breedId_idx` (`breedId` ASC) VISIBLE,
  INDEX `fk_dog_lifeStageId_idx` (`lifeStageId` ASC) INVISIBLE,
  INDEX `fk_dog_trainLevelId_idx` (`trainLevelId` ASC) VISIBLE,
  CONSTRAINT `fk_dog_sizeId`
    FOREIGN KEY (`sizeId`)
    REFERENCES `dogRescueDb1Test`.`Size` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dog_breedId`
    FOREIGN KEY (`breedId`)
    REFERENCES `dogRescueDb1Test`.`Breed` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dog_lifeStageId`
    FOREIGN KEY (`lifeStageId`)
    REFERENCES `dogRescueDb1Test`.`LifeStage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dog_trainLevelId`
    FOREIGN KEY (`trainLevelId`)
    REFERENCES `dogRescueDb1Test`.`TrainLevel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Adoption`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Adoption` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Adoption` (
 `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Phone` INT(11) NOT NULL,
  `Street1` VARCHAR(45) NOT NULL,
  `Street2` VARCHAR(45) NULL,
  `City` VARCHAR(20) NOT NULL,
  `Zipcode` INT(5) NOT NULL,
  `purchasePrice` DECIMAL NOT NULL,
  `paymentTypeId` INT NOT NULL,
  `stateId` INT NOT NULL,
  `userId` INT NOT NULL,
  `dogId` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_adoption_paymentTypeId_idx` (`paymentTypeId` ASC) VISIBLE,
  INDEX `fk_adoption_state_idx` (`stateId` ASC) VISIBLE,
  INDEX `fk_adoption_userid_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_adoption_dogid_idx` (`dogId` ASC) VISIBLE,
  CONSTRAINT `fk_adoption_purchaseType`
    FOREIGN KEY (`paymentTypeId`)
    REFERENCES `dogRescueDb1Test`.`PaymentType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adoption_state`
    FOREIGN KEY (`stateId`)
    REFERENCES `dogRescueDb1Test`.`State` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adoption_userid`
    FOREIGN KEY (`userId`)
    REFERENCES `dogRescueDb1Test`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adoption_dogid`
    FOREIGN KEY (`dogId`)
    REFERENCES `dogRescueDb1Test`.`Dog` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;





-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`TrainLevel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`TrainLevel` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`TrainLevel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Level` VARCHAR(45) NOT NULL,
  `userId` INT NOT NULL,
   `date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idTrainLevel_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_TrainLevel_userId_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_TrainLevel_userId`
    FOREIGN KEY (`userId`)
    REFERENCES `dogRescueDb1Test`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Special`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Special` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Special` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dogRescueDb1Test`.`Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dogRescueDb1Test`.`Contact` ;

CREATE TABLE IF NOT EXISTS `dogRescueDb1Test`.`Contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Phone` INT NOT NULL,
  `message` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

alter table `dogRescueDb1Test`.`Contact`
add dogname VARCHAR(45) NULL;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`Size`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`Size` (`id`, `type`) VALUES (1, 'small');
INSERT INTO `dogRescueDb1Test`.`Size` (`id`, `type`) VALUES (2, 'medium');
INSERT INTO `dogRescueDb1Test`.`Size` (`id`, `type`) VALUES (3, 'large');
INSERT INTO `dogRescueDb1Test`.`Size` (`id`, `type`) VALUES (4, 'x-large');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`Role`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`Role` (`id`, `roleType`) VALUES (1, 'admin/adoption coordinator');
INSERT INTO `dogRescueDb1Test`.`Role` (`id`, `roleType`) VALUES (2, 'adoption coordinator');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`User` (`id`, `FirstName`, `LastName`, `Email`, `active`, `roleid`,`password`) VALUES (1, 'John', 'Smith', 'js@gmail.com', 1, 1, 'john1');
INSERT INTO `dogRescueDb1Test`.`User` (`id`, `FirstName`, `LastName`, `Email`, `active`, `roleid`, `password`) VALUES (2, 'Jessica', 'Smythe', 'jessica@yahoo.com', 1, 2, 'jessica1');

COMMIT;



-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`Breed`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`Breed` (`id`, `Name`, `useriD`, `date`) VALUES (1, 'Golden Retriever', 1, '01-15-2019');
INSERT INTO `dogRescueDb1Test`.`Breed` (`id`, `Name`, `useriD`, `date`) VALUES (2, 'German Shepherd', 2, '01-15-2019');
INSERT INTO `dogRescueDb1Test`.`Breed` (`id`, `Name`, `useriD`, `date`) VALUES (3, 'Chow Chow', 1, '01-15-2019');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`LifeStage`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`LifeStage` (`id`, `stage`) VALUES (1, 'puppy');
INSERT INTO `dogRescueDb1Test`.`LifeStage` (`id`, `stage`) VALUES (2, 'young adult/teen');
INSERT INTO `dogRescueDb1Test`.`LifeStage` (`id`, `stage`) VALUES (3, 'adult');
INSERT INTO `dogRescueDb1Test`.`LifeStage` (`id`, `stage`) VALUES (4, 'senior');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`PaymentType`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`PaymentType` (`id`, `Type`) VALUES (1, 'Credit Card');
INSERT INTO `dogRescueDb1Test`.`PaymentType` (`id`, `Type`) VALUES (2, 'Cash');
INSERT INTO `dogRescueDb1Test`.`PaymentType` (`id`, `Type`) VALUES (3, 'Personal Check');
INSERT INTO `dogRescueDb1Test`.`PaymentType` (`id`, `Type`) VALUES (4, 'Money Order');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`State`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (1, 'AL');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (2, 'AK');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (3, 'AZ');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (4, 'AR');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (5, 'CA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (6, 'CO');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (7, 'CT');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (8, 'DE');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (9, 'FL');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (10, 'GA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (11, 'HI');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (12, 'ID');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (13, 'IL');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (14, 'IN');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (15, 'IA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (16, 'KS');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (17, 'KY');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (18, 'LA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (19, 'ME');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (20, 'MD');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (21, 'MA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (22, 'MI');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (23, 'MN');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (24, 'MS');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (25, 'MO');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (26, 'MT');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (27, 'NE');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (28, 'NV');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (29, 'NH');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (30, 'NJ');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (31, 'NM');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (32, 'NY');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (33, 'NC');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (34, 'ND');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (35, 'OH');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (36, 'OK');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (37, 'OR');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (38, 'PA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (39, 'RI');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (40, 'SC');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (41, 'SD');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (42, 'TN');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (43, 'TX');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (44, 'UT');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (45, 'VT');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (46, 'VA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (47, 'WA');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (48, 'WV');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (49, 'WI');
INSERT INTO `dogRescueDb1Test`.`State` (`id`, `Name`) VALUES (50, 'WY');

COMMIT;






-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`TrainLevel`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`TrainLevel` (`id`, `Level`, `userId`,`date`) VALUES (1, 'Potty Trained', 2, '01-15-2019');
INSERT INTO `dogRescueDb1Test`.`TrainLevel` (`id`, `Level`, `userId`, `date`) VALUES (2, 'House Trained', 2, '01-15-2019');
INSERT INTO `dogRescueDb1Test`.`TrainLevel` (`id`, `Level`, `userId`, `date`) VALUES (3, 'Obedience Trained', 2, '01-15-2019');

COMMIT;


-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`Dog`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`Dog` (`id`, `sizeId`, `breedId`, `Age`, `adoptionPrice`, `Description`, `isavailable`, `lifeStageId`, `Name`, `trainLevelId`, `Featured`, `imagepath`) VALUES (1, 1, 1, 3, 200.00, 'Super cute', 0, 1, 'Goldie', 2, 1, NULL);
INSERT INTO `dogRescueDb1Test`.`Dog` (`id`, `sizeId`, `breedId`, `Age`, `adoptionPrice`, `Description`, `isavailable`, `lifeStageId`, `Name`, `trainLevelId`, `Featured`, `imagepath`) VALUES (2, 1, 2, 1, 300.00, 'Protective', DEFAULT, 2, 'Bob', 3, DEFAULT, NULL);
INSERT INTO `dogRescueDb1Test`.`Dog` (`id`, `sizeId`, `breedId`, `Age`, `adoptionPrice`, `Description`, `isavailable`, `lifeStageId`, `Name`, `trainLevelId`, `Featured`, `imagepath`) VALUES (3, 2, 3, 1, 350.00, 'Rare breed', DEFAULT, 2, 'Ichi', 2, DEFAULT, NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`role_user`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`role_user` (`id`, `roleid`, `userid`) VALUES (1, 1, 1);
INSERT INTO `dogRescueDb1Test`.`role_user` (`id`, `roleid`, `userid`) VALUES (2, 2, 2);
INSERT INTO `dogRescueDb1Test`.`role_user` (`id`, `roleid`, `userid`) VALUES (3, 2, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`Special`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`Special` (`id`, `Title`, `Description`) VALUES (1, 'Christmas Special', 'Looking for a new family member?');
INSERT INTO `dogRescueDb1Test`.`Special` (`id`, `Title`, `Description`) VALUES (2, 'Special2', 'another special');

COMMIT;

select *
from dog as d
inner join breed as b on d.breedid = b.id
where (d.name like '%bob%') or (b.name like '%german%');

select *
from breed;

select *
from adoption 
WHERE STR_TO_DATE(`adoption`.`date`, '%m-%d-%Y') BETWEEN STR_TO_DATE('01-01-2018', '%m-%d-%Y') AND STR_TO_DATE('01-31-2018', '%m-%d-%Y');

select 
	u.firstname as firstname,
    count(a.id) as numberOfAdoption
from adoption as a
inner join user as u on a.userid = u.id
group by u.id;

select *
from adoption 
WHERE date BETWEEN '2018-01-01' and '2019-01-31';

alter table contact
modify column phone VARCHAR(45) NOT NULL;

alter table dog
modify column imagepath CHAR null;

USE `dogRescueDb1Test`;
select*
from dog;

alter table adoption
modify column phone VARCHAR(200) NOT NULL;

-- -----------------------------------------------------
-- Data for table `dogRescueDb1Test`.`Adoption`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogRescueDb1Test`;
INSERT INTO `dogRescueDb1Test`.`Adoption` (`id`, `Name`, `Email`, `Phone`, `Street1`, `Street2`, `City`, `Zipcode`, `purchasePrice`, `paymentTypeId`, `stateId`, `userId`, `dogId`, `date`) VALUES (1, 'Bob Burgers', 'bburger@gmail.com', '2945768', '123 N Davidson', NULL, 'Charlotte', 28205, 350.00, 2, 1, 1, 1, '2018-01-01');

COMMIT;