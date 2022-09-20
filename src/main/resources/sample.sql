-- DROP --
DROP Table services_roles ;
DROP Table services;

-- 서비스리스트 테이블 --
CREATE TABLE `services` (
                            `name` varchar(100) NOT NULL,
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;

-- 서비스 롤 테이블 --
-- dev.services_roles definition
CREATE TABLE `services_roles` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                  `role` varchar(100) NOT NULL,
                                  `sid` bigint(20) DEFAULT NULL,
                                  `description` text DEFAULT NULL,
                                  KEY `roles_FK` (`id`),
                                  KEY `services_roles_FK` (`sid`),
                                  CONSTRAINT `services_roles_FK` FOREIGN KEY (`sid`) REFERENCES `services` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;

-- init data --
INSERT services
(name)
VALUES('auth');

INSERT INTO services_roles
(`role`, sid, description)
VALUES('admin', 1, '권한 설명');
