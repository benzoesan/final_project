insert into customers(firstName, lastName, email, phone)
values ('Mikołaj', 'Kot', 'kotm@wp.pl', 880897678);
insert into customers(firstName, lastName, email, phone)
values ('Weronika', 'Bułka', 'bułkaw@wp.pl', 678897655);
insert into products(price, purchaseDate, id, salesDocumentNumber, description, name, produceCode, salesDocumentType)
values (29.99,'25.04.2022',8,12336678,'brak','koszulka','1234Q-00X-M','paragon') ;
insert into complaints(dateOfComplaint, dateOfDefect, dateOfDetermination, customer_id, id, product_id, advertiserExpectations, comments, defectDescription, state, typeOfDamage)
                VALUES ('23.03.2023','23.04.2022','05.04.2023',1,4,1,'wymiana','brak uwag','brak guzika','w toku','prucie,przecieranie');


INSERT INTO roles (`id`, `name`) VALUES (NULL, 'USER');
INSERT INTO roles (`id`, `name`) VALUES (NULL, 'ADMIN');