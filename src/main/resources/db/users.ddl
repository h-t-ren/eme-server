
create table users(
    username varchar(50) not null primary key,
    password varchar(80) not null,
    enabled boolean not null default true
);


create table groups(
    id int(11) primary key auto_increment,
    group_name varchar(50) not null
);

create table group_authorities(
    group_id int(11) not null,
    authority varchar(50) not null,

    constraint fk_group_authorities_groups foreign key(group_id) references groups(id)
);

create table group_members(
    id int(11) primary key auto_increment,
    username varchar(50) not null,
    group_id int(11) not null,

    constraint fk_group_members_groups foreign key(group_id) references groups(id)
);

create table persistent_logins(
    username varchar(50) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);

insert into users(username, password, enabled) values ('clong', '532bf9d4d3213a14d232f3a548a0cf1aa47fbf105ee7896175587c109e9663522df0cdf9efd5fd97', true);
insert into users(username, password, enabled) values ('admin', '83ed8f60f97d7f1cc03fc583553ad1f71d6db79d2a8b613dc9493f1923c92b27204529dcf21b0877', true);

insert into groups(group_name) values ('User');
insert into groups(group_name) values ('Administrator');

insert into group_authorities(group_id, authority) select id, 'ROLE_USER' from groups where group_name='User';
insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Administrator';
insert into group_authorities(group_id, authority) select id, 'ROLE_ADMIN' from groups where group_name='Administrator';

insert into group_members(username, group_id) select 'clong', id from groups where group_name='User';
insert into group_members(username, group_id) select 'admin', id from groups where group_name='Administrator';