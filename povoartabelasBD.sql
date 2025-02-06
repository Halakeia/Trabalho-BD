-- -----------------------------------------------------
-- Inserindo dados na tabela `autor`
-- -----------------------------------------------------
INSERT INTO `autor` (`nomeAutor`, `dataNascimento`) VALUES
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
-- Inserindo dados na tabela `cliente`
-- -----------------------------------------------------
INSERT INTO `cliente` (`nome`, `cpf`, `email`, `dataNascimento`) VALUES
('Ana Souza', '12345678901', 'ana.souza@email.com', '1990-05-20'),
('Carlos Silva', '23456789012', 'carlos.silva@email.com', '1985-02-13'),
('Mariana Lima', '34567890123', 'mariana.lima@email.com', '1993-08-07'),
('Roberto Alves', '45678901234', 'roberto.alves@email.com', '1982-04-25'),
('Juliana Mendes', '56789012345', 'juliana.mendes@email.com', '1997-10-12'),
('Fernando Costa', '67890123456', 'fernando.costa@email.com', '1991-06-30'),
('Beatriz Rocha', '78901234567', 'beatriz.rocha@email.com', '1995-12-01'),
('Eduardo Santos', '89012345678', 'eduardo.santos@email.com', '1988-03-15'),
('Tatiane Oliveira', '90123456789', 'tatiane.oliveira@email.com', '1994-09-23'),
('Ricardo Martins', '01234567890', 'ricardo.martins@email.com', '1980-07-14');

-- -----------------------------------------------------
-- Inserindo dados na tabela `editora`
-- -----------------------------------------------------
INSERT INTO `editora` (`id`, `cnpj`, `nome`) VALUES
(1, '12345678000190', 'Editora Globo'),
(2, '23456789000120', 'Editora Record'),
(3, '34567890000130', 'Editora Saraiva'),
(4, '45678901000140', 'Editora Atlas'),
(5, '56789012000150', 'Editora Moderna'),
(6, '67890123000160', 'Editora FTD'),
(7, '78901234000170', 'Editora Scipione'),
(8, '89012345000180', 'Editora Companhia das Letras'),
(9, '90123456000190', 'Editora Sextante'),
(10, '01234567000100', 'Editora L&PM');

-- -----------------------------------------------------
-- Inserindo dados na tabela `fornecedor`
-- -----------------------------------------------------
INSERT INTO `fornecedor` (`id`, `razaoSocial`, `nomeFantasia`, `cnpj`) VALUES
(1, 'Fornecedor A S.A.', 'FornA', '01234567000110'),
(2, 'Fornecedor B LTDA', 'FornB', '12345678000120'),
(3, 'Fornecedor C ME', 'FornC', '23456789000130'),
(4, 'Fornecedor D EIRELI', 'FornD', '34567890000140'),
(5, 'Fornecedor E Comércio', 'FornE', '45678901000150'),
(6, 'Fornecedor F Distribuidora', 'FornF', '56789012000160'),
(7, 'Fornecedor G Ltda', 'FornG', '67890123000170'),
(8, 'Fornecedor H S.A.', 'FornH', '78901234000180'),
(9, 'Fornecedor I Importação', 'FornI', '89012345000190'),
(10, 'Fornecedor J Exportação', 'FornJ', '90123456000200');

-- -----------------------------------------------------
-- Inserindo dados na tabela `livro`
-- -----------------------------------------------------
INSERT INTO `livro` (`fornecedor_id`, `editora_id`, `nome`, `quantidade`, `dataCadastro`, `descricao`) VALUES
(1, 1, 'Harry Potter e a Pedra Filosofal', 10, NOW(), 'A história do jovem bruxo Harry Potter'),
(2, 2, 'Game of Thrones', 5, NOW(), 'Primeiro livro da série As Crônicas de Gelo e Fogo'),
(1, 3, 'O Senhor dos Anéis', 7, NOW(), 'A aventura épica de Frodo Bolseiro'),
(3, 1, 'O Hobbit', 8, NOW(), 'A jornada de Bilbo Bolseiro'),
(2, 4, '1984', 12, NOW(), 'Distopia de George Orwell'),
(3, 2, 'O Caçador de Pipas', 6, NOW(), 'História sobre amizade e traição'),
(1, 3, 'O Código Da Vinci', 9, NOW(), 'Suspense sobre mistérios religiosos'),
(2, 1, 'A Menina que Roubava Livros', 15, NOW(), 'A história de uma jovem na Alemanha nazista'),
(3, 4, 'Dom Casmurro', 11, NOW(), 'Romance de Machado de Assis sobre ciúmes e traição'),
(1, 2, 'Harry Potter e a Câmara Secreta', 10, NOW(), 'Segunda aventura do bruxo Harry Potter');

-- -----------------------------------------------------
-- Inserindo dados na tabela `Cargo`
-- -----------------------------------------------------
INSERT INTO `Cargo` (`nomeCargo`, `descricao`) VALUES
('Gerente', 'Responsável pela administração geral da loja'),
('Caixa', 'Atendimento no caixa e controle de pagamentos'),
('Estagiário', 'Auxilia nas funções administrativas'),
('Vendedor', 'Atendimento ao cliente e organização de produtos'),
('Supervisor', 'Supervisiona a equipe de vendas'),
('Auxiliar de Estoque', 'Responsável pela organização do estoque'),
('Recepcionista', 'Recebe e orienta clientes'),
('Marketing', 'Desenvolve campanhas publicitárias'),
('TI', 'Responsável pelos sistemas e suporte técnico'),
('Segurança', 'Zela pela segurança da loja');

