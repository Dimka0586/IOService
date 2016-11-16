create table sensor (id int not null auto_increment primary key, name varchar(20) not null,
value float not null);
create table sensor_values(sensor_id not null, value float not null, forign key (sensor_id) references sensor(id));