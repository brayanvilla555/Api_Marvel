INSERT INTO client(name, lastname, identification_type, identification_number, state_client) Values ('Sayra', 'Reyes', 'DNI', '12345678','ACTIVO');
INSERT INTO client(name, lastname, identification_type, identification_number, state_client) Values ('Pedro', 'Vargas', 'DNI', '12345678','ACTIVO');

INSERT INTO product(name, description, price, stock) Values ('Lego', 'Muy bueno', 10.5, 90);
INSERT INTO product(name, description, price, stock) Values ('Dc', 'Muy bueno', 10.5, 90);
INSERT INTO product(name, description, price, stock) Values ('Marvel', 'Muy bueno', 10.5, 90);
INSERT INTO product(name, description, price, stock) Values ('Pocoyo', 'Muy bueno', 10.5, 90);
INSERT INTO product(name, description, price, stock) Values ('Bop el constructor', 'Muy bueno', 10.5, 90);



INSERT INTO sale(client_id, state, price) Values (1, 'ACEPTADO', 10.5);
INSERT INTO sale(client_id, state, price) Values (1, 'ACEPTADO', 10.5);




INSERT INTO role VALUES (null,'ADMIN');
INSERT INTO role VALUES (null,'CUSTOMER');
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

INSERT INTO user (firstname, lastname, role_id, username, password, account_expired, account_locked, credentials_expired, enabled) VALUES ('Brayan', 'Villanueva', 1, 'braya@gmail.com', '$2a$10$12T8lRTc5na9J.xFbnhb3uWRyRgkui7VEJmjL5cUG2Ya.PrEDr2K.', false, false, false, true);

INSERT INTO user (firstname, lastname, role_id, username, password, account_expired, account_locked, credentials_expired, enabled) VALUES ('Diego', 'Villanueva', 2, 'diego@gmail.com', '$2a$10$12T8lRTc5na9J.xFbnhb3uWRyRgkui7VEJmjL5cUG2Ya.PrEDr2K.', false, false, false, true);

INSERT INTO user (firstname, lastname, role_id, username, password, account_expired, account_locked, credentials_expired, enabled) VALUES ('Walter', 'Villanueva', 3, 'walter@gmail.com', '$2a$10$jJ0gHOM8oXrHg5TVxsQ1beu2YJ3PY1X4AhMpmuHs5dniHYslQrdkC', false, false, false, true);



INSERT INTO detail_sale(product_id, sale_id, amount) Values (1, 1, 10.5);
INSERT INTO detail_sale(product_id, sale_id, amount) Values (1, 1, 10.5);
INSERT INTO detail_sale(product_id, sale_id, amount) Values (1, 1, 10.5);
INSERT INTO detail_sale(product_id, sale_id, amount) Values (1, 1, 10.5);
INSERT INTO detail_sale(product_id, sale_id, amount) Values (1, 1, 10.5);
INSERT INTO detail_sale(product_id, sale_id, amount) Values (1, 1, 10.5);