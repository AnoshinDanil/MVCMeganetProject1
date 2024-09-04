INSERT INTO city (name)values
                           ('Москва'),
                           ('Ростов-на-Дону');


-- добавление улиц для Москва
INSERT INTO street (street_name) VALUES
                                     ('Маяковская'),
                                     ('Тверская');

INSERT INTO street (street_name) VALUES
                                     ('Ленина');

INSERT INTO city_street (city_id, street_id) VALUES
                                                 (1,2),
                                                 (1,1),
                                                 (2,3);