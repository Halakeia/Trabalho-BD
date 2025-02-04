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
-- Table `bookflow`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeAutor` VARCHAR(100) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`editora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(18) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razaoSocial` VARCHAR(100) NOT NULL,
  `nomeFantasia` VARCHAR(100) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`livro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fornecedor_id` INT NOT NULL,
  `editora_id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `quantidade` INT NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL,
  `descricao` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_livro_fornecedor_idx` (`fornecedor_id` ASC) VISIBLE,
  INDEX `fk_livro_editora1_idx` (`editora_id` ASC) VISIBLE,
  CONSTRAINT `fk_livro_editora1`
    FOREIGN KEY (`editora_id`)
    REFERENCES `bookflow`.`editora` (`id`),
  CONSTRAINT `fk_livro_fornecedor`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `bookflow`.`fornecedor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`Cargo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeCargo` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookflow`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Cargo_id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_funcionario_Cargo1_idx` (`Cargo_id` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_Cargo1`
    FOREIGN KEY (`Cargo_id`)
    REFERENCES `bookflow`.`Cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookflow`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataHora` TIMESTAMP NOT NULL,
  `cliente_id` INT NOT NULL,
  `funcionario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_venda_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_venda_funcionario1_idx` (`funcionario_id` ASC) VISIBLE,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bookflow`.`cliente` (`id`),
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `bookflow`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`item_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`item_venda` (
  `item_venda_id` INT NOT NULL AUTO_INCREMENT,
  `livro_id` INT NOT NULL,
  `venda_id` INT NOT NULL,
  `quantidadeItem` INT NOT NULL,
  INDEX `fk_livro_has_venda_venda1_idx` (`venda_id` ASC) VISIBLE,
  INDEX `fk_livro_has_venda_livro1_idx` (`livro_id` ASC) VISIBLE,
  PRIMARY KEY (`item_venda_id`),
  CONSTRAINT `fk_livro_has_venda_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `bookflow`.`livro` (`id`),
  CONSTRAINT `fk_livro_has_venda_venda1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `bookflow`.`venda` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`livro_autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`livro_autor` (
  `livro_autor_id` INT NOT NULL AUTO_INCREMENT,
  `livro_id` INT NOT NULL,
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`livro_autor_id`),
  UNIQUE KEY `unique_livro_autor` (`livro_id`, `autor_id`), -- Restrição única composta
  INDEX `fk_livro_has_autor_autor1_idx` (`autor_id` ASC) VISIBLE,
  INDEX `fk_livro_has_autor_livro1_idx` (`livro_id` ASC) VISIBLE,
  CONSTRAINT `fk_livro_has_autor_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `bookflow`.`autor` (`id`),
  CONSTRAINT `fk_livro_has_autor_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `bookflow`.`livro` (`id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `funcionario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  INDEX `fk_usuario_funcionario1_idx` (`funcionario_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_funcionario1`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `bookflow`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`logs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`logs` (
  `idlogs` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `tabela` VARCHAR(50) NOT NULL,
  `acao` ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
  `dadosAntigos` TEXT NOT NULL,
  `dadosNovos` TEXT NOT NULL,
  `dataHora` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idlogs`),
  INDEX `fk_logs_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_logs_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `bookflow`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookflow`.`preco_livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookflow`.`preco_livro` (
  `idpreço` INT NOT NULL AUTO_INCREMENT,
  `livro_id` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idpreço`),
  INDEX `fk_historico_preco_livro_livro1_idx` (`livro_id` ASC) VISIBLE,
  CONSTRAINT `fk_historico_preco_livro_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `bookflow`.`livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
