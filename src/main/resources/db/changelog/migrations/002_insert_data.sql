-- Заполнение таблицы contact_types (типы контактов)
INSERT INTO contact_types (id, type)
VALUES (1, 'Email'),
       (2, 'Телефон'),
       (3, 'LinkedIn'),
       (4, 'Telegram'),
       (5, 'GitHub');

-- Заполнение таблицы categories (категории вакансий/резюме)
INSERT INTO categories (id, name, parent_id)
VALUES (1, 'IT', NULL),
       (2, 'Разработка', 1),
       (3, 'DevOps', 1),
       (4, 'Data Science', 1),
       (5, 'Маркетинг', NULL),
       (6, 'SMM', 5),
       (7, 'SEO', 5),
       (8, 'Финансы', NULL),
       (9, 'Бухгалтерия', 8),
       (10, 'Аналитика', 8);

-- Заполнение таблицы users (пользователи)
INSERT INTO users (id, name, username, age, email, password, phone_number, avatar, account_type)
VALUES (1, 'Иван Петров', 'ivan_petrov', 28, 'ivan@example.com', '$2a$10$xJwL5v5z3U6X3Y2QkZQZVu', '+79161234567',
        'ivan.jpg', 'applicant'),
       (2, 'Мария Сидорова', 'maria_sidorova', 32, 'maria@example.com', '$2a$10$xJwL5v5z3U6X3Y2QkZQZVu', '+79167654321',
        'maria.jpg', 'employer'),
       (3, 'Алексей Иванов', 'alex_ivanov', 25, 'alex@example.com', '$2a$10$xJwL5v5z3U6X3Y2QkZQZVu', '+79165554433',
        'alex.jpg', 'applicant'),
       (4, 'Елена Кузнецова', 'elena_kuznetsova', 40, 'elena@example.com', '$2a$10$xJwL5v5z3U6X3Y2QkZQZVu',
        '+79168887766', 'elena.jpg', 'employer'),
       (5, 'Дмитрий Смирнов', 'dmitry_smirnov', 35, 'dmitry@example.com', '$2a$10$xJwL5v5z3U6X3Y2QkZQZVu',
        '+79161112233', 'dmitry.jpg', 'applicant');

-- Заполнение таблицы resumes (резюме)
INSERT INTO resumes (id, applicant_id, name, category_id, salary, is_active, created_date, update_time)
VALUES (1, 1, 'Senior Java Developer', 2, 250000, true, '2024-01-15 10:00:00', NULL),
       (2, 3, 'Junior Data Scientist', 4, 120000, true, '2024-02-20 14:30:00', '2024-03-01 09:15:00'),
       (3, 5, 'Финансовый аналитик', 10, 180000, false, '2023-12-05 11:45:00', '2024-01-10 16:20:00');

-- Заполнение таблицы contacts_info (контактная информация)
INSERT INTO contacts_info (id, type_id, resume_id, value_info)
VALUES (1, 1, 1, 'ivan@example.com'),
       (2, 2, 1, '+79161234567'),
       (3, 3, 1, 'linkedin.com/in/ivan_petrov'),
       (4, 1, 2, 'alex@example.com'),
       (5, 4, 2, '@alex_ivanov_telegram');

-- Заполнение таблицы vacancies (вакансии)
INSERT INTO vacancies (id, name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date,
                       update_time)
VALUES (1, 'Java Developer (Remote)', 'Ищем опытного Java-разработчика для работы над высоконагруженным проектом.', 2,
        280000, 3, 7, true, 2, '2024-03-10 09:00:00', '2024-03-15 10:30:00'),
       (2, 'Data Scientist', 'Требуется специалист по машинному обучению и анализу данных.', 4, 220000, 2, 5, true, 4,
        '2024-03-05 12:00:00', '2024-03-12 14:45:00'),
       (3, 'SEO Specialist', 'Поддержка и продвижение сайтов компании.', 7, 150000, 1, 3, false, 4,
        '2024-02-01 11:20:00', '2024-02-28 17:00:00');

-- Заполнение таблицы responded_applicants (отклики на вакансии)
INSERT INTO responded_applicants (id, resume_id, vacancy_id, confirmation)
VALUES (1, 1, 1, true),
       (2, 2, 2, false),
       (3, 3, 3, true);

-- Заполнение таблицы education_info (образование)
INSERT INTO education_info (id, resume_id, institution, program, start_date, end_date, degree)
VALUES (1, 1, 'МГУ', 'Прикладная информатика', '2015-09-01', '2019-06-30', 'Бакалавр'),
       (2, 2, 'НИУ ВШЭ', 'Машинное обучение', '2020-09-01', '2024-06-30', 'Магистр'),
       (3, 3, 'РЭУ им. Плеханова', 'Финансы и кредит', '2010-09-01', '2015-06-30', 'Специалист');

-- Заполнение таблицы work_experience_info (опыт работы)
INSERT INTO work_experience_info (id, resume_id, years, company_name, position, responsibilities)
VALUES (1, 1, 5, 'Yandex', 'Java Developer', 'Разработка backend-решений для поискового движка.'),
       (2, 2, 1, 'Sber AI', 'Data Science Intern', 'Участие в проектах по NLP.'),
       (3, 3, 7, 'Газпромбанк', 'Финансовый аналитик', 'Анализ рынков, подготовка отчетов.');

-- Заполнение таблицы messages (сообщения)
INSERT INTO messages (id, responded_applicants, content, timestamp)
VALUES (1, 1, 'Здравствуйте, Иван! Нам понравилось ваше резюме. Можете ли вы прислать примеры кода?',
        '2024-03-11 15:30:00'),
       (2, 1, 'Конечно, отправил вам ссылку на GitHub.', '2024-03-11 16:45:00'),
       (3, 2, 'Спасибо за отклик! К сожалению, ваш опыт не совсем подходит.', '2024-03-06 10:20:00');
