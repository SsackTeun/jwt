# JWT Token Server
Spring Boot 2.7.3

USESE

application.yml
```yml
spring:
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://{ip or domain}:{port}/{dbname}
    username: {your-database-username}
    password: {your-database-password}
  jpa:
    hibernate:
      ddl-auto: update
    generate-ddl: true
    show-sql: true

jwt:
  secret: {your-secretKey}

```

build.gradle
```gradle
    /*JWT*/
    implementation group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.11.5'
    runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.11.5'
    implementation 'io.jsonwebtoken:jjwt-gson:0.11.5'

    /*DATABASE*/
    implementation group: 'org.mariadb.jdbc', name: 'mariadb-java-client', version: '3.0.7'

    /*SPRING BOOT*/
        /*CORE*/
    implementation group: 'org.springframework.security', name: 'spring-security-core', version: '5.7.3'
        /*SECURITY*/
    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-security', version: '2.7.3'
        /*WEB*/
    implementation 'org.springframework.boot:spring-boot-starter-web'
        /*JPA*/
    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-data-jpa', version: '2.7.3'
        /*LIVE RELOAD*/
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
        /*TEST tool*/
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
        /*REST DOCS*/
    testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'

    /*LOMBOK*/
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
```



