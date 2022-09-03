INSERT INTO  tb_perfil (id, descricao) VALUES (1, 'ADMIN');
INSERT INTO  tb_perfil (id, descricao) VALUES (2, 'CLIENTE');
INSERT INTO  tb_perfil (id, descricao) VALUES (3, 'TRABALHADOR');
INSERT INTO  tb_endereco (cep, complemento, bairro, localidade, uf) VALUES ('7236545', 'Lote 01', 'Riacho Fundo II', 'Brasília', 'DF');
INSERT INTO  tb_endereco (cep, complemento, bairro, localidade, uf) VALUES ('7894562', 'Lote 07', 'Samambaia', 'Brasília', 'DF');
INSERT INTO  tb_endereco (cep, complemento, bairro, localidade, uf) VALUES ('1234567', '', 'Asa Sul', 'Brasília', 'DF');
INSERT INTO  tb_endereco (cep, complemento, bairro, localidade, uf) VALUES ('7236545', 'Lote 01', 'Riacho Fundo II', 'Brasília', 'DF');
INSERT INTO  tb_endereco (cep, complemento, bairro, localidade, uf) VALUES ('7894562', 'Lote 07', 'Samambaia', 'Brasília', 'DF');
INSERT INTO  tb_endereco (cep, complemento, bairro, localidade, uf) VALUES ('1234567', '', 'Asa Sul', 'Brasília', 'DF');
INSERT INTO  tb_usuario (id, email, senha, nome, endereco_id) VALUES (91120, 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Ana', 1);
INSERT INTO  tb_usuario (id, email, senha, nome, descricao, telefone, endereco_id) VALUES (91121, 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Bob', 'Seja vindo ao meu perfil! Desenvolvo projetos Front-End como páginas web, sistema de interface com usuário, com HTML, CSS, Javascript e framework como Vue.js', '(61) 94444-4444', 2);
INSERT INTO  tb_usuario (id, email, senha, nome, endereco_id) VALUES (91122, 'ranyell@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Ranyell', 3);
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
INSERT INTO  tb_oferta (endereco_id, ativa, descricao, preco, sub_titulo, titulo, cliente_id) VALUES (4, true, '<p><span>Software para Controle de horas de Projetos e Obras</span><br /><span>O Projeto consiste em um desenvolvimento de uma forma de controle de horas trabalhadas com controle por banco de dados, onde nosso colaborador ir&aacute; apontar as horas di&aacute;rias trabalhadas e em qual projeto.</span><br /><span>Neste banco de dados, poderemos ter op&ccedil;oes:</span><br /><span>1) Gerar relat&oacute;rios totalizando horas por projetos, ou por periodo etc...</span><br /><span>2) Cadastrar projetos para que o colaborador possa lan&ccedil;ar;</span><br /><span>3) Bloqueios para que um colaborador n&atilde;o possa ver ou alterar horas de outro colaborador, ou seja, ter senha de acesso</span><br /><span>Importante prever interface que que seja interligado no futuro ao nosso site, para que o nosso colaborador possa acessar online.</span></p>', 2900.10, 'Full Stack', 'Desenvolvedor Full Stack', 91120);
INSERT INTO  tb_oferta (endereco_id, ativa, descricao, preco, sub_titulo, titulo, cliente_id) VALUES (5, true, '<p><span>Estamos buscando profissional para atuar como Desenvolvedor FullStack, sendo sua principal responsabilidade o desenvolvimento front-end e back-end do sistema.</span><br /><br /><span>Atuar&aacute; alocado em cliente de Blumenau/SC por per&iacute;odo de 3 meses, podendo se estender conforme a necessidade.</span><br /><span>O hor&aacute;rio de trabalho ser&aacute; comercial e o contratante considera as modalidades PJ ou Cooperado para presta&ccedil;&atilde;o do servi&ccedil;o.</span><br /><br /><span>Necess&aacute;rio experi&ecirc;ncia como Desenvolvedor utilizando:</span><br /><br /><span>- Java;</span><br /><span>- Spring Boot;</span><br /><span>- Html, CSS3, Javascript</span><br /><span>- MongoDB</span><br /><br /><span>Desej&aacute;vel conhecimento na &uacute;ltima vers&atilde;o do Angular.</span><br /><br /><span>Valor hora a combinar.</span><br /><br /><span>Interessados enviar curr&iacute;culo para oportunidade@requisita.com.br que transmitiremos mais informa&ccedil;&otilde;es.</span></p>', 2800.15, 'Back end', 'Desenvolvedor Back end', 91120);
INSERT INTO  tb_oferta (endereco_id, ativa, descricao, preco, sub_titulo, titulo, cliente_id) VALUES (6, true, '<p><span>&Eacute; para uma empresa de usinagem e ser&atilde;o 3 paginas:</span><br /><span>Sobre a empresa</span><br /><span>Servi&ccedil;os oferecidos</span><br /><span>e contato com formul&aacute;rio mandando para o e-mail</span><br /><span>Imagens e textos fornecidos por n&oacute;s e apenas em portugu&ecirc;s</span></p>', 1900.95, 'Front end', 'Desenvolvedor Front end', 91120);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (1, 1);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (1, 4);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (1, 2);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (2, 1);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (2, 2);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (2, 5);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (3, 4);
INSERT INTO  tb_oferta_categoria (oferta_id, categoria_id) VALUES (3, 6);