-- -----------------------------------------------------
-- Inserindo dados na tabela `funcionario`
-- -----------------------------------------------------
INSERT INTO `funcionario` (`Cargo_id`, `nome`, `salario`, `cpf`) VALUES
(1, 'Pedro Henrique', 3500.00, '56487952354'),
(2, 'Maria Clara', 1500.00, '23456789012'),
(3, 'Lucas Almeida', 1800.00, '98765432100'),
(4, 'Fernanda Lima', 2500.00, '78945612300'),
(5, 'Bruna Silva', 2200.00, '56321478956'),
(6, 'Carlos Souza', 2000.00, '34567890123'),
(7, 'Tatiane Costa', 1300.00, '12457896321'),
(8, 'Ricardo Lima', 2400.00, '32198765432'),
(9, 'Juliana Rocha', 2300.00, '45612378901'),
(10, 'Sérgio Santos', 2100.00, '11223344556');

-- -----------------------------------------------------
-- Inserindo dados na tabela `venda`
-- -----------------------------------------------------
INSERT INTO `venda` (`dataHora`, `cliente_id`, `funcionario_id`) VALUES
(NOW(), 1, 1),
(NOW(), 2, 2),
(NOW(), 3, 3),
(NOW(), 4, 4),
(NOW(), 5, 5),
(NOW(), 6, 6),
(NOW(), 7, 7),
(NOW(), 8, 8),
(NOW(), 9, 9),
(NOW(), 10, 10);

-- -----------------------------------------------------
-- Inserindo dados na tabela `preco_livro`
-- -----------------------------------------------------
INSERT INTO `preco_livro` (`livro_id`, `valor`, `data`) VALUES
(1, 39.90, NOW()),
(2, 49.90, NOW()),
(3, 29.90, NOW()),
(4, 35.90, NOW()),
(5, 19.90, NOW()),
(6, 24.90, NOW()),
(7, 59.90, NOW()),
(8, 39.90, NOW()),
(9, 49.90, NOW()),
(10, 34.90, NOW());

-- -----------------------------------------------------
-- Inserindo dados na tabela `item_venda`
-- -----------------------------------------------------
INSERT INTO `item_venda` (`livro_id`, `venda_id`, `quantidadeItem`) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 2),
(4, 4, 3),
(5, 5, 1),
(6, 6, 2),
(7, 7, 1),
(8, 8, 2),
(9, 9, 1),
(10, 10, 1);

-- -----------------------------------------------------
-- Inserindo dados na tabela `livro_autor`
-- -----------------------------------------------------
INSERT INTO `livro_autor` (`livro_id`, `autor_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- -----------------------------------------------------
-- Inserindo dados na tabela `usuario`
-- -----------------------------------------------------
INSERT INTO `usuario` (`id`, `userName`, `senha`, `funcionario_id`) VALUES
(1, 'admin', 'admin123', 1),
(2, 'johndoe', 'password123', 2),
(3, 'marysue', 'securepass', 3),
(4, 'lucas_almeida', 'mypassword', 4),
(5, 'bruna_silva', 'password2025', 5),
(6, 'carlos_souza', '123456', 6),
(7, 'tatiane_costa', 'mypassword1', 7),
(8, 'ricardo_lima', 'password1234', 8),
(9, 'juliana_rocha', 'juliana2025', 9),
(10, 'sergio_santos', 'sergiopass', 10);

-- -----------------------------------------------------
-- Inserindo dados na tabela `logs`
-- -----------------------------------------------------
INSERT INTO `logs` (`usuario_id`, `tabela`, `acao`, `dadosAntigos`, `dadosNovos`, `dataHora`) VALUES
(1, 'usuario', 'INSERT', '', '{"userName": "admin", "senha": "admin123", "funcionario_id": 1}', NOW()),
(2, 'livro', 'UPDATE', '{"quantidade": 5}', '{"quantidade": 10}', NOW()),
(3, 'livro', 'DELETE', '{"quantidade": 7}', '', NOW()),
(4, 'funcionario', 'INSERT', '', '{"Cargo_id": 4, "nome": "Lucas Almeida", "salario": 1800.00, "cpf": "98765432100"}', NOW()),
(5, 'venda', 'INSERT', '', '{"cliente_id": 5, "funcionario_id": 5}', NOW()),
(6, 'preco_livro', 'UPDATE', '{"valor": 29.90}', '{"valor": 39.90}', NOW()),
(7, 'livro_autor', 'INSERT', '', '{"livro_id": 3, "autor_id": 3}', NOW()),
(8, 'item_venda', 'UPDATE', '{"quantidadeItem": 1}', '{"quantidadeItem": 2}', NOW()),
(9, 'usuario', 'DELETE', '{"userName": "marysue"}', '', NOW()),
(10, 'funcionario', 'UPDATE', '{"salario": 2200.00}', '{"salario": 2400.00}', NOW());
