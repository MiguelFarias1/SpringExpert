INSERT INTO tb_category (name, created_At) VALUES ('Livros', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Eletrônicos', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Computadores', NOW());

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Lord of the Rings', 90.5, '2020-07-14T10:00:00Z', 'Epic fantasy trilogy', 'https://example.com/lord_of_the_rings.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Harry Potter and the Philosopher s Stone', 45.0, '1997-06-26T10:00:00Z', 'First book in the Harry Potter series', 'https://example.com/harry_potter.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('To Kill a Mockingbird', 15.0, '1960-01-11T10:00:00Z', 'Classic novel about racial injustice', 'https://example.com/to_kill_a_mockingbird.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('1984', 20.0, '1949-06-08T10:00:00Z', 'Dystopian novel about a totalitarian regime', 'https://example.com/1984.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Pride and Prejudice', 25.0, '1813-01-28T10:00:00Z', 'Classic romance novel', 'https://example.com/pride_and_prejudice.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Great Gatsby', 30.0, '1925-04-10T10:00:00Z', 'Novel about the American Dream', 'https://example.com/the_great_gatsby.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Moby-Dick', 35.0, '1851-10-18T10:00:00Z', 'Whale hunting epic', 'https://example.com/moby_dick.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('War and Peace', 40.0, '1869-01-01T10:00:00Z', 'Historical novel about Russia', 'https://example.com/war_and_peace.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Les Misérables', 50.0, '1862-04-01T10:00:00Z', 'Novel about social inequality', 'https://example.com/les_miserables.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Ulysses', 60.0, '1922-02-16T10:00:00Z', 'Modernist novel', 'https://example.com/ulysses.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Catch-22', 70.0, '1961-06-16T10:00:00Z', 'Anti-war novel', 'https://example.com/catch_22.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Catcher in the Rye', 80.0, '1951-03-16T10:00:00Z', 'Coming-of-age novel', 'https://example.com/catcher_in_the_rye.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Grapes of Wrath', 85.0, '1939-04-14T10:00:00Z', 'Novel about the Dust Bowl', 'https://example.com/grapes_of_wrath.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Odyssey', 95.0, '800-01-01T10:00:00Z', 'Epic poem', 'https://example.com/odyssey.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Iliad', 100.0, '800-01-01T10:00:00Z', 'Epic poem', 'https://example.com/iliad.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('The Divine Comedy', 105.0, '1320-01-01T10:00:00Z', 'Epic poem', 'https://example.com/divine_comedy.jpg');

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Don Quixote', 110.0, '1605-01-01T10:00:00Z', 'Novel about chivalry', 'https://example.com/don_quixote.jpg');


INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (13, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (14, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (15, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (16, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (17, 3);