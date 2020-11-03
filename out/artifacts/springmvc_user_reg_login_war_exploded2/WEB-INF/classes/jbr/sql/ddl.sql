CREATE DATABASE IF NOT EXISTS springmvc;

USE springmvc;

DROP TABLE IF EXISTS `springmvc`.`users`;

CREATE TABLE `users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));

create table `product_category`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`category_name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`)
)AUTO_INCREMENT=1;




create table `product`(
`product_id` int(11) NOT NULL,

`manufacturer` VARCHAR(45) NOT NULL,
`series` varchar (255) DEFAULT NULL,
`model` varchar (255) DEFAULT NULL,

`use_type` varchar (255) DEFAULT NULL,
`application` varchar (255) DEFAULT NULL,
`mounting_loc` varchar (255) DEFAULT NULL,
`accessories` varchar (255) DEFAULT NULL,
`model_year` int(11) DEFAULT NULL,

`airflow` int(11) DEFAULT NULL,
`power_min` float DEFAULT NULL,
`power_max` float DEFAULT NULL,
`voltage_min` int(11) DEFAULT NULL,
`voltage_max` int(11) DEFAULT NULL,
`fanspeed_min` int(11) DEFAULT NULL,
`fanspeed_max` int(11) DEFAULT NULL,
`no_of_speed` int(11) DEFAULT NULL,
`sound` int(11) DEFAULT NULL,
`fan_diameter` int(11) DEFAULT NULL,
`height_min` float DEFAULT NULL,
`height_max` int(11) DEFAULT NULL,
`weight` float DEFAULT NULL,

`past_specs` varchar (255) DEFAULT NULL,
`details` varchar (255) DEFAULT NULL,
`document` varchar (255) DEFAULT NULL,
`contact` varchar (255) DEFAULT NULL,
`category_id` int(11),
PRIMARY KEY (`product_id`),
CONSTRAINT category1 FOREIGN KEY (category_id) REFERENCES product_category(id)
);

create table `description`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`manufacturer` varchar (255) DEFAULT NULL,
`series` varchar (255) DEFAULT NULL,
`model` varchar (255) DEFAULT NULL,
`product_id` int(11),
PRIMARY KEY (`id`),
CONSTRAINT description1 FOREIGN KEY (product_id) REFERENCES product(product_id)
)AUTO_INCREMENT=1;

insert into product values(1,'Emerson', 'Luray Eco Series', 'CF860',
'Commercial','Indoor','Roof','With Light',2014,
8500,2.85,33,100,240,46,240,6,40,60,13,55,13.5
,'0 firm / 1297 global','Emerson details','Emerson document','Emerson contact',1);

insert into product values(2,'Minka', 'Aviation Series', 'F853-RW',
'Commercial','Indoor','Roof','Without Light',2015,
6604,3.69,25.92,100,240,60,240,7,36,60,12,56,12.5
,'10 firm / 1492 global','Minka details','Minka document','Minka contact',1);

insert into product values(3,'Westinghouse', 'Industrial Ceiling Fan', '78003',
'Commercial','Indoor','Roof','Without Light',2015,
6846,2.55,60,100,240,60,240,10,48,56,15,65,15
,'8 firm / 1132 global','Westinghouse details','Westinghouse document','Westinghouse contact',1);

insert into product values(4,'Big Ass','Haiku H Series','S3150-S0-BC-04-01-C-01',
'Commercial','Indoor','Roof','With Light',2016,
5467,1.95,21.14,100,240,35,200,7,35,60,12.3,57,13
,'4 firm / 838 global','Big Ass details','Big Ass document','Big Ass contact',1);

insert into product values(7,'Ecosmart', 'Aviation Series', 'CF865',
'Commercial','Indoor','Roof','With Light',2016,
8500,2.85,33,100,240,46,240,6,40,60,13,55,13.5
,'0 firm / 1297 global','Ecosmart details','Ecosmart document','Ecosmart contact',4);

insert into product values(8,'Emerson', 'Luray Eco Series', 'F860',
'Commercial','Indoor','Roof','Without Light',2014,
6604,3.69,25.92,100,240,60,240,7,36,60,12,56,12.5
,'10 firm / 1492 global','Emerson details','Emerson document','Emerson contact',4);



insert into product_category(category_name) values('HVAC Fans');
insert into product_category(category_name) values('H Fans');
insert into product_category(category_name) values('category2');


insert into description(manufacturer, series, model, product_id) values('Big Ass','Haiku H','S100',1);
insert into description(manufacturer, series, model, product_id) values('Emerson','Luray Eco','S101',2);
insert into description(manufacturer, series, model, product_id) values('White Light','Series1','S102',3);
insert into description(manufacturer, series, model, product_id) values('Yellow Light','Series2','S103',4);


select manufacturer, series, model from product p inner join description d on p.product_id = d.product_id;
select manufacturer, series, model from product p inner join description d on p.product_id = d.product_id where p.product_id=1;

select product_id, product_name, details, document, contact from product_category c inner join product p on c.id = p.category_id;
select product_id, product_name, details, document, contact from product_category c inner join product p on c.id = p.category_id where category_name="HVAC Fans";
