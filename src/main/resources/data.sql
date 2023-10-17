INSERT INTO users (user_id, first_name, last_name, email, password, profile_picture, biography, fun_fact)
VALUES
    (1, 'John', 'Doe', 'johndoe@email.com', 'password123', 'profile_pic1.jpg', 'I love hiking!', 'I can play the guitar.'),
    (2, 'Jane', 'Smith', 'janesmith@email.com', 'pass456', 'profile_pic2.jpg', 'Travel enthusiast', 'I speak five languages.'),
    (3, 'Alice', 'Johnson', 'alice@email.com', 'mypassword', 'profile_pic3.jpg', 'Foodie and chef', 'I make the best lasagna.');

INSERT INTO groups (group_id, group_name, description, creation_date, is_private)
VALUES
    (1, 'Outdoor Adventurers', 'A group for nature lovers', '2023-10-10', false),
    (2, 'Tech Enthusiasts', 'Discuss the latest tech trends', '2023-10-11', true),
    (3, 'Foodies Club', 'Share your favorite recipes', '2023-10-12', false);

INSERT INTO events (event_id, title, description, start_date, end_date, creation_date, participants)
VALUES
    (1, 'Hiking Trip', 'Let''s explore the mountains!', '2023-10-15', '2023-10-17', '2023-10-10', '1,2,3'),
    (2, 'Tech Conference', 'Learn about the latest tech innovations', '2023-11-05', '2023-11-07', '2023-10-11', '2'),
    (3, 'Cooking Class', 'Master the art of making pasta', '2023-10-20', '2023-10-20', '2023-10-12', '3');

INSERT INTO posts (post_id, user_id, group_id, associated_event_id, title, content, creation_date)
VALUES
    (1, 1, 1, 1, 'Amazing Hike!', 'We had a fantastic time hiking in the mountains.', '2023-10-16'),
    (2, 2, 2, 2, 'Tech Conference Highlights', 'The conference was very informative.', '2023-11-06'),
    (3, 3, 3, 3, 'Pasta Recipe', 'Here''s my secret pasta recipe!', '2023-10-20');

INSERT INTO direct_messages (message_id, sender_user_id, receiver_user_id, content, timestamp)
VALUES
    (1, 1, 2, 'Hi Jane, how are you?', '2023-10-11 08:30:00'),
    (2, 2, 3, 'Alice, can you share your pasta recipe?', '2023-10-12 14:15:00'),
    (3, 3, 1, 'John, let''s plan the next hiking trip.', '2023-10-13 19:45:00');

INSERT INTO user_groups (user_group_id, user_id, group_id)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);
