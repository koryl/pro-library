INSERT INTO books (book_name, book_author, book_description, is_borrowed, book_cover) VALUES ('The Lord of the Rings', 'Tolkien, J.R.R.', 'From quiet beginnings in the Shire, a hobbit must destroy One Ring and safe Middle-earth from destruction.', true, 'ring-2226177_640.jpg');
INSERT INTO books (book_name, book_author, book_description, is_borrowed, book_cover) VALUES ('The Colour of Magic', 'Pratchett, Terry', 'The worst wizard in Discworld, Rincewind, is hired as a guide to the rich but naive Twoflower.', false, 'graphic-2420746_640.jpg');
INSERT INTO books (book_name, book_author, book_description, is_borrowed, book_cover) VALUES ('The Witcher', 'Sapkowski, Andrzej', 'There is never a second opportunity to make a first impression.', false, 'sword-1078968_640.jpg');
INSERT INTO books (book_name, book_author, book_description, is_borrowed, book_cover) VALUES ('Dune', 'Herbert, Frank', 'Revenge is for children and the emotionally retarded.', false, 'algodones-dunes-1654439_640.jpg');
INSERT INTO books (book_name, book_author, book_description, is_borrowed) VALUES ('The Name of the Wind', 'Rothfuss, Patrick', 'At the very beginning, the reader hears an old story-teller speaking of a famous old wizard called Taborlin the Great, who was captured by evil beings called the Chandrian.', false);
INSERT INTO books (book_name, book_author, book_description, is_borrowed, book_cover) VALUES ('Harry Potter and the Philosopher''s Stone', 'Rowling, J.K.', 'Harry Potter has been living an ordinary life, his life changes on the day of his eleventh birthday when he receives a letter of acceptance into a Hogwarts School of Witchcraft and Wizardry.', false, 'light-1157952_640.jpg');
INSERT INTO books (book_name, book_author, book_description, is_borrowed, book_cover) VALUES ('Master and Margarita', 'Bulhakov, Mikhail', 'The darkness that had come in from the Mediterranean covered the city so detested by the procurator...', false, 'cat-2143332_640.jpg');
INSERT INTO books (book_name, book_author, book_description, is_borrowed) VALUES ('Nine Princes in Amber', 'Zelazny, Roger', 'Carl Corey wakes in a medical clinic, with little to no knowledge of who he is or how he got there. He suspects he is being over-medicated, so he overpowers the nurse and doctor and escapes his room.', false);
INSERT INTO books (book_name, book_author, book_description, is_borrowed) VALUES ('A Game of Thrones', 'Martin, George R.R.', 'North of the Wall, a small patrol of Rangers from the Night''s Watch encounter the Others, an ancient and hostile race of superhumans. All of the Rangers are killed except the single survivor later executed by Eddard Stark for desertion.', false);

INSERT INTO users (first_name, last_name, email, password) VALUES ('Adrian', 'Koryl', 'admin@prolib.com', '$2a$10$RyY4bXtV3LKkDCutlUTYDOKd2AiJYZGp4Y7MPVdLzWzT1RX.JRZyG');
INSERT INTO users (first_name, last_name, email, password) VALUES ('Jan', 'Kowalski', 'user@prolib.com', '$2a$10$RyY4bXtV3LKkDCutlUTYDOKd2AiJYZGp4Y7MPVdLzWzT1RX.JRZyG');

INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

INSERT INTO users_borrowed_books (user_user_id, borrowed_books_book_id) VALUES (2, 1);