CREATE TABLE `time_table`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `student_id`     BIGINT UNSIGNED NOT NULL,
    `course_id`      BIGINT UNSIGNED NOT NULL,
    `number_lessons` INT             NOT NULL,
    `course_start`   DATETIME        NOT NULL,
    `course_end`     DATETIME        NOT NULL,
    `teacher_id`     BIGINT UNSIGNED NOT NULL,
    `date`           DATE            NOT NULL
);
CREATE TABLE `class`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`           VARCHAR(30)     NOT NULL,
    `number_student` INT             NOT NULL,
    `teacher_id`     BIGINT UNSIGNED NOT NULL
);
CREATE TABLE `lecturer`
(
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`          VARCHAR(30)     NOT NULL,
    `date_of_birth` DATE            NOT NULL,
    `sex`           BOOLEAN         NOT NULL,
    `phone`         VARCHAR(20)     NOT NULL,
    `degree`        VARCHAR(20)     NOT NULL,
    `address`       VARCHAR(255)    NOT NULL,
    `email`         VARCHAR(40)     NOT NULL
);
CREATE TABLE `course`
(
    `id`             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`           VARCHAR(70)     NOT NULL,
    `number_lessons` INT             NOT NULL
);
CREATE TABLE `student`
(
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`          VARCHAR(30)     NOT NULL,
    `date_of_birth` DATE            NOT NULL,
    `sex`           BOOLEAN         NOT NULL,
    `phone`         VARCHAR(20)     NOT NULL,
    `address`       VARCHAR(255)    NOT NULL,
    `email`         VARCHAR(40)     NOT NULL,
    `class_id`      BIGINT UNSIGNED NOT NULL
);

ALTER TABLE `student`
    ADD CONSTRAINT `student_class_id_foreign` FOREIGN KEY (`class_id`) REFERENCES classroom (`id`);
ALTER TABLE classroom
    ADD CONSTRAINT `class_teacher_id_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `lecturer` (`id`);

ALTER TABLE `time_table`
    ADD CONSTRAINT `time_table_student_id_foreign` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
    ADD CONSTRAINT `time_table_teacher_id_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `lecturer` (`id`),
    ADD CONSTRAINT `time_table_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);