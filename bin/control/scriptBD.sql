CREATE DATABASE DB_PI

USE DB_PI

CREATE TABLE TBFACULDADE (
CODFACULDADE INT CONSTRAINT PKCODFACULDADE PRIMARY KEY,
NOMEFACULDADE VARCHAR (50) NOT NULL,
ENDERECOFACULDADE VARCHAR (70) NOT NULL, 
NUMEROFACULDADE INT,
BAIRROFACULDADE VARCHAR (70),
CIDADEFACULDADE VARCHAR (70) NOT NULL ,
CEPFACULDADE CHAR (8) NOT NULL 
)

CREATE TABLE TBCURSO (
CODCURSO INT CONSTRAINT PKCODCURSO PRIMARY KEY,
NOMECURSO VARCHAR (70) NOT NULL,
CODFACULDADE INT NOT NULL CONSTRAINT FKCODFACULDADE FOREIGN KEY (CODFACULDADE) REFERENCES TBFACULDADE ON DELETE CASCADE
)


CREATE TABLE TBDISCIPLINA ( 
CODDISCIPLINA INT CONSTRAINT PKCODDISCIPLINA PRIMARY KEY,
NOMEDISCIPLINA VARCHAR (60) NOT NULL,
CARGAHORARIA INT NOT NULL
) 

CREATE TABLE TBCURSODISCIPLINA (
CODCURSODISCIPLINA INT CONSTRAINT PKCODCURSODISCIPLINA PRIMARY KEY IDENTITY, 
CODCURSO INT NOT NULL CONSTRAINT FKCODCURSO FOREIGN KEY (CODCURSO) REFERENCES TBCURSO ON DELETE CASCADE,
CODDISCIPLINA INT NOT NULL CONSTRAINT FKCODDISCIPLINA FOREIGN KEY (CODDISCIPLINA) REFERENCES TBDISCIPLINA ON DELETE CASCADE,
UNIQUE (CODCURSO, CODDISCIPLINA)
)

CREATE TABLE TBALUNOUSUARIO ( 
CODALUNOUSUARIO INT CONSTRAINT PKCODALUNO PRIMARY KEY, 
CODCURSO INT NOT NULL CONSTRAINT FKCODCURSOALUNO FOREIGN KEY (CODCURSO) REFERENCES TBCURSO ON DELETE CASCADE,
NOMEALUNO VARCHAR (80) NOT NULL, 
CPFALUNO CHAR (11) CONSTRAINT UQCPFALUNO UNIQUE NOT NULL, 
DATANASCIMENTOALUNO DATE NOT NULL, 
EMAILALUNO VARCHAR (70) NOT NULL,  
LOGINUSUARIO VARCHAR (50),
SENHAUSUARIO VARCHAR (30) NOT NULL,
CODPERFIL CHAR (1) NOT NULL --Esse campo deve aparecer apenas para o usu�rio mestre
) 

CREATE TABLE TBUSUARIODISCIPLINA (
CODUSUARIODISCIPLINA INT CONSTRAINT PKUSUARIODISCIPLINA PRIMARY KEY IDENTITY,
CODALUNOUSUARIO INT NOT NULL CONSTRAINT FKCALUNOUSUARIOU FOREIGN KEY (CODALUNOUSUARIO) REFERENCES TBALUNOUSUARIO ON DELETE CASCADE,
CODCURSODISCIPLINA INT NOT NULL CONSTRAINT FKCODCURSODISCIPLINAU FOREIGN KEY (CODCURSODISCIPLINA) REFERENCES TBCURSODISCIPLINA
)

CREATE TABLE TBTAREFA (
CODTAREFA INT CONSTRAINT PKCODTAREFA PRIMARY KEY IDENTITY,
CODCURSODISCIPLINA INT CONSTRAINT FKCODCURSODISCIPLINAT FOREIGN KEY (CODCURSODISCIPLINA) REFERENCES TBCURSODISCIPLINA,
NOMETAREFA VARCHAR(70) NOT NULL,
DESCRICAOTAREFA VARCHAR(500),
DATAENTREGATAREFA DATE NOT NULL,
STATUSTAREFA INT NOT NULL,
PUBLICAOUPRIVADA BIT NOT NULL
)

CREATE TABLE TBALUNOTAREFA (
CODALUNOTAREFA INT CONSTRAINT PKCODALUNOTAREFA PRIMARY KEY IDENTITY,
CODALUNOUSUARIO INT NOT NULL FOREIGN KEY (CODALUNOUSUARIO) REFERENCES TBALUNOUSUARIO,
CODTAREFA INT NOT NULL FOREIGN KEY (CODTAREFA) REFERENCES TBTAREFA,
STATUSALUNOTAREFA INT NOT NULL 
UNIQUE (CODALUNOUSUARIO, CODTAREFA)
)

-- OS CAMPOS "STATUS TAREFAS" E "STATUSALUNOTAREFA" SER� INT PARA TRATARMOS A INFORMA��O O FRONTEND

CREATE TABLE TBFLASHCARD (
CODFLASHCARD INT CONSTRAINT PKCODFLASHCARD PRIMARY KEY IDENTITY,
CODALUNO INT NOT NULL CONSTRAINT FKCODALUNO FOREIGN KEY (CODALUNO) REFERENCES TBALUNOUSUARIO ON DELETE CASCADE, 
CODCURSODISCIPLINA INT NOT NULL CONSTRAINT FKCODCURSODISCIPLINAFC FOREIGN KEY (CODCURSODISCIPLINA) REFERENCES TBCURSODISCIPLINA,
NOMEFLASHCARD VARCHAR (40) NOT NULL, 
PERGUNTAFLASHCARD VARCHAR(70) NOT NULL,
RESPOSTAFLASHCARD VARCHAR (200) NOT NULL 
)