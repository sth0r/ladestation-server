/* To change password run command: call SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.Group9', '1234')*/
DROP TABLE "CHARGINGSTATS";
DROP TABLE "CUSTOMERS";
DROP TABLE "PRICESES";

CREATE TABLE "CUSTOMERS" 
(
    "UID" varchar (20),
    "FIRSTNAME" varchar (20),
    "LASTNAME" varchar (30),
    "BALANCE" float (20),
    "CREDITLIMIT" float (20),
    "EMAIL" varchar (30),
    "TLF" varchar (20),
    "PASSWORD" varchar (20),
   PRIMARY KEY ("UID")
);
   
CREATE TABLE "CHARGINGSTATS" 
(
   "TAID" INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   "STARTED" varchar (20),
   "STOPPED" varchar (20),
   "DURATION" varchar (20),
   "UID" varchar (20),
   PRIMARY KEY ("TAID"),
   FOREIGN KEY ("UID") REFERENCES "CUSTOMERS" ("UID")
);

CREATE TABLE "PRICESES" 
(
    "PLACE" varchar (30) NOT NULL,
    "PRICE" double NOT NULL,
   PRIMARY KEY ("PLACE")
);

INSERT INTO "CUSTOMERS" ("UID","FIRSTNAME", "LASTNAME","BALANCE","CREDITLIMIT","EMAIL","TLF","PASSWORD")
VALUES 
   ('F561A25C','Harvey','Deitel',100,1000,'Harvey@car.com','18771556','1234'),
   ('7B503FD7','Paul','Deitel',200,100,'Paul@gmail.com','28771556','1234'), 
   ('F561A789','Andrew','Goldberg',300,10,'andrew@goldberg.com','38771556','1234'),
   ('F561A007','David','Choffnes',400,100,'mr.choffins@yahoo.com','48771556','1234');

INSERT INTO "CHARGINGSTATS" ("STARTED","STOPPED","DURATION","UID")
VALUES
   ('2014-03-25 14:55:33','2014-03-25 15:55:33','1','F561A25C'),
   ('2014-03-25 14:55:33','2014-03-26 15:55:33','24','F561A25C'),
   ('2014-03-25 14:55:33','2014-03-25 16:25:33','15','F561A25C');

INSERT INTO "PRICESES" ("PLACE","PRICE")
VALUES
   ('Copenhagen',0.47);

/*
CREATE TABLE "authorISBN" (
   "authorID" INT NOT NULL,
   "isbn" varchar (20) NOT NULL,
   FOREIGN KEY ("authorID") REFERENCES "authors" ("authorID"), 
   FOREIGN KEY ("isbn") REFERENCES "titles" ("isbn")
);
*/

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