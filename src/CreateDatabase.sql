/* To change password run command: call SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.Group9', '1234')*/
DROP TABLE "CUSTOMERS";
DROP TABLE "CHARGINGSTATS";

CREATE TABLE "CUSTOMERS" 
(
   "UID" varchar (30) NOT NULL,
   "firstName" varchar (20) NOT NULL,
   "lastName" varchar (30) NOT NULL,
   "email" varchar (30) NOT NULL,
   PRIMARY KEY ("UID")
);

CREATE TABLE "CHARGINGSTATS" 
(
   "TAID" INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   "started" varchar (30) NOT NULL,
   "stopped" varchar (30) NOT NULL,
   "duration" INT NOT NULL,
   "UID" varchar (30) NOT NULL,
   PRIMARY KEY ("TAID"),
   FOREIGN KEY ("UID") REFERENCES "CUSTOMERS" ("UID")
);
/*
CREATE TABLE "authorISBN" (
   "authorID" INT NOT NULL,
   "isbn" varchar (20) NOT NULL,
   FOREIGN KEY ("authorID") REFERENCES "authors" ("authorID"), 
   FOREIGN KEY ("isbn") REFERENCES "titles" ("isbn")
);
*/
INSERT INTO "CUSTOMERS" ("UID","firstName", "lastName","email")
VALUES 
   ('F561A25C','Harvey','Deitel','Harvey@car.com'),
   ('F561A212','Paul','Deitel','Paul@gmail.com'), 
   ('F561A789','Andrew','Goldberg','andrew@goldberg.com'),
   ('F561A007','David','Choffnes','mr.choffins@yahoo.com');

INSERT INTO "CHARGINGSTATS" ("started","stopped","duration","UID")
VALUES
   ('2014-03-25 14:55:33','2014-03-25 15:55:33',1,'F561A25C'),
   ('2014-03-25 14:55:33','2014-03-26 15:55:33',24,'F561A25C'),
   ('2014-03-25 14:55:33','2014-03-25 16:25:33',1.5,'F561A25C');

/*INSERT INTO "authorISBN" ("authorID","isbn")
VALUES
   (1,'0131869000'),
   (2,'0131869000'),
   (1,'0131525239'),
   (2,'0131525239'),
   (1,'0132222205'), 
   (2,'0132222205'), 
   (1,'0131857576'),
   (2,'0131857576'),
   (1,'0132404168'),
   (2,'0132404168'),
   (1,'0131450913'),
   (2,'0131450913'),
   (3,'0131450913'),
   (1,'0131828274'),
   (2,'0131828274'),
   (4,'0131828274');
*/