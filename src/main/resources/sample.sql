-- DROP --
DROP Table services_roles ;
DROP Table services;
DROP Table hasRole;
DROP Table `member` ;

-- Member 테이블 --
CREATE TABLE `member` (
                          `id` bigint(20) NOT NULL,
                          `authority` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `user_id` varchar(255) DEFAULT NULL,
                          `email` varchar(255) DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `member_UN` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;

-- 서비스리스 테이블 --
CREATE TABLE `services` (
                            `name` varchar(100) NOT NULL,
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;

-- 서비스 롤 테이블 --
CREATE TABLE `services_roles` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                  `role` varchar(100) NOT NULL,
                                  `description` text DEFAULT NULL,
                                  `sid` bigint(20) NOT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `services_roles_FK` (`sid`),
                                  CONSTRAINT `services_roles_FK` FOREIGN KEY (`sid`) REFERENCES `services` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;

-- 유저 롤 매핑
CREATE TABLE `hasRole` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `uid` bigint(20) NOT NULL,
                           `role_id` bigint(20) NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `hasRole_FK` (`uid`),
                           CONSTRAINT `hasRole_FK` FOREIGN KEY (`uid`) REFERENCES `member` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;

-- init data --
INSERT services
(name)
VALUES('auth');

INSERT INTO services_roles
(`role`, sid, description)
VALUES('admin', 1, '권한 설명');
