INSERT INTO  tb_perfil (id, descricao) VALUES (1, 'ADMIN');
INSERT INTO  tb_perfil (id, descricao) VALUES (2, 'CLIENTE');
INSERT INTO  tb_perfil (id, descricao) VALUES (3, 'TRABALHADOR');
INSERT INTO  tb_usuario (id, email, senha, nome) VALUES (91120, 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Ana');
INSERT INTO  tb_usuario (id, email, senha, nome) VALUES (91121, 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Bob');
INSERT INTO  tb_usuario (id, email, senha, nome) VALUES (91122, 'ranyell@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Ranyell');
INSERT INTO  tb_cliente (cnpj, id) VALUES ('123456', 91120);
INSERT INTO  tb_trabalhador (cpf, id) VALUES ('123456', 91121);
INSERT INTO  tb_usuario_perfil (usuario_id, perfil_id) VALUES (91120, 2);
INSERT INTO  tb_usuario_perfil (usuario_id, perfil_id) VALUES (91121, 3);
INSERT INTO  tb_usuario_perfil (usuario_id, perfil_id) VALUES (91122, 1);
INSERT INTO  tb_categoria ( nome, descricao) VALUES ( 'Dev. Java', 'Programa e desenvolve, implanta sistemas em linguagem Java');
INSERT INTO  tb_categoria ( nome, descricao) VALUES ( 'Dev. Python', 'Programa e desenvolve, implanta sistemas em linguagem Python');
INSERT INTO  tb_categoria ( nome, descricao) VALUES ( 'Dev. PHP', 'Programa, desenvolve e implanta sistemas em linguagem PHP');
INSERT INTO  tb_categoria ( nome, descricao) VALUES ( 'Dev. Java Script', 'Programa, desenvolve e implanta sistemas em linguagem Java Script');
INSERT INTO  tb_categoria ( nome, descricao) VALUES ( 'Dev. Back-end', 'Programa, desenvolve e implanta sistemas Back-end');
INSERT INTO  tb_categoria ( nome, descricao) VALUES ( 'Dev. Front-end', 'Programa, desenvolve e implanta sistemas Front-end');
INSERT INTO  tb_trabalhador_categoria ( trabalhador_id, categoria_id ) VALUES ( 91121, 1 );
INSERT INTO  tb_trabalhador_categoria ( trabalhador_id, categoria_id ) VALUES ( 91121, 2 );
INSERT INTO  tb_oferta (ativa, descricao, preco, sub_titulo, titulo, cliente_id) VALUES (true, 'Desenvolvedor Full Stack', 2900.10, 'Full Stack', 'Desenvolvedor Full Stack', 91120);
INSERT INTO  tb_oferta (ativa, descricao, preco, sub_titulo, titulo, cliente_id) VALUES (true, 'Desenvolvedor Back end', 2800.15, 'Back end', 'Desenvolvedor Back end', 91120);
INSERT INTO  tb_oferta (ativa, descricao, preco, sub_titulo, titulo, cliente_id) VALUES (true, 'Desenvolvedor Front end', 1900.95, 'Front end', 'Desenvolvedor Front end', 91120);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (1, 1);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (1, 2);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (1, 3);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (2, 1);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (2, 2);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (2, 3);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (3, 1);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (3, 2);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (3, 3);


