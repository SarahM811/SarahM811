-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`RoomType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RoomType` (
  `RoomTypeId` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(45) NULL,
  `OccupancyLimit` INT NULL,
  PRIMARY KEY (`RoomTypeId`),
  UNIQUE INDEX `RoomTypeId_UNIQUE` (`RoomTypeId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Room` (
  `RoomId` INT NOT NULL AUTO_INCREMENT,
  `RoomTypeId` INT NOT NULL,
  `FloorNum` INT NOT NULL,
  PRIMARY KEY (`RoomId`),
  INDEX `RoomTypeId_idx` (`RoomTypeId` ASC) VISIBLE,
  UNIQUE INDEX `RoomId_UNIQUE` (`RoomId` ASC) VISIBLE,
  CONSTRAINT `RoomTypeId`
    FOREIGN KEY (`RoomTypeId`)
    REFERENCES `mydb`.`RoomType` (`RoomTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RatePeriod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RatePeriod` (
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `RatePeriodId` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`RatePeriodId`),
  UNIQUE INDEX `RatePeriodId_UNIQUE` (`RatePeriodId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Promotion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Promotion` (
  `PromotionId` INT NOT NULL AUTO_INCREMENT,
  `DollarDiscount` DECIMAL(10,2) NULL,
  `PercentDiscount` DECIMAL(10,2) NULL,
  `StartDate` DATE NOT NULL,
  `EndDate` DATE NOT NULL,
  PRIMARY KEY (`PromotionId`),
  UNIQUE INDEX `PromotionId_UNIQUE` (`PromotionId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `CustomerId` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerId`),
  UNIQUE INDEX `CustomerId_UNIQUE` (`CustomerId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Reservation` (
  `ReservationId` INT NOT NULL AUTO_INCREMENT,
  `PromotionId` INT NULL,
  `CustomerId` INT NOT NULL,
  `CheckInDate` DATE NOT NULL,
  `CheckOutDate` DATE NOT NULL,
  PRIMARY KEY (`ReservationId`),
  INDEX `PromotionId_idx` (`PromotionId` ASC) VISIBLE,
  INDEX `CustomerId_idx` (`CustomerId` ASC) VISIBLE,
  UNIQUE INDEX `ReservationId_UNIQUE` (`ReservationId` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_PromotionId`
    FOREIGN KEY (`PromotionId`)
    REFERENCES `mydb`.`Promotion` (`PromotionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_CustomerId`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `mydb`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RoomRate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RoomRate` (
  `RoomRateId` INT NOT NULL AUTO_INCREMENT,
  `RoomTypeId` INT NOT NULL,
  `Price` DECIMAL NULL,
  `RatePeriodId` INT NOT NULL,
  PRIMARY KEY (`RoomRateId`),
  INDEX `RoomTypeId_idx` (`RoomTypeId` ASC) VISIBLE,
  INDEX `RatePeriodId_idx` (`RatePeriodId` ASC) VISIBLE,
  UNIQUE INDEX `RoomRateId_UNIQUE` (`RoomRateId` ASC) VISIBLE,
  CONSTRAINT `RoomTypeId_RoomRate`
    FOREIGN KEY (`RoomTypeId`)
    REFERENCES `mydb`.`RoomType` (`RoomTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RoomRate_RatePeriodId`
    FOREIGN KEY (`RatePeriodId`)
    REFERENCES `mydb`.`RatePeriod` (`RatePeriodId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AddOn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AddOn` (
  `AddOnId` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(45) NULL,
  `Price` DECIMAL(10,2) NOT NULL,
  `StartDate` DATE NOT NULL,
  `EndDate` DATE NOT NULL,
  PRIMARY KEY (`AddOnId`),
  UNIQUE INDEX `AddOnId_UNIQUE` (`AddOnId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Amenity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Amenity` (
  `AmenityId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AmenityId`),
  UNIQUE INDEX `AmenityId_UNIQUE` (`AmenityId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ReservationDate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ReservationDate` (
  `Date` DATE NOT NULL,
  `RoomNum` INT NOT NULL,
  `ReservationDateId` INT NOT NULL AUTO_INCREMENT,
  `ReservationId` INT NULL,
  INDEX `RoomNum_idx` (`RoomNum` ASC) VISIBLE,
  PRIMARY KEY (`ReservationDateId`),
 -- UNIQUE INDEX `Date_UNIQUE` (`Date` ASC) VISIBLE,
 -- UNIQUE INDEX `RoomNum_UNIQUE` (`RoomNum` ASC) VISIBLE,
  UNIQUE INDEX `RoomDate_UNIQUE` (`Date` ASC, `RoomNum` ASC) VISIBLE,
  INDEX `ReservationId_idx` (`ReservationId` ASC) VISIBLE,
  UNIQUE INDEX `ReservationDateId_UNIQUE` (`ReservationDateId` ASC) VISIBLE,
  CONSTRAINT `fk_ReservationDate_RoomNum`
    FOREIGN KEY (`RoomNum`)
    REFERENCES `mydb`.`Room` (`RoomId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ReservationDate_ReservationId`
    FOREIGN KEY (`ReservationId`)
    REFERENCES `mydb`.`Reservation` (`ReservationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Guest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Guest` (
  `GuestId` INT NOT NULL AUTO_INCREMENT,
  `ReservationId` INT NOT NULL,
  `FirstName` VARCHAR(45) NULL,
  `Age` INT NULL,
  `LastName` VARCHAR(45) NULL,
  PRIMARY KEY (`GuestId`),
  INDEX `ReservationId_idx` (`ReservationId` ASC) VISIBLE,
  UNIQUE INDEX `GuestId_UNIQUE` (`GuestId` ASC) VISIBLE,
  CONSTRAINT `fk_Guest_ReservationId`
    FOREIGN KEY (`ReservationId`)
    REFERENCES `mydb`.`Reservation` (`ReservationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RoomReservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RoomReservation` (
  `RoomReservationId` INT NOT NULL AUTO_INCREMENT,
  `RoomNum` INT NULL,
  `ReservationId` INT NULL,
  PRIMARY KEY (`RoomReservationId`),
  INDEX `RoomNum_idx` (`RoomNum` ASC) VISIBLE,
  INDEX `RservationId_idx` (`ReservationId` ASC) VISIBLE,
  UNIQUE INDEX `RoomReservationId_UNIQUE` (`RoomReservationId` ASC) VISIBLE,
  CONSTRAINT `fk_RoomReservation_RoomNum`
    FOREIGN KEY (`RoomNum`)
    REFERENCES `mydb`.`Room` (`RoomId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RoomReservation_RservationId`
    FOREIGN KEY (`ReservationId`)
    REFERENCES `mydb`.`Reservation` (`ReservationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RoomAmenity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RoomAmenity` (
  `RoomNum` INT NULL,
  `AmenityId` INT NULL,
  `RoomAmenityId` INT NOT NULL AUTO_INCREMENT,
  INDEX `RoomNum_idx` (`RoomNum` ASC) VISIBLE,
  INDEX `AmenityId_idx` (`AmenityId` ASC) VISIBLE,
  PRIMARY KEY (`RoomAmenityId`),
  UNIQUE INDEX `RoomAmenityId_UNIQUE` (`RoomAmenityId` ASC) VISIBLE,
  CONSTRAINT `fk_RoomAmenity_RoomNum`
    FOREIGN KEY (`RoomNum`)
    REFERENCES `mydb`.`Room` (`RoomId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RoomAmenity_AmenityId`
    FOREIGN KEY (`AmenityId`)
    REFERENCES `mydb`.`Amenity` (`AmenityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Invoice` (
  `InvoiceId` INT NOT NULL AUTO_INCREMENT,
  `ReservationId` INT NOT NULL,
  `InvoiceDate` DATE NOT NULL,
  `InvoiceStatus` VARCHAR(45) NOT NULL,
  `CustomerId` INT NOT NULL,
  `PromotionId` INT NULL,
  PRIMARY KEY (`InvoiceId`),
  UNIQUE INDEX `InvoiceId_UNIQUE` (`InvoiceId` ASC) VISIBLE,
  INDEX `fk_Invoice_reservationId_idx` (`ReservationId` ASC) VISIBLE,
  INDEX `fk_invoice_customerId_idx` (`CustomerId` ASC) VISIBLE,
  INDEX `fk_invoice_promotionID_idx` (`PromotionId` ASC) VISIBLE,
  CONSTRAINT `fk_Invoice_reservationId`
    FOREIGN KEY (`ReservationId`)
    REFERENCES `mydb`.`Reservation` (`ReservationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_customerId`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `mydb`.`Customer` (`CustomerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_promotionID`
    FOREIGN KEY (`PromotionId`)
    REFERENCES `mydb`.`Promotion` (`PromotionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`InvoiceLineItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`InvoiceLineItem` (
  `InvoiceLineItemId` INT NOT NULL AUTO_INCREMENT,
  `InvoiceId` INT NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Price` DECIMAL(10,2) NOT NULL,
  `Quantity` INT NOT NULL,
  `ServiceDate` DATE NOT NULL,
  `ReservationId` INT NOT NULL,
  PRIMARY KEY (`InvoiceLineItemId`),
  UNIQUE INDEX `InvoiceLineItemId_UNIQUE` (`InvoiceLineItemId` ASC) VISIBLE,
  INDEX `fk_invoicelineitem_invoiceId_idx` (`InvoiceId` ASC) VISIBLE,
  INDEX `fk_invoicelineitem_reservationId_idx` (`ReservationId` ASC) VISIBLE,
  CONSTRAINT `fk_invoicelineitem_invoiceId`
    FOREIGN KEY (`InvoiceId`)
    REFERENCES `mydb`.`Invoice` (`InvoiceId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoicelineitem_reservationId`
    FOREIGN KEY (`ReservationId`)
    REFERENCES `mydb`.`Reservation` (`ReservationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `mydb`.`AddOnReservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AddOnReservation` (
  `AddOnReservationId` INT NOT NULL AUTO_INCREMENT,
  `AddOnId` INT NULL,
  `ReservationId` INT NULL,
  PRIMARY KEY (`AddOnReservationId`),
  INDEX `AddOnId_idx` (`AddOnId` ASC) VISIBLE,
  INDEX `ReservationId_idx` (`ReservationId` ASC) VISIBLE,
  UNIQUE INDEX `AddOnReservationId_UNIQUE` (`AddOnReservationId` ASC) VISIBLE,
  CONSTRAINT `fk_AddOnReservation_AddOnId`
    FOREIGN KEY (`AddOnId`)
    REFERENCES `mydb`.`AddOn` (`AddOnId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AddOnReservation_ReservationId`
    FOREIGN KEY (`ReservationId`)
    REFERENCES `mydb`.`Reservation` (`ReservationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Data for table `mydb`.`RoomType`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`RoomType` (`RoomTypeId`, `Type`, `OccupancyLimit`) VALUES (1, 'Single', 1);
INSERT INTO `mydb`.`RoomType` (`RoomTypeId`, `Type`, `OccupancyLimit`) VALUES (2, 'Double', 2);
INSERT INTO `mydb`.`RoomType` (`RoomTypeId`, `Type`, `OccupancyLimit`) VALUES (3, 'Queen', 2);
INSERT INTO `mydb`.`RoomType` (`RoomTypeId`, `Type`, `OccupancyLimit`) VALUES (4, 'King', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Room`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (1, 1, 1);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (2, 1, 1);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (3, 2, 1);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (4, 2, 1);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (5, 3, 2);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (6, 3, 2);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (7, 4, 3);
INSERT INTO `mydb`.`Room` (`RoomId`, `RoomTypeId`, `FloorNum`) VALUES (8, 4, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`RatePeriod`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`RatePeriod` (`startDate`, `endDate`, `RatePeriodId`) VALUES ('2018-01-01', '2018-04-30', 1);
INSERT INTO `mydb`.`RatePeriod` (`startDate`, `endDate`, `RatePeriodId`) VALUES ('2018-05-01', '2018-08-31', 2);
INSERT INTO `mydb`.`RatePeriod` (`startDate`, `endDate`, `RatePeriodId`) VALUES ('2018-09-01', '2018-11-30', 3);
INSERT INTO `mydb`.`RatePeriod` (`startDate`, `endDate`, `RatePeriodId`) VALUES ('2018-12-01', '2018-12-31', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Promotion`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Promotion` (`PromotionId`, `DollarDiscount`, `PercentDiscount`, `StartDate`, `EndDate`) VALUES (1, 20.00, NULL, '2018-01-01', '2018-03-31');
INSERT INTO `mydb`.`Promotion` (`PromotionId`, `DollarDiscount`, `PercentDiscount`, `StartDate`, `EndDate`) VALUES (2, NULL, 10.0, '2018-08-01', '2018-09-01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Customer` (`CustomerId`, `FirstName`, `Phone`, `Email`, `LastName`) VALUES (1, 'Joe', '7030921876', 'joe@gmail.com', 'Clark');
INSERT INTO `mydb`.`Customer` (`CustomerId`, `FirstName`, `Phone`, `Email`, `LastName`) VALUES (2, 'John', '9809283764', 'jd@yahoo.com', 'Doe');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Reservation`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Reservation` (`ReservationId`, `PromotionId`, `CustomerId`, `CheckInDate`, `CheckOutDate`) VALUES (1, 1, 1, '2018-01-01', '2018-01-03');
INSERT INTO `mydb`.`Reservation` (`ReservationId`, `PromotionId`, `CustomerId`, `CheckInDate`, `CheckOutDate`) VALUES (2, 2, 2, '2018-05-11', '2018-05-13');
INSERT INTO `mydb`.`Reservation` (`ReservationId`, `PromotionId`, `CustomerId`, `CheckInDate`, `CheckOutDate`) VALUES (3, null, 2, '2018-11-29', '2018-12-02');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`RoomRate`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`RoomRate` (`RoomRateId`, `RoomTypeId`, `Price`, `RatePeriodId`) VALUES (1, 1, 50.0, 1);
INSERT INTO `mydb`.`RoomRate` (`RoomRateId`, `RoomTypeId`, `Price`, `RatePeriodId`) VALUES (2, 1, 70, 2);
INSERT INTO `mydb`.`RoomRate` (`RoomRateId`, `RoomTypeId`, `Price`, `RatePeriodId`) VALUES (3, 2, 80, 1);
INSERT INTO `mydb`.`RoomRate` (`RoomRateId`, `RoomTypeId`, `Price`, `RatePeriodId`) VALUES (4, 2, 90, 2);
INSERT INTO `mydb`.`RoomRate` (`RoomRateId`, `RoomTypeId`, `Price`, `RatePeriodId`) VALUES (5, 2, 50, 3);
INSERT INTO `mydb`.`RoomRate` (`RoomRateId`, `RoomTypeId`, `Price`, `RatePeriodId`) VALUES (6, 2, 100, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`AddOn`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`AddOn` (`AddOnId`, `Type`,`Price`, `StartDate`, `EndDate`) VALUES (1, 'Room Service', 35.00, '2018-01-01', '2018-04-30');
INSERT INTO `mydb`.`AddOn` (`AddOnId`, `Type`,`Price`, `StartDate`, `EndDate`) VALUES (2, 'Movies', 7.00, '2018-05-01', '2018-08-31');
INSERT INTO `mydb`.`AddOn` (`AddOnId`, `Type`,`Price`, `StartDate`, `EndDate`) VALUES (3, 'Morning Call', 5.00, '2018-09-01', '2018-11-01');
INSERT INTO `mydb`.`AddOn` (`AddOnId`, `Type`,`Price`, `StartDate`, `EndDate`) VALUES (4, 'Bar set', 15.00, '2018-01-01', '2018-04-30');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Amenity`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Amenity` (`AmenityId`, `Name`) VALUES (1, 'Fridge');
INSERT INTO `mydb`.`Amenity` (`AmenityId`, `Name`) VALUES (2, 'Spa Bath');
INSERT INTO `mydb`.`Amenity` (`AmenityId`, `Name`) VALUES (3, 'Tea/Coffeemaker');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`ReservationDate`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-01-01', 1, 1, 1);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-01-02', 1, 2, 1);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-01-03', 1, 3, 1);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-05-11', 1, 4, 2);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-05-12', 1, 5, 2);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-05-13', 1, 6, 2);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-05-11', 3, 7, 2);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-05-12', 3, 8, 2);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-05-13', 3, 9, 2);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-11-29', 3, 10, 3);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-11-30', 3, 11, 3);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-12-01', 3, 12, 3);
INSERT INTO `mydb`.`ReservationDate` (`Date`, `RoomNum`, `ReservationDateId`, `ReservationId`) VALUES ('2018-12-02', 3, 13, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Guest`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Guest` (`GuestId`, `ReservationId`, `FirstName`, `Age`, `LastName`) VALUES (1, 1, 'Jane', 15, 'Doe');
INSERT INTO `mydb`.`Guest` (`GuestId`, `ReservationId`, `FirstName`, `Age`, `LastName`) VALUES (2, 1, 'John', 18, 'May');
INSERT INTO `mydb`.`Guest` (`GuestId`, `ReservationId`, `FirstName`, `Age`, `LastName`) VALUES (3, 2, 'Ezra', 28, 'Miller');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`RoomAmenity`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`RoomAmenity` (`RoomNum`, `AmenityId`, `RoomAmenityId`) VALUES (1, 1, 1);
INSERT INTO `mydb`.`RoomAmenity` (`RoomNum`, `AmenityId`, `RoomAmenityId`) VALUES (1, 2, 2);
INSERT INTO `mydb`.`RoomAmenity` (`RoomNum`, `AmenityId`, `RoomAmenityId`) VALUES (2, 1, 3);
INSERT INTO `mydb`.`RoomAmenity` (`RoomNum`, `AmenityId`, `RoomAmenityId`) VALUES (2, 2, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`AddOnReservation`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`AddOnReservation` (`AddOnReservationId`, `AddOnId`, `ReservationId`) VALUES (1, 1, 1);
INSERT INTO `mydb`.`AddOnReservation` (`AddOnReservationId`, `AddOnId`, `ReservationId`) VALUES (2, 2, 2);
INSERT INTO `mydb`.`AddOnReservation` (`AddOnReservationId`, `AddOnId`, `ReservationId`) VALUES (3, 4, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Invoice`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Invoice` (`InvoiceId`, `ReservationId`, `InvoiceDate`, `InvoiceStatus`,`CustomerId`,`PromotionId`) VALUES (1, 1, '2018-01-03', 'Paid',1,1);
INSERT INTO `mydb`.`Invoice` (`InvoiceId`, `ReservationId`, `InvoiceDate`, `InvoiceStatus`,`CustomerId`,`PromotionId`) VALUES (2, 2, '2018-05-13', 'Pending',2, 2);
INSERT INTO `mydb`.`Invoice` (`InvoiceId`, `ReservationId`, `InvoiceDate`, `InvoiceStatus`,`CustomerId`,`PromotionId`) VALUES (3, 3, '2018-12-02', 'Paid',2, null);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`InvoiceLineItem`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (1, 1, 'Room', 50.00, 3, '2018-01-01',1);
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (2, 1, 'AddOn-Movie', 35.00, 1, '2018-01-01',1);
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (3, 1, 'AddOn- Bar set', 15.00, 1, '2018-01-01',1);
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (4, 2, 'Room', 80.00, 3, '2018-05-13',2);
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (5, 2, 'AddOn- Movie', 7.00, 1, '2018-05-12',2);
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (6, 3, 'Room', 95.00, 2, '2018-11-30',3);
INSERT INTO `mydb`.`InvoiceLineItem` (`InvoiceLineItemId`, `InvoiceId`, `Description`, `Price`, `Quantity`, `ServiceDate`,`ReservationId`) VALUES (7, 3, 'Room', 100.00, 2, '2018-12-02',3);

COMMIT;



--  -----------------------------------
-- Create view for addonTotal by reservation id --> works for all reservations
-- ----------------------------

CREATE OR REPLACE VIEW  AddOnTotal
AS
SELECT
	r.reservationId as ReservationId,
	sum(a.price) as addOnPriceTotal
FROM Reservation r
INNER JOIN AddonReservation as ar ON r.ReservationID = ar.ReservationID
INNER JOIN AddOn as a ON a.AddOnID = ar.AddOnID
GROUP BY r.reservationId;

select *
from ADDONTOTAL;

--  -----------------------------------
-- Create view for room total charge
-- ----------------------------
-- Get sum of all room prices by per room and reservationID
CREATE OR REPLACE VIEW RoomTotal
as
SELECT 
	r.reservationId as reservationId, 
    rd.roomNum as roomNumber,
    rp.rateperiodid as rateperiodId,
    SUM(rr.Price) as RoomTotal, 
    rd.date as Date
FROM Reservation as r
	left JOIN ReservationDate as rd ON rd.ReservationID = r.ReservationID
	left JOIN Room as rm ON rm.RoomId = rd.RoomNum
    inner join roomtype as rt on rm.roomtypeid = rt.roomtypeid
	INNER JOIN RoomRate as rr ON rr.roomtypeid = rt.roomtypeid
	INNER JOIN RatePeriod as rp ON rr.RateperiodId = rp.RateperiodId and rd.date between rp.startdate and rp.enddate     
GROUP BY r.ReservationID, rp.rateperiodid, rd.roomnum;

select *
from roomtotal;

create or replace view RoomCostTotal
as
select
		r.reservationid as reservationId,
		sum(r.roomtotal) as roomtotal
from roomtotal as r
group by r.reservationid;

select *
from roomcosttotal;


-- ------------
-- create View for BillDetails -- WORKS NOW
-- ---------
CREATE OR REPLACE VIEW  BillingDetails
AS
SELECT
	r.reservationid as ReservationId,
    rt.roomtotal as RoomTotal,
    ifnull(aot.addonpricetotal, 0)  as TotalAddOnCharge
FROM Reservation as r
join RoomCostTotal as rt on r.reservationid = rt.reservationid
left join addontotal as aot on r.reservationid = aot.reservationid
order by r.reservationId asc;

select *
from BillingDetails;
-- ---------------------
-- create view for FinalBill
-- --------------------
create or replace view FinalBill
as
select
	bd.reservationid as ReservationId,
    (bd.roomtotal + bd.totaladdoncharge) as TotalPreTax,
    round(((bd.roomtotal + bd.totaladdoncharge) * 0.0625),2) as Taxes,
    round(((bd.roomtotal + bd.totaladdoncharge) * 1.0625), 2) as Total,
    ifnull(If (p.dollardiscount is not null and p.percentdiscount is null
    , round(((bd.roomtotal + bd.totaladdoncharge) * 1.0625) - p.dollardiscount,2), null), 'NA') as TotalCostAfterDollarDiscount,
	ifnull( if (p.percentdiscount is not null and p.dollardiscount is null,
   round( (((bd.roomtotal + bd.totaladdoncharge) * 1.0625)) * (1-(p.percentdiscount/100)),2), 'NA'), null) as TotalAfterPercentDiscount
from billingdetails as bd
left join reservation as r on bd.reservationid = r.reservationid
left join promotion as p on r.promotionid = p.promotionid;

select *
from finalBill;
    

-- breaking down of billing details to revise
select 
	r.reservationid as ReservationId,
    rt.roomtotal as RoomTotal,
    ifnull(aot.addonpricetotal, 0)  as TotalAddOnCharge
FROM Reservation as r
-- join ReservationDate as rd on r.reservationid = rd.reservationid
left join RoomCostTotal as rt on r.reservationid = rt.reservationid
-- join room as rm on rd.roomnum = rm.roomid
-- join roomtype as rmt on rm.roomtypeid = rmt.roomtypeid
-- join roomrate as rr on rr.roomtypeid = rmt.roomtypeid
-- join rateperiod as rp on rr.rateperiodid = rp.rateperiodid and rd.date between rp.startdate and rp.enddate
left join addontotal as aot on r.reservationid = aot.reservationid
-- where rd.date between rp.startdate and rp.enddate
order by r.reservationid;
-- group by, rt.RoomTotal, aot.addonpricetotal;

-- ----------
-- Invoice Line Items --> Billing details breakdown by description with the table --> working
-- --------------------
select 
	invoiceid as invoiceId,
    reservationid as reservationId,
    sum(price * quantity) as invoiceTotal,
    description
from invoicelineitem
group by invoiceid, description;
-- -----------
-- billing details with tax amount tax is 6.25%
-- ---------------
create or replace view invoiceWithTaxes
as
 SELECT
	invoiceid as invoiceId,
    reservationid as reservationId,
    sum(price * quantity) as Cost,
    0.065 * sum(price * quantity) as Taxes,
    sum(price*quantity) + (0.065 * sum(price*quantity)) as total
from invoicelineitem
group by invoiceid;

-- --------------
-- create view for Bill with total --> working, promo code effective
-- --------------------
 CREATE OR REPLACE VIEW Bill
 AS
 SELECT
	it.invoiceid as invoiceId,
    it.reservationid as reservationId,
	it.Cost as Cost,
	round(it.Taxes,2) as Taxes,
   -- (it.Cost + it.Taxes) as totalCost,
    ifnull(i.promotionid, 'NA') as promotionId,
    round(it.total,2) as total,
	ifnull(If (p.dollardiscount is not null and p.percentdiscount is null
    , round(it.Cost + it.Taxes - p.dollardiscount,2), null), 'NA') as TotalCostAfterDollarDiscount,
	ifnull( if (p.percentdiscount is not null and p.dollardiscount is null,
   round( (it.Cost + it.Taxes) * (1-(p.percentdiscount/100)),2), 'NA'), null) as TotalAfterPercentDiscount
from invoiceWithTaxes as it
left join invoice as i on it.invoiceid = i.invoiceid
left join promotion as p on i.promotionid = p.promotionid
group by it.invoiceid, it.reservationid, i.promotionid;


select *
from Bill;