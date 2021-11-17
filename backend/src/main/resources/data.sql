insert into role (name) values ('kandidat');
insert into role (name) values ('tehnicko lice');
insert into role (name) values ('hr lice');
insert into role (name) values ('zaposleni u sluzbi nabavke');
insert into role (name) values ('dobavljac');

insert into advertisement (title, description) values ('title 1', 'description 1');
insert into advertisement (title, description) values ('title 2', 'description 2');
insert into advertisement (title, description) values ('title 3', 'description 3');

insert into user_table (email, password, role_id)
values ('kandidat@gmail.com', '$2a$10$aL2cRpbMvSsvTcIGxUoauO4RMefDmYtEEARsmKJpwJ7T585HfBsra', 1);
insert into user_table (email, password, role_id)
values ('hr@gmail.com', '$2a$10$aL2cRpbMvSsvTcIGxUoauO4RMefDmYtEEARsmKJpwJ7T585HfBsra', 3);
