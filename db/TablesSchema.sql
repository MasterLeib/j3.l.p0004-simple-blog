create table Users(
	email nvarchar(50) primary key, 
	name nvarchar(50) not null,
	[password] nvarchar(64) not null,
	[role] nvarchar(50) not null,
	[status] bit not null
)
create table Articles(
	id int IDENTITY(1,1) PRIMARY KEY,
	title nvarchar(50) not null,
	short_description nvarchar(max) not null,
	email nvarchar(50) not null foreign key references Users(email),
	content nvarchar(max) not null,
	date datetime not null,
	status bit not null
)
create table Comments(
	id int IDENTITY(1,1) PRIMARY KEY,
	email nvarchar(50) not null foreign key references Users(email),
	article_id int not null foreign key references Articles(id),
	[content] nvarchar(50) not null
)