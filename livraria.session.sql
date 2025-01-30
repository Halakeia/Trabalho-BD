ALTER TABLE cliente DROP dataNascimento;

ALTER TABLE cliente ADD COLUMN dataNascimento DATE; 

ALTER TABLE livro DROP dataCadastro;
ALTER TABLE livro ADD COLUMN dataCadastro DATE;

DESCRIBE fornecedor;

ALTER TABLE usuario MODIFY COLUMN id INT AUTO_INCREMENT; 

DESCRIBE usuario;

SELECT *FROM usuario;


