DROP TABLE IF EXISTS movies;

CREATE TABLE IF NOT EXISTS movies(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(50) NOT NULL,
 minutes INT NOT NULL,
 director VARCHAR(50) NOT NULL,
 genre VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, director, genre) values
('Dark Knight', 152, 'Christopher Nolan', 'ACTION'),
('Memento', 113, 'Christopher Nolan', 'THRILLER'),
('Matrix', 136, 'Wachowski Sisters', 'ACTION');