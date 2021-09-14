DROP TABLE IF EXISTS students, teachers, subjects, exam_results;

CREATE TABLE IF NOT EXISTS students (
  id BIGSERIAL PRIMARY KEY,
  created DATE NOT NULL,
  updated DATE NOT NULL,
  name VARCHAR(50),
  surname VARCHAR(50),
  birth_date DATE,
  phone_number VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS teachers (
  id BIGSERIAL PRIMARY KEY,
  created DATE NOT NULL,
  updated DATE NOT NULL,
  name VARCHAR(50),
  surname VARCHAR(50),
  birth_date DATE,
  title VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS subjects (
  id BIGSERIAL PRIMARY KEY,
  created DATE NOT NULL,
  updated DATE NOT NULL,
  name VARCHAR(50),
  teacher_id BIGINT REFERENCES teachers(id) ON DELETE RESTRICT
);


CREATE TABLE IF NOT EXISTS exam_results (
  id BIGSERIAL PRIMARY KEY,
  created DATE NOT NULL,
  updated DATE NOT NULL,
  subject_id BIGINT REFERENCES subjects(id) ON DELETE CASCADE,
  student_id BIGINT REFERENCES students(id) ON DELETE CASCADE,
  mark INTEGER
);