CREATE TABLE users
  (
    userid   NUMBER(10) NOT NULL,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR2(50) NOT NULL,
    name VARCHAR2(50),
    CONSTRAINT users_pk PRIMARY KEY (userid)
  );

CREATE SEQUENCE users_seq MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 10 NOORDER NOCYCLE;
CREATE OR REPLACE TRIGGER users_trg BEFORE
INSERT ON users FOR EACH ROW BEGIN <<COLUMN_SEQUENCES>>
  BEGIN IF INSERTING
           AND :NEW.userid IS NULL THEN
    SELECT users_seq.NEXTVAL INTO :NEW.userid FROM SYS.DUAL;
  END IF;
  END COLUMN_SEQUENCES;
END;

CREATE TABLE categories
(
  categoryid   NUMBER(10) NOT NULL,
  categoryname VARCHAR2(50) NOT NULL,
  CONSTRAINT categories_pk PRIMARY KEY (categoryid)
);

CREATE TABLE expenses
(
  expenseid   NUMBER(10) NOT NULL,
  amount      NUMBER(6) NOT NULL,
  expensedate DATE NOT NULL,
  name        VARCHAR2(50),
  categoryid  NUMBER(10),
  place       VARCHAR2(50),
  userid      NUMBER(10) NOT NULL,
  CONSTRAINT expenses_pk PRIMARY KEY (expenseid),
  CONSTRAINT users_fk FOREIGN KEY (userid) REFERENCES users(userid),
  CONSTRAINT categories_fk FOREIGN KEY (categoryid) REFERENCES categories(categoryid)
);
