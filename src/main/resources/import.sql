delete from animal;
delete from category;
delete from product;
delete from product_info;

insert into animal(id, name) values(1, 'Cats');
insert into animal(id, name) values(2, 'Dogs');

insert into category(id, name) values(1, 'Dry Food');
insert into category(id, name) values(2, 'Wet Food');
insert into category(id, name) values(3, 'Toys');
insert into category(id, name) values(4, 'Beds');
insert into category(id, name) values(5, 'Treats');

insert into product(id, name, price, quantity, animal_id, category_id) values(1, 'Chappie Complete Chicken Dry Dog Food - 15kg ', 20, 50, 2, 1);
insert into product(id, name, price, quantity, animal_id, category_id) values(2, 'Iams Adult Small & Medium Chicken Dry Dog Food - 12kg', 22, 50, 2, 1);
insert into product(id, name, price, quantity, animal_id, category_id) values(3, 'Pro Plan Light Weight Management Adult Turkey Dry Cat Food - 10kg ', 15, 100, 1, 1);
insert into product(id, name, price, quantity, animal_id, category_id) values(4, 'Orijen 6 Fish Dry Cat Food - 5.4kg', 8, 90, 1, 1);

insert into product_info(id, description, product_id) values(1, "The best food for your dog", "static/logo.j pg", 1);
insert into product_info(id, description, product_id) values(2, "The best food for your dog", 2);

# INSERT INTO role VALUES (1,'SUPER_USER','This user has ultimate rights for everything');
# INSERT INTO role VALUES (1,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO role VALUES (1,'ADMIN_USER','This user has all rights');
INSERT INTO role VALUES (2,'SITE_USER','This user has access to site, after login - normal user');

insert into users (id,first_name,last_name,email,password) values (1,'Andra','Tomi','andratomi@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i');
insert into user_role (user_id, role_id) values ('1','1');
insert into user_role (user_id, role_id) values ('1','2');
insert into user_role (user_id, role_id) values ('1','3');
