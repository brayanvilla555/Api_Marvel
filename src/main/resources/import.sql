

INSERT INTO role VALUES (null,'ADMIN');
INSERT INTO role VALUES (null,'MODERATOR');
INSERT INTO role VALUES (null,'USER');
INSERT INTO role VALUES (null,'EDITOR');

INSERT INTO permission VALUES (null, 'CLIENT');
INSERT INTO permission VALUES (null, 'PRODUCT');
INSERT INTO permission VALUES (null, 'SALE');
INSERT INTO permission VALUES (null, 'ROLE');
INSERT INTO permission VALUES (null, 'USER');

INSERT INTO granted_permission(permission_id, role_id) VALUES (1,1);
INSERT INTO granted_permission(permission_id, role_id) VALUES (2,1);
INSERT INTO granted_permission(permission_id, role_id) VALUES (3,1);
INSERT INTO granted_permission(permission_id, role_id) VALUES (4,1);
INSERT INTO granted_permission(permission_id, role_id) VALUES (5,1);

INSERT INTO granted_permission(permission_id, role_id) VALUES (1,2);
INSERT INTO granted_permission(permission_id, role_id) VALUES (2,2);

INSERT INTO granted_permission(permission_id, role_id) VALUES (3,3);

INSERT INTO user (name, surname, role_id, username, password, account_expired, account_locked, credentials_expired, enabled) VALUES ('Brayan', 'Villanueva', 1, 'braya@gmail.com', '$2a$10$12T8lRTc5na9J.xFbnhb3uWRyRgkui7VEJmjL5cUG2Ya.PrEDr2K.', false, false, false, true);

INSERT INTO user (name, surname, role_id, username, password, account_expired, account_locked, credentials_expired, enabled) VALUES ('Diego', 'Villanueva', 2, 'diego@gmail.com', '$2a$10$12T8lRTc5na9J.xFbnhb3uWRyRgkui7VEJmjL5cUG2Ya.PrEDr2K.', false, false, false, true);

INSERT INTO user (name, surname, role_id, username, password, account_expired, account_locked, credentials_expired, enabled) VALUES ('Walter', 'Villanueva', 3, 'walter@gmail.com', '$2a$10$jJ0gHOM8oXrHg5TVxsQ1beu2YJ3PY1X4AhMpmuHs5dniHYslQrdkC', false, false, false, true);

