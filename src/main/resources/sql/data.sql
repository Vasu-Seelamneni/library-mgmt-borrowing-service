CREATE TABLE borrowings (
                            id SERIAL PRIMARY KEY,
                            user_id INT,
                            book_id INT,
                            borrowed_date TIMESTAMP,
                            due_date TIMESTAMP,
                            returned_date TIMESTAMP
);

/*Insert sample data*/
INSERT INTO borrowings (user_id, book_id, borrowed_date, due_date, returned_date) VALUES
(1, 1, '2022-01-01 10:00:00', null, null),
(2, 2, '2022-01-01 10:00:00', null, null),
(3, 3, '2022-01-01 10:00:00', null, null),
(4, 4, '2022-01-01 10:00:00', null, null),
(5, 5, '2022-01-01 10:00:00', null, null),
(6, 6, '2022-01-01 10:00:00', null, null),
(7, 7, '2022-01-01 10:00:00', null, null),
(8, 8, '2022-01-01 10:00:00', null, null),
(9, 9, '2022-01-01 10:00:00', null, null),
(10, 10, '2022-01-01 10:00:00', '2022-01-02 10:00:00', '2022-01-03 10:00:00');