insert into REPO values (352806, 'johnbolton/exercitationem', 'https://github.com/johnbolton/exercitatione');
insert into REPO values (35206, 'bolton/exercitationem', 'https://github.com/johnbolton/exercitation');
insert into REPO values (3806, 'john/exercitationem', 'https://github.com/johnbolton/exercitatio');
insert into REPO values (806, 'olton/exercitationem', 'https://github.com/johnbolton/exercitati');


insert into ACTOR values (2790311, 'A', 'daniel33');
insert into ACTOR values (279031, 'B', 'daniel3');
insert into ACTOR values (27903, 'C', 'daniel');

insert into EVENT values (4055191679, now(), 'PushEvent', 2790311, 352806);
insert into EVENT values (491679, now(), 'PushEvent', 2790311, 352806);
insert into EVENT values (405519167, now(), 'PushEvent', 2790311, 352806);
insert into EVENT values (40551916, now(), 'PushEvent', 2790311, 352806);

insert into EVENT values (1155191679, now(), 'PushEvent', 279031, 352806);
insert into EVENT values (125519167, now(), 'PushEvent', 279031, 3806);
insert into EVENT values (4121551916, now(), 'PushEvent', 279031, 806);


CREATE TABLE `REPO` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `url` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `ACTOR` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(256) NOT NULL,
  `avatar` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `EVENT` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(256) NOT NULL,
  `actor_id` bigint(20) NOT NULL,
  `repo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);





