 create table User(
 	  id int not null primary key,
      username varchar_ignorecase(50) not null,
      password varchar_ignorecase(100) not null,
      salary float,
      age int
      );
