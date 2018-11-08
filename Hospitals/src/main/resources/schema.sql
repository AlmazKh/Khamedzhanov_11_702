CREATE  TABLE hospital (
  id BIGINT,
  address VARCHAR(20),
  phone VARCHAR(20),
  procedure_id BIGINT
);

CREATE TABLE procedure (
  id BIGINT,
  name VARCHAR(20),
  price INT,
  hospital_id BIGINT
);

CREATE TABLE doctor (
  id BIGINT,
  phone VARCHAR(20),
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  rating INT,
  hospital_id BIGINT,
  procedure_id BIGINT
);

CREATE TABLE patient (
  id BIGINT,
  phone VARCHAR(20),
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  gender VARCHAR(1),
  polis_id BIGINT,
  reception_id BIGINT
);

CREATE TABLE polis (
  id BIGINT,
  number INT,
  insurance_company VARCHAR(40),
  patient_id BIGINT
);

CREATE TABLE reception (
  id BIGINT,
  cabinet_number INT,
  time VARCHAR(20),
  doctor_id BIGINT,
  polis_id BIGINT
);

CREATE TABLE hospital_proceduce (
  id BIGINT,
  hospital_id BIGINT,
  procedure_id BIGINT
);

ALTER TABLE hospital ADD CONSTRAINT pk_hospital PRIMARY KEY (id);
ALTER TABLE procedure ADD CONSTRAINT pk_procedure PRIMARY KEY (id);
ALTER TABLE doctor ADD CONSTRAINT pk_doctor PRIMARY KEY (id);
ALTER TABLE patient ADD CONSTRAINT pk_patient PRIMARY KEY (id);
ALTER TABLE polis ADD CONSTRAINT pk_polis PRIMARY KEY (id);
ALTER TABLE reception ADD CONSTRAINT pk_reception PRIMARY KEY (id);
ALTER TABLE hospital_proceduce ADD CONSTRAINT pk_hospital_procedure PRIMARY KEY (id);

ALTER TABLE hospital_proceduce ADD CONSTRAINT fk_hospital_procedure FOREIGN KEY (procedure_id)
  REFERENCES procedure(id) ON DELETE CASCADE;
ALTER TABLE hospital_proceduce ADD CONSTRAINT fk_procedure_hospital FOREIGN KEY (hospital_id)
  REFERENCES hospital(id) ON DELETE CASCADE;
ALTER TABLE doctor ADD CONSTRAINT fk_doctor_hospital FOREIGN KEY (hospital_id)
  REFERENCES hospital(id);
ALTER TABLE doctor ADD CONSTRAINT fk_doctor_procedure FOREIGN KEY (procedure_id)
  REFERENCES procedure(id);
ALTER TABLE patient ADD CONSTRAINT fk_patient_polis FOREIGN KEY (polis_id)
  REFERENCES polis(id);
ALTER TABLE patient ADD CONSTRAINT fk_patient_reception FOREIGN KEY (reception_id)
  REFERENCES reception(id);
ALTER TABLE polis ADD CONSTRAINT fk_polis_patient FOREIGN KEY (patient_id)
  REFERENCES patient(id);
ALTER TABLE reception ADD CONSTRAINT fk_reception_doctor FOREIGN KEY (doctor_id)
  REFERENCES doctor(id);
ALTER TABLE reception ADD CONSTRAINT fk_reception_polis FOREIGN KEY (polis_id)
REFERENCES polis(id);

ALTER TABLE doctor ADD COLUMN password_hash VARCHAR(70);
ALTER TABLE patient ADD COLUMN password_hash VARCHAR(70);

CREATE table auth (
  id BIGSERIAL primary key,
  user_id bigint,
  cookie_value varchar(100)
);

CREATE SEQUENCE doctor_seq
  increment by 2
  cache 10
  owned by doctor.id;

CREATE SEQUENCE patient_seq
  increment by 5
  cache 10
  owned by patient.id;

SELECT setval('doctor_seq', max(id)) FROM doctor;
SELECT setval('patient_seq', max(id)) FROM patient;
ALTER TABLE doctor ALTER COLUMN id SET DEFAULT nextval('doctor_seq');
ALTER TABLE patient ALTER COLUMN id SET DEFAULT nextval('patient_seq');




