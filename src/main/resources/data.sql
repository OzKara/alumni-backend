INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('nicholas',
        'Nicholas Lennox',
        'https://ychef.files.bbci.co.uk/976x549/p07ryyyj.jpg',
        'Smol criminal',
        'Introducing Eivind, a curious and adventurous cat who enjoys exploring new places and playing with toys that make crinkly sounds.',
        'Did you know that Oslo is home to the world''s longest art gallery, which is located in the city''s subway system and features over 100 unique works of art?');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('d7ab172c-7cab-4bf1-b94e-3e38a7400793',
        'Hashir Raja',
        'https://i.ytimg.com/vi/fOd16PT1S7A/maxresdefault.jpg',
        'The Great Catsby',
        'Meet Martin, a playful and cuddly feline who loves nothing more than chasing laser pointers and napping in sunny spots around the house.',
        'Why is it so easy to weigh tuna? - They have their own scales');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('7e68cd4b-7bd0-4ab1-b2df-09bf54f7e87e',
        'Henning Sletner',
        'https://www.rd.com/wp-content/uploads/2021/01/GettyImages-1175550351.jpg',
        'Cat me some slack, will you?',
        'A cat above the rest.',
        'Purr-haps we can cuddle later.');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('ozan',
        'Ozan Kara',
        'https://i.pinimg.com/564x/32/f2/43/32f24381b05fcf53d8088c98963fe326.jpg',
        'It''s a cat-astrophy!',
        'Born fluffy, still fluffy.',
        'What do you call a tuna with a tie? - Sofishticated');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('700a6c07-f116-4cb4-bf7e-0930a9d4b9ad',
        'Lucas Tran',
        'https://cdn.drawception.com/images/avatars/647493-B9E.png',
        'ARBEIDSLEDIG',
        'LOLLOLOLOLLOLOLOLOLLOL',
        'FUN FACT ABOUT ME');

INSERT INTO Groups ( name, description, color, is_private)
VALUES ('GRUPPPE 1',
        'dette er gruppe 1 og dette er ikke en gøy gruppe!',
        '#FF1493', true);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'Gruppe 2',
         'Dette er gruppe 2 og dette er hvertfall ikke en gøy gruppe',
         '#008B8B', true);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'JAVA KURS',
         'FULL STACK JAVA PROGRAM COURSE ON NOROFF ACCELERAATEEEEEEEEEEEE',
         '#FFFFF', false);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( '.Net Kurs',
         'simsallabim bim muchas gracias aficion, esto es para vosotros suiiiiiiiii',
         '#008B8B', false);

INSERT INTO group_user ("groups_id", "users_id")
VALUES (1, 'lucas');
VALUES (2, 'henning');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, 'ozan');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, 'hashir');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, 'nicholas');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, 'lucas');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (3, 'lucas');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (4, 'lucas');-- Post 1
INSERT INTO Posts (created_at, updated_at, post_target, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-01 10:15', '2023-04-01', 'TOPIC', 'lucas', 1,
        'The Art of Typography',
        'Typography in design is like the notes in a beautiful song - it sets the tone and rhythm of your message.' ||
        '![typography](https://example.com/typography-image.jpg)', 2);

-- Post 2
INSERT INTO Posts (created_at, updated_at, post_target, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-02 14:45', '2023-04-02', 'TOPIC', 'lucas', 1,
        'The Colors of UX',
        'Choosing the right color palette for your user interface is like painting a masterpiece - it evokes emotions and enhances the user experience.' ||
        '![color palette](https://example.com/color-palette-image.jpg)', 2);

-- Post 3
INSERT INTO Posts (created_at, updated_at, post_target, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-03 12:30', '2023-04-03', 'TOPIC', 'ozan', 1,
        'Simplicity in Design',
        'Designing with simplicity in mind is like telling a story with few words - it ensures clarity and ease of use.' ||
        '![simplicity](https://example.com/simplicity-image.jpg)', 2);

-- Post 4
INSERT INTO Posts (created_at, updated_at, post_target, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-04 17:20', '2023-04-04', 'TOPIC', 'lucas', 1,
        'Responsive Web Design',
        'Creating responsive web designs is like building a flexible house - it adapts to different screen sizes and devices.' ||
        '![responsive design](https://example.com/responsive-design-image.jpg)', 2);