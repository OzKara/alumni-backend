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
        'Ble kontaktet av et modellfirma som ville at jeg skulle jobbe for dem, men valgte et huble life i stedet');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('7e68cd4b-7bd0-4ab1-b2df-09bf54f7e87e',
        'Henning Sletner',
        'https://ca.slack-edge.com/T05AYAELMFV-U05M987B2U8-c57553490856-512',
        'Working hard or hardly working',
        'På god vei til å nå mine fremtidige planer om at all iskrem blir ulovlig.',
        'Er ca 197cm høy, men nei jeg har ikke gjort noe i livet som man skulle tro en høy person har gjort.');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('71677904-aa91-4894-96b7-45521a921172',
        'Ozan Kara',
        'https://ca.slack-edge.com/T05AYAELMFV-U05M988LNJC-a50b35d49be8-512',
        'Trøbbel med dama',
        'Vet ikke helt hva jeg driver med, men det funker!',
        'Flytter kanskje til Barcelona snart, får se hvor sur dama er.');
INSERT INTO Users (id, name, picture, status, bio, fun_fact)
VALUES ('8828d6bd-b2d0-4bd4-aaae-4cb5f03c834a',
        'Lucas Tran',
        'https://cdn.drawception.com/images/avatars/647493-B9E.png',
        'Dont know what im doing',
        'My Biography',
        'A fact which is fun, is a fun fact');
INSERT INTO Users (id, name)
VALUES ('mockuser1',
        'Tage Mjaunthe Berg');
INSERT INTO Users (id, name)
VALUES ('mockuser2',
        'Oddish Almklov');
INSERT INTO Users (id, name)
VALUES ('mockuser3',
        'Ivan Kohmann');
INSERT INTO Users (id, name)
VALUES ('mockuser4',
        'Jørn Borander');
INSERT INTO Users (id, name)
VALUES ('mockuser5',
        'Asstrid Stubbis');
INSERT INTO Users (id, name)
VALUES ('mockuser6',
        'Luisa Möhle');
INSERT INTO Users (id, name)
VALUES ('mockuser7',
        'Queez Kampen');
INSERT INTO Users (id, name)
VALUES ('mockuser8',
        'Mad Hatter Mike');
INSERT INTO Users (id, name)
VALUES ('mockuser9',
        'Dean Von Schoultz');
INSERT INTO Users (id, name)
VALUES ('mockuser10',
        'A student');
INSERT INTO Users (id, name)
VALUES ('mockuser11',
        'Another student');
INSERT INTO Users (id, name)
VALUES ('mockuser12',
        'Bixit Gulnes Heien');

INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'Java Kurs',
         'Fullstack Java Program',
         '#FFFFF', true);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( '.Net Kurs',
         'Fullstack .Net Program',
         '#008B8B', true);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'Class of 2023',
         'Den kuleste klassen noensinne',
         '#008B8B', true);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'Teachers',
         'Higher Rank',
         '#008B8B', false);
INSERT INTO Groups (name, description, color, is_private)
VALUES ( 'Students',
         'Lower Rank',
         '#008B8B', false);

INSERT INTO group_user ("groups_id", "users_id")
VALUES (1, '8828d6bd-b2d0-4bd4-aaae-4cb5f03c834a');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, '71677904-aa91-4894-96b7-45521a921172');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (3, 'd7ab172c-7cab-4bf1-b94e-3e38a7400793');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, '4535e26b-692c-4fc6-a1c9-9e164d1daf7c');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, '8828d6bd-b2d0-4bd4-aaae-4cb5f03c834a');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, '71677904-aa91-4894-96b7-45521a921172');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (5, 'd7ab172c-7cab-4bf1-b94e-3e38a7400793');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, '4535e26b-692c-4fc6-a1c9-9e164d1daf7c');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, '8828d6bd-b2d0-4bd4-aaae-4cb5f03c834a');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser1');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (3, 'mockuser2');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (3, 'mockuser3');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (3, 'mockuser4');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser5');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser6');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser7');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser8');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser9');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser10');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser11');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (3, 'mockuser12');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (4, 'mockuser8');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (4, 'mockuser9');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (4, '4535e26b-692c-4fc6-a1c9-9e164d1daf7c');

INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser1');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (5, 'mockuser2');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (5, 'mockuser3');
INSERT INTO group_user ("groups_id", "users_id")
VALUES (5, 'mockuser4');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser5');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser6');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser7');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser10');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser11');
INSERT INTO group_user ("groups_id", "users_id")
VALUES  (5, 'mockuser12');



-- Post 1
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', '7e68cd4b-7bd0-4ab1-b2df-09bf54f7e87e', 1,
        'Alumni applikasjonen',
        'Hva synes dere om denne applikasjonen? Vennligst gi svar under', 2);

-- Post 2
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', '4535e26b-692c-4fc6-a1c9-9e164d1daf7c', 1,
        'Okaaaaay ',
        'leezgo', 2);

-- Post 3
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', '71677904-aa91-4894-96b7-45521a921172', 1,
        'Simplicity in Design',
        'Designing with simplicity in mind is like telling a story with few words - it ensures clarity and ease of use.', 2);

INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', 'mockuser1', 1,
        'Mjau',
        'mjau mjau', 2);
-- Post 4
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', 'd7ab172c-7cab-4bf1-b94e-3e38a7400793', 1,
        'Responsive Web Design',
        'Creating responsive web designs is like building a flexible house - it adapts to different screen sizes and devices.', 2);

INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', 'mockuser2', 1,
        'Gratuler meg!',
        'Jeg fikk meg jobb i går på Power!! Jeg er så glad', 2);



-- Post 4
INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', '71677904-aa91-4894-96b7-45521a921172', 1,
        'Stor dag i dag',
        'Stor dag i dag, presentasjon på Noroff. Ønsk oss lykke til', 2);


INSERT INTO Post (created_at, updated_at, owner_id, origin_id, title, content, group_id)
VALUES ('2023-10-10 10:15', '2023-10-10', '4535e26b-692c-4fc6-a1c9-9e164d1daf7c', 1,
        'Presentations at Noroff today',
        'The students at the course are having presentations today, i cant wait to roast them', 2);

