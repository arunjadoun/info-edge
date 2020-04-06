--insert into REPO values (352806, 'johnbolton/exercitationem', 'https://github.com/johnbolton/exercitatione');
--insert into REPO values (35206, 'bolton/exercitationem', 'https://github.com/johnbolton/exercitation');
--insert into REPO values (3806, 'john/exercitationem', 'https://github.com/johnbolton/exercitatio');
--insert into REPO values (806, 'olton/exercitationem', 'https://github.com/johnbolton/exercitati');
--
--
--insert into ACTOR values (2790311, 'A', 'daniel33');
--insert into ACTOR values (279031, 'B', 'daniel3');
--insert into ACTOR values (27903, 'C', 'daniel');
--
--insert into EVENT values (4055191679, now(), 'PushEvent', 2790311, 352806);
--insert into EVENT values (491679, now(), 'PushEvent', 2790311, 352806);
--insert into EVENT values (405519167, now(), 'PushEvent', 2790311, 352806);
--insert into EVENT values (40551916, now(), 'PushEvent', 2790311, 352806);
--
--insert into EVENT values (1155191679, now(), 'PushEvent', 279031, 352806);
--insert into EVENT values (125519167, now(), 'PushEvent', 279031, 3806);
--insert into EVENT values (4121551916, now(), 'PushEvent', 279031, 806);
--

DROP TABLE IF EXISTS lab;
DROP TABLE IF EXISTS hospital;
DROP TABLE IF EXISTS lab_hospital;
DROP TABLE IF EXISTS test;

CREATE TABLE `lab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) not NULL,
  `latitude` decimal(11,7) NOT NULL,
  `longitude` decimal(11,7) NOT NULL,
  `max_capacity` int(11) NOT NULL default 0,
  `active_test` int(11) default 0,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
);


CREATE TABLE `hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(256) not NULL,
  `latitude` decimal(11,7) NOT NULL,
  `longitude` decimal(11,7) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
);

CREATE TABLE `lab_hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_id` int(11) NOT NULL,
  `hospital_id` int(11) NOT NULL,
  `time` decimal(11,7) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_id` int(11) NOT NULL,
  `hospital_id` int(11) NOT NULL,
  `end_time` int(11) NOT NULL,
   `status` varchar(256) default NULL,
   `result` varchar(256) default NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
  );


insert into lab values (1, 'l1', 90, 90, 1, 0, now());
insert into lab values (2, 'l', 90, 90, 1, 0, now());

insert into hospital values (1, 'h1', 90, 90, now());
insert into hospital values (2, 'h2', 90, 90, now());

insert into lab_hospital values (1, 1, 1, 10);
insert into lab_hospital values (3, 2, 1, 10);
insert into lab_hospital values (2, 2, 2, 10);
insert into lab_hospital values (4, 1, 2, 10);

insert into test values (1, 1, 1, 10000, 'RUNNING', 'IN_PROGRESS', now());
insert into test values (2, 2, 2, 2000, 'RUNNING', 'IN_PROGRESS', now());

insert into test values (3, 1, 1, 3000, 'RUNNING', 'IN_PROGRESS', now());
insert into test values (4, 2, 2, 4000, 'RUNNING', 'IN_PROGRESS', now());


