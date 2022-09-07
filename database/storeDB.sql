-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema store2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema store2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `store2` DEFAULT CHARACTER SET utf8 ;
USE `store2` ;

-- -----------------------------------------------------
-- Table `store2`.`tipoproducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store2`.`tipoproducto` (
  `idtipoproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipoproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store2`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store2`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombreproducto` VARCHAR(45) NOT NULL,
  `valorcompra` DOUBLE NOT NULL,
  `valorventa` DOUBLE NOT NULL,
  `cantidad` DOUBLE NOT NULL,
  `tipoproducto_idtipoproducto` INT NOT NULL,
  PRIMARY KEY (`idproducto`),
  INDEX `fk_producto_tipoproducto_idx` (`tipoproducto_idtipoproducto` ASC) VISIBLE,
  CONSTRAINT `fk_producto_tipoproducto`
    FOREIGN KEY (`tipoproducto_idtipoproducto`)
    REFERENCES `store2`.`tipoproducto` (`idtipoproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store2`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store2`.`usuarios` (
  `idusuarios` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store2`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store2`.`factura` (
  `idfactura` INT NOT NULL AUTO_INCREMENT,
  `fecha` VARCHAR(45) NOT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`idfactura`),
  INDEX `fk_factura_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  CONSTRAINT `fk_factura_usuarios1`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `store2`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store2`.`productosfactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store2`.`productosfactura` (
  `idproductosfactura` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `idproducto` INT NOT NULL,
  `idfactura` INT NOT NULL,
  PRIMARY KEY (`idproductosfactura`),
  INDEX `fk_productosfactura_producto1_idx` (`idproducto` ASC) VISIBLE,
  INDEX `fk_productosfactura_factura1_idx` (`idfactura` ASC) VISIBLE,
  CONSTRAINT `fk_productosfactura_producto1`
    FOREIGN KEY (`idproducto`)
    REFERENCES `store2`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productosfactura_factura1`
    FOREIGN KEY (`idfactura`)
    REFERENCES `store2`.`factura` (`idfactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
