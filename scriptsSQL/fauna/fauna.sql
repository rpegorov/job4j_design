create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('Anser caerulescens', 13216, '12/26/1924');
insert into fauna (name, avg_age, discovery_date) values ('Vulpes chama', 17878, '4/23/1976');
insert into fauna (name, avg_age, discovery_date) values ('Lama pacos', 19418, '10/26/2009');
insert into fauna (name, avg_age, discovery_date) values ('Lorythaixoides concolor', 21524, '12/26/1947');
insert into fauna (name, avg_age, discovery_date) values ('Salvadora hexalepis', 11640, null);
insert into fauna (name, avg_age, discovery_date) values ('Ratufa indica', 18901, '9/28/2011');
insert into fauna (name, avg_age, discovery_date) values ('Hyaena hyaena', 7208, '12/11/1980');
insert into fauna (name, avg_age, discovery_date) values ('Uraeginthus angolensis', 13722, '11/28/1948');
insert into fauna (name, avg_age, discovery_date) values ('Macropus robustus', 6714, '12/12/1970');
insert into fauna (name, avg_age, discovery_date) values ('Lutra canadensis', 18935, '10/13/2014');
insert into fauna (name, avg_age, discovery_date) values ('Bubalus arnee', 6456, '11/8/1988');
insert into fauna (name, avg_age, discovery_date) values ('Falco peregrinus', 6870, '2/15/1919');
insert into fauna (name, avg_age, discovery_date) values ('Ammospermophilus nelsoni', 24945, '2/26/1982');
insert into fauna (name, avg_age, discovery_date) values ('Acridotheres tristis', 22563, '12/10/1905');
insert into fauna (name, avg_age, discovery_date) values ('Paroaria gularis', 10579, '4/3/1916');
insert into fauna (name, avg_age, discovery_date) values ('Kobus defassa', 5877, '8/16/1937');
insert into fauna (name, avg_age, discovery_date) values ('Estrilda erythronotos', 719, '2/11/1979');
insert into fauna (name, avg_age, discovery_date) values ('Lorythaixoides concolor', 5410, '1/26/1927');
insert into fauna (name, avg_age, discovery_date) values ('Phalacrocorax brasilianus', 9443, '5/4/1988');
insert into fauna (name, avg_age, discovery_date) values ('Canis lupus lycaon', 6275, '12/1/1924');
insert into fauna (name, avg_age, discovery_date) values ('Phalacrocorax niger', 19355, '12/17/1908');
insert into fauna (name, avg_age, discovery_date) values ('Madoqua kirkii', 16086, null);
insert into fauna (name, avg_age, discovery_date) values ('Grus antigone', 6285, '8/18/2010');
insert into fauna (name, avg_age, discovery_date) values ('Felis wiedi or Leopardus weidi', 3173, '3/2/1949');
insert into fauna (name, avg_age, discovery_date) values ('Actophilornis africanus', 17375, '6/18/1979');
insert into fauna (name, avg_age, discovery_date) values ('Bucephala clangula', 5262, null);
insert into fauna (name, avg_age, discovery_date) values ('Cracticus nigroagularis', 16729, '11/25/2016');
insert into fauna (name, avg_age, discovery_date) values ('Junonia genoveua', 24658, null);
insert into fauna (name, avg_age, discovery_date) values ('Larus dominicanus', 19165, '10/21/1996');
insert into fauna (name, avg_age, discovery_date) values ('Lepus arcticus', 1122, '6/21/1947');
insert into fauna (name, avg_age, discovery_date) values ('Stercorarius longicausus', 11553, '5/17/1967');
insert into fauna (name, avg_age, discovery_date) values ('Theropithecus gelada', 15226, '5/9/1954');
insert into fauna (name, avg_age, discovery_date) values ('Merops bullockoides', 23825, '5/31/1979');
insert into fauna (name, avg_age, discovery_date) values ('Sagittarius serpentarius', 18834, '11/3/1959');
insert into fauna (name, avg_age, discovery_date) values ('Passer domesticus', 7792, '3/12/1953');
insert into fauna (name, avg_age, discovery_date) values ('Streptopelia decipiens', 10199, '11/20/1922');
insert into fauna (name, avg_age, discovery_date) values ('Anastomus oscitans', 18149, '9/1/1931');
insert into fauna (name, avg_age, discovery_date) values ('Chlidonias leucopterus', 12638, '9/28/1979');
insert into fauna (name, avg_age, discovery_date) values ('Nyctea scandiaca', 3204, '1/27/1956');
insert into fauna (name, avg_age, discovery_date) values ('Varanus sp.', 3289, '11/6/1948');
insert into fauna (name, avg_age, discovery_date) values ('Echimys chrysurus', 15275, '2/2/2019');
insert into fauna (name, avg_age, discovery_date) values ('Trachyphonus vaillantii', 10322, '11/4/1939');
insert into fauna (name, avg_age, discovery_date) values ('Francolinus coqui', 13137, '9/23/1945');
insert into fauna (name, avg_age, discovery_date) values ('Oreamnos americanus', 14373, null);
insert into fauna (name, avg_age, discovery_date) values ('Sagittarius serpentarius', 10155, '7/2/1945');
insert into fauna (name, avg_age, discovery_date) values ('Naja nivea', 22129, '10/28/1975');
insert into fauna (name, avg_age, discovery_date) values ('Tetracerus quadricornis', 3975, '12/8/1997');
insert into fauna (name, avg_age, discovery_date) values ('Iguana iguana', 15890, '9/30/1990');
insert into fauna (name, avg_age, discovery_date) values ('Laniarius ferrugineus', 3410, '4/4/2003');
insert into fauna (name, avg_age, discovery_date) values ('Nucifraga columbiana', 9400, null);

select * from fauna;

select * from fauna where name like '%Lama%';
select * from fauna where name like '%Varanus%';

select * from fauna where avg_age > 10000 and avg_age < 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '1/1/1950';