insert into user_details (id, birth_date, name)
values
	(10001,current_date(), 'Ranga'),
	(10002,current_date(), 'Ravi');
	
	insert into post(id,description,user_id)
	values 
	(20001, 'I want to learn AWS', 10001),
	(20002, 'I want to learn DevOps', 10001),
	(20003, 'I want to learn Azure', 10001),
	(20004, 'I want to learn Google Cloud', 10001);