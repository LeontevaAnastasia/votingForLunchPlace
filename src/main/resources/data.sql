INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', 'password'),
       ('Admin', 'admin@javaops.ru', 'admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2);

INSERT INTO RESTAURANTS (RESTAURANT_NAME, ADDRESS)
VALUES ('Shabby', 'Гороховая 11'),
       ('Tokyo City', 'Невский пр. 71');

INSERT INTO DISHES (DISH_NAME, PRICE,REST_ID)
VALUES ('Том-Ям', 450, 1),
       ('Стейк Рибай', 870, 1),
       ('Боул с угрем', 540, 2);

INSERT INTO VOTES (USER_ID, REST_ID)
VALUES (1,1),
       (2,1);