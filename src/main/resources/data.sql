INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User1', 'user1@gmail.com', '$2a$12$qrLb8Pwpjw0pwAyU3QI/U.Aw.YB27tYRgVlwhmHYmW/FxYOPVBKXW'),
       ('User2', 'user2@gmail.com', '$2a$12$qrLb8Pwpjw0pwAyU3QI/U.Aw.YB27tYRgVlwhmHYmW/FxYOPVBKXW'),
       ('Admin', 'admin@gmail.com', '$2a$12$YI3JQuLwQVQ2sCklRmUUHuVWYjMHZ.Y0vTO0QqeMsa35hLHHB9ij2');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('USER', 2),
       ('ADMIN', 3);

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