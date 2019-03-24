CREATE TABLE meals (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  price double,

);

insert into meals (name, price) values
    ('Paella', 9),
    ('Pasta Bolognese', 7),
    ('Tuna salad', 6);
