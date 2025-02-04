 -- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`autor`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`autor` (`nomeAutor`, `dataNascimento`) VALUES
('J.K. Rowling', '1965-07-31'),
('George R.R. Martin', '1948-09-20'),
('J.R.R. Tolkien', '1892-01-03'),
('Agatha Christie', '1890-09-15'),
('Dan Brown', '1964-06-22'),
('Stephen King', '1947-09-21'),
('Isaac Asimov', '1920-01-02'),
('Arthur C. Clarke', '1917-12-16'),
('H.P. Lovecraft', '1890-08-20'),
('Mark Twain', '1835-11-30');

-- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`cliente`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`cliente` (`nome`, `cpf`, `email`, `dataNascimento`) VALUES
('Ana Souza', '12345678901', 'ana.souza@email.com', '1990-05-20'),
('Carlos Silva', '23456789012', 'carlos.silva@email.com', '1985-02-13'),
('Juliana Lima', '34567890123', 'juliana.lima@email.com', '2000-07-10'),
('Paulo Ferreira', '45678901234', 'paulo.ferreira@email.com', '1993-08-18'),
('Maria Oliveira', '56789012345', 'maria.oliveira@email.com', '1995-04-25'),
('Ricardo Costa', '67890123456', 'ricardo.costa@email.com', '1987-11-30'),
('Fernanda Pereira', '78901234567', 'fernanda.pereira@email.com', '1992-03-09'),
('Roberto Santos', '89012345678', 'roberto.santos@email.com', '1989-09-12'),
('Larissa Almeida', '90123456789', 'larissa.almeida@email.com', '1991-01-16'),
('Gabriel Rocha', '01234567890', 'gabriel.rocha@email.com', '1994-11-21');

-- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`editora`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`editora` (`cnpj`, `nome`) VALUES
('12.345.678/0001-90', 'Editora Globo'),
('23.456.789/0001-20', 'Editora Record'),
('34.567.890/0001-30', 'Editora Companhia das Letras'),
('45.678.901/0001-40', 'Editora Rocco'),
('56.789.012/0001-50', 'Editora Intrínseca'),
('67.890.123/0001-60', 'Editora Saraiva'),
('78.901.234/0001-70', 'Editora Arqueiro'),
('89.012.345/0001-80', 'Editora Planeta'),
('90.123.456/0001-90', 'Editora Sextante'),
('01.234.567/0001-00', 'Editora Pensamento');

 -- Inserindo dados na tabela `bookflow`.`livro`
INSERT INTO `bookflow`.`livro` (`fornecedor_id`, `editora_id`, `nome`, `quantidade`, `dataCadastro`, `descricao`) VALUES
(5, 1, 'Harry Potter e a Pedra Filosofal', 10, NOW(), 'A história do jovem bruxo Harry Potter'),
(6, 2, 'O Game of Thrones', 5, NOW(), 'Primeiro livro da série As Crônicas de Gelo e Fogo'),
(7, 3, 'O Senhor dos Anéis', 8, NOW(), 'Uma jornada épica pela Terra Média'),
(8, 4, 'Assassinato no Expresso do Oriente', 12, NOW(), 'Um clássico do suspense de Agatha Christie'),
(9, 5, 'O Código Da Vinci', 9, NOW(), 'Romance de mistério de Dan Brown'),
(10, 6, 'It: A Coisa', 15, NOW(), 'Horror psicológico escrito por Stephen King'),
(11, 7, 'Fundação', 7, NOW(), 'Primeiro livro da série Fundação de Isaac Asimov'),
(12, 8, '2001: Uma Odisseia no Espaço', 6, NOW(), 'Ficção científica de Arthur C. Clarke'),
(13, 9, 'O Chamado de Cthulhu', 11, NOW(), 'Histórias de terror cósmico de H.P. Lovecraft'),
(14, 10, 'As Aventuras de Tom Sawyer', 13, NOW(), 'Clássico literário de Mark Twain');

 INSERT INTO `bookflow`.`fornecedor` (`razaoSocial`, `nomeFantasia`, `cnpj`) VALUES
('Fornecedor A S.A.', 'FornA', '01234567000110'),
('Fornecedor B LTDA', 'FornB', '12345678000120'),
('Fornecedor C S.A.', 'FornC', '23456789000130'),
('Fornecedor D LTDA', 'FornD', '34567890000140'),
('Fornecedor E S.A.', 'FornE', '45678901000150'),
('Fornecedor F LTDA', 'FornF', '56789012000160'),
('Fornecedor G S.A.', 'FornG', '67890123000170'),
('Fornecedor H LTDA', 'FornH', '78901234000180'),
('Fornecedor I S.A.', 'FornI', '89012345000190'),
('Fornecedor J LTDA', 'FornJ', '90123456000100');
 ---------------------------------
-- Inserindo dados na tabela `bookflow`.`Cargo`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`Cargo` (`nomeCargo`, `descricao`) VALUES
('Gerente', 'Responsável pela administração geral da loja'),
('Caixa', 'Atendimento no caixa e controle de pagamentos'),
('Vendedor', 'Atendimento ao cliente e vendas de livros'),
('Estoque', 'Responsável pelo controle de estoque'),
('Supervisor', 'Supervisão da equipe de vendas'),
('Atendente', 'Atendimento ao cliente'),
('Auxiliar Administrativo', 'Suporte na parte administrativa'),
('Auxiliar de Estoque', 'Auxilia no controle e reposição de produtos'),
('Líder de Vendas', 'Liderança na equipe de vendas'),
('Coordenador', 'Coordenação das atividades operacionais');

-- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`funcionario`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`funcionario` (`Cargo_id`, `nome`, `salario`, `cpf`) VALUES
(1, 'Pedro Henrique', 3500.00, '12345678901'),
(2, 'Maria Clara', 1500.00, '23456789012'),
(3, 'João Vitor', 2000.00, '34567890123'),
(4, 'Amanda Oliveira', 1800.00, '45678901234'),
(5, 'Rafael Costa', 2200.00, '56789012345'),
(6, 'Carla Santos', 1600.00, '67890123456'),
(7, 'Lucas Almeida', 2500.00, '78901234567'),
(8, 'Fernanda Lopes', 1700.00, '89012345678'),
(9, 'Gustavo Pereira', 2400.00, '90123456789'),
(10, 'Tatiane Souza', 1900.00, '01234567890');
 
-- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`venda`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`venda` (`dataHora`, `cliente_id`, `funcionario_id`) VALUES
(NOW(), 13, 1),
(NOW(), 14, 2),
(NOW(), 15, 3),
(NOW(), 16, 4),
(NOW(), 17, 5),
(NOW(), 18, 6),
(NOW(), 19, 7),
(NOW(), 20, 8),
(NOW(), 21, 9),
(NOW(), 22, 10);

 
-- ----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`item_venda`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`item_venda` (`livro_id`, `venda_id`, `quantidadeItem`) VALUES
(31, 11, 2),
(32, 12, 1),
(33, 13, 3),
(34, 14, 1),
(35, 15, 2),
(36, 16, 1),
(37, 17, 4),
(38, 18, 1),
(39, 19, 3),
(40, 20, 2);

-- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`livro_autor`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`livro_autor` (`livro_id`, `autor_id`) VALUES
(31, 1),
(32, 2),
(33, 3),
(34, 4),
(35, 5),
(36, 6),
(37, 7),
(38, 8),
(39, 9),
(40, 10);

-- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`usuario`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`usuario` (`id`, `userName`, `senha`, `funcionario_id`) VALUES
(1, 'admin', 'admin123', 1),
(2, 'johndoe', 'password123', 2),
(3, 'janedoe', 'qwerty123', 3),
(4, 'pedrosouza', '12345qwert', 4),
(5, 'ricardocosta', 'abc123xyz', 5),
(6, 'carlarocha', 'qazwsx123', 6),
(7, 'lucasalmeida', 'plmko987', 7),
(8, 'fernandalopes', '123qwe456', 8),
(9, 'gustavopereira', '7890abcd', 9),
(10, 'tatianesouza', 'password456', 10);
 -- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`logs`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`logs` (`idlogs`, `usuario_id`, `tabela`, `acao`, `dadosAntigos`, `dadosNovos`, `dataHora`) VALUES
(1, 1, 'usuario', 'INSERT', '', '{"userName": "admin", "senha": "admin123", "funcionario_id": 1}', NOW()),
(2, 2, 'livro', 'UPDATE', '{"quantidade": 5}', '{"quantidade": 10}', NOW()),
(3, 3, 'livro', 'DELETE', '{"nome": "O Senhor dos Anéis", "quantidade": 8}', '', NOW()),
(4, 4, 'fornecedor', 'INSERT', '', '{"razaoSocial": "Fornecedor D LTDA", "nomeFantasia": "FornD", "cnpj": "34567890000140"}', NOW()),
(5, 5, 'livro', 'UPDATE', '{"nome": "O Código Da Vinci"}', '{"nome": "O Código Da Vinci", "quantidade": 9}', NOW()),
(6, 6, 'venda', 'INSERT', '', '{"livro_id": 10, "venda_id": 15, "quantidadeItem": 2}', NOW()),
(7, 7, 'livro', 'DELETE', '{"nome": "Assassinato no Expresso do Oriente", "quantidade": 12}', '', NOW()),
(8, 8, 'usuario', 'UPDATE', '{"userName": "johndoe", "senha": "password123"}', '{"userName": "johndoe", "senha": "newpassword123"}', NOW()),
(9, 9, 'livro', 'INSERT', '', '{"nome": "Harry Potter e a Pedra Filosofal", "quantidade": 10}', NOW()),
(10, 10, 'fornecedor', 'UPDATE', '{"cnpj": "23456789000130"}', '{"cnpj": "23456789000131"}', NOW());
 -- -----------------------------------------------------
-- Inserindo dados na tabela `bookflow`.`preco_livro`
-- -----------------------------------------------------
INSERT INTO `bookflow`.`preco_livro` (`idpreço`, `livro_id`, `valor`, `data`) VALUES
(1, 31, 39.90, NOW()),
(2, 32, 49.90, NOW()),
(3, 33, 79.90, NOW()),
(4, 34, 29.90, NOW()),
(5, 35, 59.90, NOW()),
(6, 36, 39.90, NOW()),
(7, 37, 69.90, NOW()),
(8, 38, 89.90, NOW()),
(9, 39, 34.90, NOW()),
(10, 40, 19.90, NOW());