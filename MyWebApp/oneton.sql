
CREATE SCHEMA `oneton`;
CREATE TABLE `oneton`.`authors` (
  `id_authors` int(11) NOT NULL AUTO_INCREMENT,
  `name_author` varchar(45) NOT NULL,
  PRIMARY KEY (`id_authors`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

CREATE TABLE `oneton`.`files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `file` longblob NOT NULL,
  `fileName` varchar(200) NOT NULL,
  `id_authors` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `aut_idx` (`id_authors`),
  CONSTRAINT `aut` FOREIGN KEY (`id_authors`) REFERENCES `authors` (`id_authors`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

CREATE TABLE `oneton`.`moderators` (
  `idMod` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idMod`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



/*SET GLOBAL max_allowed_packet = 1024*1024*5 что бы можно было загрузить файл до 5 метров
