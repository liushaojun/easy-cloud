drop table if exists product_info;

create table product_info (
	id bigint generated by default as identity,
	product_name varchar(64) not null,
	remark varchar(256),
	price decimal(18,6) not null,
	status smallint ,
	create_at timestamp not null default current_timestamp,
	update_at timestamp not null default current_timestamp,
    primary key (id)
);