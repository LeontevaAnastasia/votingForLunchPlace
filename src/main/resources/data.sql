INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User1', 'user1@gmail.com', 'password'),
       ('User2', 'user2@gmail.com', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_USER', 2),
       ('ROLE_ADMIN', 3);

INSERT INTO RESTAURANTS (RESTAURANT_NAME, ADDRESS)
VALUES ('Shabby', 'Гороховая 11'),
       ('Tokyo City', 'Невский пр. 71'),
       ('Пхали-Хинкали','Большая-Морская 27');

INSERT INTO DISHES (DISH_NAME, PRICE,REST_ID)
VALUES ('Том-Ям', 450.00, 1),
       ('Стейк Рибай', 870.00, 1),
       ('Боул с угрем', 540.00, 2),
       ('Хинкали', 390.00, 3),
       ('Хачапури по аджарски',280.00, 3);

INSERT INTO VOTES (USER_ID, REST_ID)
VALUES (1,1),
       (2,2),
       (3,1);