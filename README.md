# JWT Token Server
Spring Boot 2.7.3
- Spring Security 

JPA 
- MariaDB

Dependency
- JWT : implementation group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.11.5'        
- JDBC : implementation group: 'org.mariadb.jdbc', name: 'mariadb-java-client', version: '3.0.7'       

- Spring Boot Web : implementation 'org.springframework.boot:spring-boot-starter-web'
- Spring Data : implementation group: 'org.springframework.boot', name: 'spring-boot-starter-data-jpa', version: '2.7.3'
- Spring Core : implementation group: 'org.springframework.security', name: 'spring-security-core', version: '5.7.3'
- Spring Security : implementation group: 'org.springframework.boot', name: 'spring-boot-starter-security', version: '2.7.3'


- Lombok : compileOnly 'org.projectlombok:lombok'
- Live Reload : developmentOnly 'org.springframework.boot:spring-boot-devtools'
- annotationProcessor 'org.projectlombok:lombok'

- APP Test : testImplementation 'org.springframework.boot:spring-boot-starter-test'
- MVC TEST : testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'



