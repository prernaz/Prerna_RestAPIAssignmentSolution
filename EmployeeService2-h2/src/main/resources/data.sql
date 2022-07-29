INSERT INTO roles VALUES(1,'ADMIN'); 
-- INSERT INTO roles VALUES(2,'USER'); 
INSERT INTO users VALUES(1,'$2a$12$G2y2lSXBgVixlA4/RYwFoezzbiM.w9MWkJs3tOOxb/XuHcwP/uSw.', 'ADMIN'); 
-- INSERT INTO users VALUES(2,'$2a$12$G2y2lSXBgVixlA4/RYwFoezzbiM.w9MWkJs3tOOxb/XuHcwP/uSw.','USER1');
-- INSERT INTO users VALUES(3,'$2a$12$G2y2lSXBgVixlA4/RYwFoezzbiM.w9MWkJs3tOOxb/XuHcwP/uSw.','USER2');

 INSERT INTO users_roles VALUES(1,1); 
-- INSERT INTO users_roles VALUES(1,2);
-- INSERT INTO users_roles VALUES(2,2); 
-- INSERT INTO users_roles VALUES(3,2);
 
INSERT INTO employee (first_name, last_name, email)
VALUES ('sunita' ,'sharma', 'Sunita@sharma.com');
INSERT INTO employee (first_name, last_name, email)
VALUES ('anita' ,'gupta', 'anita@gupta.com');
INSERT INTO employee (first_name, last_name, email)
VALUES ('hema' ,'chowdary', 'hema@chow.com');
INSERT INTO employee (first_name, last_name, email)
VALUES ('deepika' ,'bhave', 'deepika@bhave.com');

-- INSERT INTO roles (role_id,name) VALUES(1,'ADMIN'); 
-- INSERT INTO roles (role_id,name) VALUES(2,'USER'); 
-- INSERT INTO users (User_id, password, user_name) VALUES(1,'$2a$12$G2y2lSXBgVixlA4/RYwFoezzbiM.w9MWkJs3tOOxb/XuHcwP/uSw.', 'ADMIN'); 
-- INSERT INTO users (User_id, password, user_name) VALUES(2,'$2a$12$G2y2lSXBgVixlA4/RYwFoezzbiM.w9MWkJs3tOOxb/XuHcwP/uSw.','USER1');
-- INSERT INTO users (User_id, password, user_name) VALUES(3,'$2a$12$G2y2lSXBgVixlA4/RYwFoezzbiM.w9MWkJs3tOOxb/XuHcwP/uSw.','USER2');
