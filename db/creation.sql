CREATE DOMAIN code_t VARCHAR(32) NOT NULL CHECK(VALUE = UPPER(VALUE) AND LENGTH(VALUE) > 0);
CREATE DOMAIN nullable_code_t VARCHAR(32) CHECK(VALUE = UPPER(VALUE) AND LENGTH(VALUE) > 0);
CREATE DOMAIN sequence_t INTEGER DEFAULT 0 NOT NULL;
CREATE DOMAIN name_t VARCHAR(256) NOT NULL CHECK(LENGTH(VALUE) > 0);
CREATE DOMAIN short_name_t VARCHAR(32) NOT NULL CHECK(LENGTH(VALUE) > 0);
CREATE DOMAIN note_t TEXT;
CREATE DOMAIN email_t VARCHAR(256) NOT NULL CHECK(VALUE LIKE '%@%'); -- Pretty crappy check


CREATE TABLE Packet_Set (
	code code_t PRIMARY KEY,
	name name_t UNIQUE,
	short_name short_name_t UNIQUE,
	deadline DATE,
	note note_t,
	completed BOOLEAN NOT NULL DEFAULT FALSE,
	reuses_questions BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE Packet (
	id SERIAL PRIMARY KEY,
	packet_set_code code_t REFERENCES Packet_Set ON UPDATE CASCADE ON DELETE RESTRICT,
	name name_t,
	short_name short_name_t,
	sequence sequence_t,
	UNIQUE(packet_set_code, name),
	UNIQUE(packet_set_code, short_name),
	UNIQUE(packet_set_code, sequence)
);
ALTER SEQUENCE packet_id_seq RESTART WITH 1000;

CREATE TABLE Question_Type (
	code code_t PRIMARY KEY,
	name name_t UNIQUE,
	short_name short_name_t UNIQUE,
	sequence sequence_t,
	table_name name_t
);
INSERT INTO Section_Type (code, name, short_name, sequence, table_name) VALUES ('TOSSUP', 'Tossup', 'TU', 1);
INSERT INTO Section_Type (code, name, short_name, sequence, table_name) VALUES ('TEAM_QUESTION', 'Team Question', 'TQ', 2);

CREATE TABLE Section (
	id SERIAL PRIMARY KEY,
	packet_id INTEGER NOT NULL REFERENCES Packet ON UPDATE CASCADE ON DELETE RESTRICT,
	section_type_code code_t REFERENCES Section_Type ON UPDATE CASCADE ON DELETE RESTRICT,
	sequence sequence_t,
	UNIQUE(packet_id, sequence)
);
ALTER SEQUENCE section_id_seq RESTART WITH 1000;

CREATE TABLE Category_Group (
	code code_t PRIMARY KEY,
	name name_t UNIQUE,
	short_name short_name_t UNIQUE,
	sequence sequence_t
);
INSERT INTO Category_Group (code, name, short_name, sequence) VALUES ('SCIENCE', 'Science', 'Sci', 1);
INSERT INTO Category_Group (code, name, short_name, sequence) VALUES ('MATH', 'Mathematics', 'Math', 2);
INSERT INTO Category_Group (code, name, short_name, sequence) VALUES ('SOCIAL_STUDIES', 'Social Studies', 'SS', 3);
INSERT INTO Category_Group (code, name, short_name, sequence) VALUES ('LITERATURE', 'Literature', 'Lit', 4);
INSERT INTO Category_Group (code, name, short_name, sequence) VALUES ('FINE_ARTS', 'Fine Arts', 'FA', 5);
INSERT INTO Category_Group (code, name, short_name, sequence) VALUES ('MISCELLANEOUS', 'Miscellaneous', 'Misc', 6);

CREATE TABLE Category (
	code code_t PRIMARY KEY,
	name name_t UNIQUE,
	short_name short_name_t UNIQUE,
	sequence sequence_t,
	category_group_code code_t REFERENCES Category_Group ON UPDATE CASCADE ON DELETE RESTRICT
);
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('BIOLOGY', 'Biology', 'Bio', 1, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('CHEMISTRY', 'Chemistry', 'Chem', 2, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('PHYSICS', 'Physics', 'Phys', 3, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ASTRONOMY', 'Astronomy', 'Astro', 4, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ENVIRONMENTAL_SCIENCE', 'Environmental Science', 'Enviro', 5, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('EARTH_SCIENCE', 'Earth Science', 'ES', 6, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('HEALTH', 'Health', 'Health', 7, 'SCIENCE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('MATH_CONCEPTS', 'Math Concepts', 'Noncomp', 1, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ALGEBRA', 'Algebra', 'Alg', 2, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('GEOMETRY', 'Geometry', 'Geom', 3, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('TRIGONOMETRY', 'Trigonometry', 'Trig', 4, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ANALYTIC_GEOMETRY', 'Analytic Geometry', 'AGeo', 5, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('PRECALCULUS', 'Pre-Calculus', 'Precalc', 6, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('PROBABILITY', 'Probability', 'Prob', 7, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('STATISTICS', 'Statistics', 'Stat', 8, 'MATH');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('US_HISTORY', 'U.S. History', 'USHist', 1, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('WORLD_HISTORY', 'World History', 'WHist', 2, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('GEOGRAPHY', 'Geography', 'Geog', 3, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('CURRENT_EVENTS', 'Current Events', 'CE', 4, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('US_GOVERNMENT', 'U.S. Government', 'Gov', 5, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('PSYCHOLOGY', 'Psychology', 'Psych', 6, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('RELIGION', 'Religion', 'Rel', 7, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ECONOMICS', 'Economics', 'Econ', 8, 'SOCIAL_STUDIES');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('US_LITERATURE', 'U.S. Literature', 'USLit', 1, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('BRITISH_LITERATURE', 'British Literature', 'BritLit', 2, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('WORLD_LITERATURE', 'World Literature', 'WLit', 3, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('MYTHOLOGY', 'Mythology', 'Myth', 4, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('GRAMMAR_USAGE', 'Grammar/Usage', 'Grammar', 5, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('SPELLING', 'Spelling', 'Spell', 6, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('SPEECH', 'Speech', 'Speech', 7, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('VOCABULARY', 'Vocabulary', 'Vocab', 8, 'LITERATURE');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ART_HISTORY', 'Art History', 'ArtHist', 1, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('MUSICAL_THEATRE', 'Musical Theatre', 'Musicals', 2, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('MUSIC_THEORY', 'Music Theory', 'MusicTh', 3, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('ART_THEORY', 'Art Theory & Technique', 'ArtTh', 4, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('JAZZ', 'Jazz', 'Jazz', 5, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('CLASSICAL_MUSIC_OPERA', 'Classical Music & Opera', 'Music', 6, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('MODERN_COMPOSERS', 'Composers of the Modern Era', 'ModMusic', 7, 'FINE_ARTS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('JOURNALISM', 'Journalism', 'Journ', 1, 'MISCELLANEOUS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('SPORTS', 'Sports', 'Sports', 2, 'MISCELLANEOUS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('AGRICULTURE', 'Agriculture', 'Ag', 3, 'MISCELLANEOUS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('INDUSTRIAL_ARTS', 'Industrial Arts', 'IndArt', 4, 'MISCELLANEOUS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('TECHNOLOGY', 'Technology', 'Tech', 5, 'MISCELLANEOUS');
INSERT INTO Category (code, name, short_name, sequence, category_group_code) VALUES ('CONSUMER_EDUCATION', 'Consumer Education', 'ConsEd', 6, 'MISCELLANEOUS');

CREATE TABLE Question (
	id SERIAL PRIMARY KEY,
	category_code code_t REFERENCES Category ON UPDATE CASCADE ON DELETE RESTRICT,
	label name_t,
	question_status_code code_t DEFAULT 'DRAFTED' REFERENCES Question_Status ON UPDATE CASCADE ON DELETE RESTRICT,
	internal_note note_t,
	external_note note_t,
	finalized BOOLEAN NOT NULL DEFAULT FALSE,
	question_type_code code_t REFERENCES Question_Type ON UPDATE CASCADE ON DELETE RESTRICT,
	intended_packet_set_code nullable_code_t REFERENCES Packet_Set ON UPDATE CASCADE ON DELETE RESTRICT
);
ALTER SEQUENCE question_id_seq RESTART WITH 1000;

CREATE TABLE Question_Status (
	code code_t PRIMARY KEY,
	name name_t UNIQUE,
	short_name short_name_t UNIQUE,
	sequence sequence_t
);
INSERT INTO Question_Status (code, name, short_name, sequence) VALUES
('ANSWER_CHOSEN', 'Answer Chosen', 'Answer', 100),
('DRAFTED', 'Drafted', 'Draft', 200),
('READY_FOR_REVIEW', 'Ready for Review', 'Review', 300),
('APPROVED', 'Approved', 'Approved', 400);


CREATE TABLE Tossup (
	question_id INTEGER PRIMARY KEY REFERENCES Question ON UPDATE CASCADE ON DELETE CASCADE,
	text TEXT NOT NULL,
	answer TEXT NOT NULL
);

CREATE TABLE Team_Question (
	question_id INTEGER PRIMARY KEY REFERENCES Question ON UPDATE CASCADE ON DELETE CASCADE,
	introduction TEXT NOT NULL,
	part_1_text TEXT NOT NULL,
	part_1_answer TEXT NOT NULL,
	part_2_text TEXT NOT NULL,
	part_2_answer TEXT NOT NULL,
	part_3_text TEXT NOT NULL,
	part_3_answer TEXT NOT NULL
);

CREATE TABLE Placement (
	id SERIAL PRIMARY KEY,
	section_id INTEGER NOT NULL REFERENCES Section ON UPDATE CASCADE ON DELETE RESTRICT,
	category_code code_t REFERENCES Category ON UPDATE CASCADE ON DELETE RESTRICT,
	sequence sequence_t,
	question_id INTEGER REFERENCES Question ON UPDATE CASCADE ON DELETE RESTRICT,
	UNIQUE(section_id, sequence),
	UNIQUE(section_id, question_id)
);
CREATE INDEX placement_question_index ON Placement (question_id);
ALTER SEQUENCE placement_id_seq RESTART WITH 1000;

CREATE TABLE Account (
	id SERIAL PRIMARY KEY,
	name VARCHAR(256) UNIQUE NOT NULL,
	email_address email_t,
	username VARCHAR(64) UNIQUE NOT NULL,
	password_hash CHAR(60) NOT NULL DEFAULT '$2a$16$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX',
	administrator BOOLEAN NOT NULL DEFAULT FALSE,
	active BOOLEAN NOT NULL DEFAULT TRUE
);
ALTER SEQUENCE account_id_seq RESTART WITH 1000;
INSERT INTO Account (name, email_address, username, password_hash, administrator, active) VALUES ('Jonah Greenthal', 'jonah@jonahgreenthal.com', 'jonah', '$2a$12$oCi.fatQsn54TyU3bjYpMuZV3b3mliOok0X0kSJ1uBLd3VuINhV1C', true, true);


CREATE VIEW Web_Login AS
SELECT username, password_hash
FROM Account
WHERE active = TRUE;

CREATE VIEW Web_Roles AS 
	SELECT username, 'ADMINISTRATOR' AS role
	FROM Account
	WHERE active = true AND administrator = true
UNION ALL
	SELECT username, 'LOGIN' AS role
	FROM Account
	WHERE active = true
;
