create table sensor (id int not null auto_increment, name varchar(20) not null, primary key(id), unique key(name));
create table sensor_values(id int not null auto_increment, sensor_id int not null, value float not null,
primary key (id), foreign key (sensor_id) references sensor(id));
create table vgd (id int not null auto_increment, name varchar(20) not null, primary key(id), unique key(name));
create table vgd_values (id int not null auto_increment, vgd_id int not null, open boolean notnull,
opened boolean not null, closed boolean not null, time_open time not null, time_close time not null,
alarm_open boolean not null, alarm_close boolean not null, primary key (id), foreign key (vgd_id) references vgd(id));