create table if not exists users
(
    id           int auto_increment primary key,
    name         varchar(45),
    username     varchar(45),
    age          INT,
    email        varchar(45),
    password     varchar(255),
    phone_number varchar(45),
    avatar       varchar(45),
    account_type varchar(45)
);
insert into users (name, username, age, email, password, phone_number, avatar, account_type)
values ('Patrik Bateman', 'patrik123', 30, 'patrik@mail.com', 'qwerty123', '123-456', 'patrik.png', 'employer'),
       ('Jane Doe', 'jane_d', 28, 'jane@mail.com', 'qwerty456', '987-654', 'jane.jpg', 'applicant');

create table if not exists resumes
(
    id           int auto_increment primary key,
    applicant_id INT,
    name         varchar(45),
    category_id  INT,
    salary       FLOAT,
    is_active    BOOLEAN,
    created_date DATE,
    update_date  DATE
);
insert into resumes (applicant_id, name, category_id, salary, is_active, created_date, update_date)
values (1, 'Junior Java Developer Resume', 3, 60000.0, true, '2025-07-01', '2025-07-10'),
       (1, 'Fullstack Developer Resume', 4, 75000.0, true, '2025-07-05', '2025-07-12');

create table if not exists vacancies
(
    id           int auto_increment primary key,
    employer_id  INT,
    title        varchar(100),
    description  varchar(255),
    category_id  INT,
    salary       FLOAT,
    is_active    BOOLEAN,
    created_date DATE
);
insert into vacancies (employer_id, title, description, category_id, salary, is_active, created_date)
values (2, 'Middle Java Developer', 'Java developer with 2+ years experience', 3, 120000.0, true, '2025-07-15'),
       (2, 'React Frontend Developer', 'Frontend developer with React and Redux', 4, 110000.0, true, '2025-07-16');

create table if not exists responded_applicants
(
    id           int auto_increment primary key,
    resume_id    INT,
    vacancy_id   INT,
    confirmation BOOLEAN,
    foreign key (resume_id) references resumes (id),
    foreign key (vacancy_id) references vacancies (id)
);
insert into responded_applicants (resume_id, vacancy_id, confirmation)
values (1, 2, false),
       (2, 2, true);

create table if not exists categories
(
    id        int auto_increment primary key,
    name      varchar(45),
    parent_id int
);
insert into categories (name, parent_id)
values ('IT', null),
       ('Development', 1),
       ('Design', 1),
       ('Frontend', 2);

create table if not exists contact_types
(
    id   int auto_increment primary key,
    name varchar(45)
);
insert into contact_types (name)
values ('email'),
       ('phone'),
       ('telegram');

create table if not exists contacts_info
(
    id            int auto_increment primary key,
    type_id       INT,
    resume_id     INT,
    contact_value varchar(45),
    foreign key (type_id) references contact_types (id),
    foreign key (resume_id) references resumes (id)
);

insert into contacts_info(type_id, resume_id, contact_value)
values (1, 1, 'johndoe@example.com'),
       (2, 1, '+996 555 123 456'),
       (3, 1, '@johndoe'),
       (1, 2, 'janedoe@example.com'),
       (2, 2, '+996 777 654 321');


create table if not exists education_info
(
    id          int auto_increment primary key,
    resume_id   INT,
    institution varchar(45),
    program     varchar(45),
    start_date  DATE,
    end_date    DATE,
    degree      varchar(45),
    foreign key (resume_id) references resumes (id)
);
insert into education_info (resume_id, institution, program, start_date, end_date, degree)
values (1, 'Kyrgyz State Technical University', 'Computer Science', '2016-09-01', '2020-06-30', 'Bachelor'),
       (2, 'American University of Central Asia', 'Business Administration', '2017-09-01', '2021-06-30', 'Bachelor');

create table if not exists messages
(
    id                  int auto_increment primary key,
    respondedApplicants INT,
    content             varchar(255),
    timestamp           TIMESTAMP,
    foreign key (respondedApplicants) references responded_applicants (id)
);
insert into messages (respondedApplicants, content, timestamp)
values (1, 'Здравствуйте! Мы рассмотрели ваше резюме и хотим назначить собеседование.', CURRENT_TIMESTAMP),
       (2, 'Спасибо за отклик! Когда вы готовы пройти интервью?', CURRENT_TIMESTAMP);

create table if not exists response
(
    id           int auto_increment primary key,
    job_id       INT,
    resume_id    INT,
    responded_at DATETIME,
    foreign key (job_id) references vacancies (id),
    foreign key (resume_id) references resumes (id)
);
insert into response (job_id, resume_id, responded_at)
values (1, 1, '2025-07-01 09:30:00'),
       (2, 1, '2025-07-02 11:00:00'),
       (1, 2, '2025-07-03 14:45:00'),
       (2, 2, '2025-07-04 16:15:00');

create table if not exists workExperienceInfo
(
    id               int auto_increment primary key,
    resume_id        INT,
    years            INT,
    company_name     varchar(45),
    position         varchar(45),
    responsibilities varchar(45),
    foreign key (resume_id) references resumes (id)
);
