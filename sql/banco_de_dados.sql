-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bookflow
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bookflow
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookflow` DEFAULT CHARACTER SET utf8mb3 ;
USE `bookflow` ;

-- -----------------------------------------------------
-- Table `bookflow`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(15) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`fornecedor` (
  `fornecedor_id` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(18) NOT NULL,
  `razaoSocial` VARCHAR(100) NOT NULL,
  `nomeFantasia` VARCHAR(100) NOT NULL,
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE,
  PRIMARY KEY (`fornecedor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`editora` (
  `editora_id` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(18) NOT NULL,
  `nome` VARCHAR(45) NULL,
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE,
  PRIMARY KEY (`editora_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookflow`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`livro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` INT NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descricao` TEXT NOT NULL,
  `fornecedor_fornecedor_id` INT NOT NULL,
  `editora_editora_id` INT NOT NULL,
  PRIMARY KEY (`id`, `fornecedor_fornecedor_id`, `editora_editora_id`),
  INDEX `fk_livro_fornecedor1_idx` (`fornecedor_fornecedor_id` ASC) VISIBLE,
  INDEX `fk_livro_editora1_idx` (`editora_editora_id` ASC) VISIBLE,
  CONSTRAINT `fk_livro_fornecedor1`
    FOREIGN KEY (`fornecedor_fornecedor_id`)
    REFERENCES `bookflow`.`fornecedor` (`fornecedor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_editora1`
    FOREIGN KEY (`editora_editora_id`)
    REFERENCES `bookflow`.`editora` (`editora_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`usuario` (
  `id` INT NOT NULL,
  `userName` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` TIMESTAMP NOT NULL,
  `valor` DOUBLE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `cliente_idCliente` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cliente_idCliente`, `usuario_id`),
  INDEX `fk_venda_cliente1_idx` (`cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_venda_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idCliente`)
    REFERENCES `bookflow`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `bookflow`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`item_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`item_venda` (
  `livro_id` INT NOT NULL,
  `venda_id` INT NOT NULL,
  `quantidadeItem` INT NOT NULL,
  `valorItem` DOUBLE NOT NULL,
  INDEX `fk_livro_has_venda_venda1_idx` (`venda_id` ASC) VISIBLE,
  INDEX `fk_livro_has_venda_livro1_idx` (`livro_id` ASC) VISIBLE,
  PRIMARY KEY (`livro_id`, `venda_id`),
  CONSTRAINT `fk_livro_has_venda_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `bookflow`.`livro` (`id`),
  CONSTRAINT `fk_livro_has_venda_venda1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `bookflow`.`venda` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeAutor` VARCHAR(100) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `biografia` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookflow`.`livro_autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`livro_autor` (
  `livro_id` INT NOT NULL,
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`livro_id`, `autor_id`),
  INDEX `fk_livro_has_autor_autor1_idx` (`autor_id` ASC) VISIBLE,
  INDEX `fk_livro_has_autor_livro1_idx` (`livro_id` ASC) VISIBLE,
  CONSTRAINT `fk_livro_has_autor_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `bookflow`.`livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_has_autor_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `bookflow`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`logs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`logs` (
  `idlogs` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `tabela` VARCHAR(50) NOT NULL,
  `acao` ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
  `dadosAntigos` TEXT NULL,
  `dadosNovos` TEXT NULL,
  `dataHora` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idlogs`),
  INDEX `fk_logs_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_logs_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `bookflow`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
