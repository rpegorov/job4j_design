insert into users ("First_name", "Last_name", "Tel_number", email) values ('Cindi', 'Hordell', '+55 763 171 9406', 'chordell0@reuters.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Bear', 'Bock', '+880 534 471 1157', 'bbock1@walmart.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Leticia', 'Moiser', '+1 255 592 8776', 'lmoiser2@nba.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Elston', 'Dawidowitsch', '+86 688 607 3554', 'edawidowitsch3@yahoo.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Thorin', 'Dellow', '+86 274 490 5380', 'tdellow4@businesswire.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Kathie', 'Ellyatt', '+86 724 878 0088', 'kellyatt5@hostgator.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Van', 'Rickerby', '+263 859 893 1126', 'vrickerby6@epa.gov');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Beth', 'Caccavella', '+62 523 258 3900', 'bcaccavella7@unblog.fr');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Maurice', 'Arkil', '+998 642 283 9529', 'markil8@goodreads.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Ethelred', 'Housin', '+86 240 698 0774', 'ehousin9@columbia.edu');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Angil', 'Nutkin', '+86 883 633 5217', 'anutkina@globo.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Sib', 'Prosser', '+54 916 509 5345', 'sprosserb@purevolume.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Josh', 'Gripton', '+998 502 148 6949', 'jgriptonc@fema.gov');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Dena', 'Hundey', '+62 342 645 3439', 'dhundeyd@nationalgeographic.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Meridith', 'Peller', '+420 391 322 8613', 'mpellere@marriott.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Gertrud', 'D''Antonio', '+62 598 356 6060', 'gdantoniof@prnewswire.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Natividad', 'Greenstock', '+880 297 842 8932', 'ngreenstockg@xrea.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Palmer', 'Bartolomeu', '+591 219 148 7953', 'pbartolomeuh@ameblo.jp');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Margy', 'Trouncer', '+62 101 655 8664', 'mtrounceri@netscape.com');
insert into users ("First_name", "Last_name", "Tel_number", email) values ('Keely', 'Matskiv', '+52 230 707 5450', 'kmatskivj@last.fm');

insert into category (export, moving) VALUES (true, false);
insert into category (export, moving) VALUES (false, true);

insert into comments (comment, item_id) VALUES ('Срочно!', 1);

insert into attach (attachs, item_id) VALUES ('insert file...', 1);

insert into item (items, users_id, category_id, status_id) VALUES ('поставка лесопродукции', 14, 1, 1);
insert into item (items, users_id, category_id, status_id) VALUES ('закупка бумаги', 19, 2, 1);
insert into status (executed) VALUES (0);

insert into rules (read, write, add_users, redact_item, redact_cat) VALUES (true, true, true, true, true);
insert into rules (read, write, add_users, redact_item, redact_cat) VALUES (true, true, false, true, false);
insert into rules (read, write, add_users, redact_item, redact_cat) VALUES (true, true, false, true, true);

insert into role_rules (role_id, rules_id) VALUES (1, 1);
insert into role_rules (role_id, rules_id) VALUES (2, 2);
insert into role_rules (role_id, rules_id) VALUES (2, 2);
insert into role_rules (role_id, rules_id) VALUES (2, 2);
insert into role_rules (role_id, rules_id) VALUES (3, 3);
insert into role_rules (role_id, rules_id) VALUES (3, 3);

