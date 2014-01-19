--<ScriptOptions statementTerminator=";"/>

CREATE TABLE contains (
		patientNo INT4 NOT NULL,
		wardNo INT4 NOT NULL,
		admissionDate DATE NOT NULL
	);

CREATE UNIQUE INDEX PK_contains ON contains (null);

CREATE INDEX FKI_contains_ward ON contains (null);

ALTER TABLE contains ADD CONSTRAINT PK_contains PRIMARY KEY (patientNo, wardNo, admissionDate);

ALTER TABLE contains ADD CONSTRAINT FK_contains_patient FOREIGN KEY (patientNo)
	REFERENCES patient (patientNo);

ALTER TABLE contains ADD CONSTRAINT FK_contains_ward FOREIGN KEY (wardNo)
	REFERENCES ward (wardNo);

