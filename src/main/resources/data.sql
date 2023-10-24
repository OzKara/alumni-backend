INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('4535e26b-692c-4fc6-a1c9-9e164d1daf7c',
        'Nicholas Lennox',
        'https://ca.slack-edge.com/T05AYAELMFV-U05LDCDG932-0b045ebe1c9a-512',
        'Teaching important stuff',
        'Probably the best Java instructor in the world and i LOVE php, i think its the best programming language in the world <3',
        'My favorite food is pizza-rolls and pop-tarts and i like to combine them and it it for dinner');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('d7ab172c-7cab-4bf1-b94e-3e38a7400793',
        'Hashir Raja',
        'https://i.ytimg.com/vi/fOd16PT1S7A/maxresdefault.jpg',
        'Noe dukket opp',
        'Sleeping is my thing, football is my swing',
        'Ble kontaktet av et modellfirma som ville at jeg slkulle jobbe for dem, men valgte et huble life i stedet');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('7e68cd4b-7bd0-4ab1-b2df-09bf54f7e87e',
        'Henning Sletner',
        'https://ca.slack-edge.com/T05AYAELMFV-U05M987B2U8-c57553490856-512',
        'Working hard or hardly working',
        'På god vei til å nå mine fremtidige planer om at all iskrem blir ulovlig.',
        'Er ca 197cm høy, men nei jeg har ikke gjort noe i livet som man skulle tro en høy perosn har gjort.');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('71677904-aa91-4894-96b7-45521a921172',
        'Ozan Kara',
        'https://ca.slack-edge.com/T05AYAELMFV-U05M988LNJC-a50b35d49be8-512',
        'Trøbbel med dama',
        'Vet ikke helt hva jeg driver med, men det funker!',
        'Flytter kanskje til Barcelona snart, får se hvor sur dama er.');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('700a6c07-f116-4cb4-bf7e-0930a9d4b9ad',
        'Lucas Tran',
        'https://cdn.drawception.com/images/avatars/647493-B9E.png',
        'ARBEIDSLEDIG',
        'LOLLOLOLOLLOLOLOLOLLOL',
        'FUN FACT ABOUT ME');

INSERT INTO Groups ( name, description, color, is_private)
VALUES ('Vi som elsker maling',
        'Dette er en gruppe for de som er lidenskapelig opptatt av maling og vil dele den gleden med andre!',
        '#FF1493', true);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'Jorda er illusjon',
         'Dette er en gruppe for de som mener at jordkloden er en illusjon og ikke eksisterer',
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
VALUES (1, '700a6c07-f116-4cb4-bf7e-0930a9d4b9ad');
VALUES (2, '7e68cd4b-7bd0-4ab1-b2df-09bf54f7e87e');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, '71677904-aa91-4894-96b7-45521a921172');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, 'd7ab172c-7cab-4bf1-b94e-3e38a7400793');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, '4535e26b-692c-4fc6-a1c9-9e164d1daf7c');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (2, '700a6c07-f116-4cb4-bf7e-0930a9d4b9ad');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (3, '700a6c07-f116-4cb4-bf7e-0930a9d4b9ad');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (4, '700a6c07-f116-4cb4-bf7e-0930a9d4b9ad');

-- Post 1
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-01 10:15', '2023-04-01', '7e68cd4b-7bd0-4ab1-b2df-09bf54f7e87e', 1,
        'The Art of Typography',
        'Typography in design is like the notes in a beautiful song - it sets the tone and rhythm of your message.' ||
        '![typography](https://example.com/typography-image.jpg)', 2);

-- Post 2
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-02 14:45', '2023-04-02', '700a6c07-f116-4cb4-bf7e-0930a9d4b9ad', 1,
        'The Colors of UX',
        'Choosing the right color palette for your user interface is like painting a masterpiece - it evokes emotions and enhances the user experience.' ||
        '![color palette](https://example.com/color-palette-image.jpg)', 2);

-- Post 3
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-03 12:30', '2023-04-03', '71677904-aa91-4894-96b7-45521a921172', 1,
        'Simplicity in Design',
        'Designing with simplicity in mind is like telling a story with few words - it ensures clarity and ease of use.' ||
        '![simplicity](https://example.com/simplicity-image.jpg)', 2);

-- Post 4
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-04-04 17:20', '2023-04-04', 'd7ab172c-7cab-4bf1-b94e-3e38a7400793', 1,
        'Responsive Web Design',
        'Creating responsive web designs is like building a flexible house - it adapts to different screen sizes and devices.' ||
        '![responsive design](https://example.com/responsive-design-image.jpg)', 2);

-- Post 4
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 12:25', '2023-04-04', '71677904-aa91-4894-96b7-45521a921172', 1,
        'Stor dag i dag',
        'Stor dag i dag, presentasjon på Noroff. Kommer til å gå veldig not so good. Lol', 2);