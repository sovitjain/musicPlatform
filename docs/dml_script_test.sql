insert into user (id,name) values(1, 'Sovit');
insert into user (id,name) values(2, 'John');
insert into user (id,name) values(3, 'Tim');


insert into playlist (id,playlist_name,views,user_id) values(1, 'down the noise', 500,1);
insert into playlist (id,playlist_name,views,user_id) values(2, 'it is time to have fun', 800,2);
insert into playlist (id,playlist_name,views,user_id) values(3, 'CoffeeHouse', 200,3);

insert into tags (id,tag_name) values(1, 'FloFilz');
insert into tags (id,tag_name) values(2, 'Philanthrope');
insert into tags (id,tag_name) values(3, 'Evil Needle');
insert into tags (id,tag_name) values(4, 'indie pop');
insert into tags (id,tag_name) values(5, 'indie rock');
insert into tags (id,tag_name) values(6, 'summer');
insert into tags (id,tag_name) values(7, 'chill');
insert into tags (id,tag_name) values(8, 'ind');

insert into playlist_tags (playlist_id, tags_id) values(1,1);
insert into playlist_tags (playlist_id, tags_id) values(1,2);
insert into playlist_tags (playlist_id, tags_id) values(2,1);
insert into playlist_tags (playlist_id, tags_id) values(2,3);
insert into playlist_tags (playlist_id, tags_id) values(3,1);
insert into playlist_tags (playlist_id, tags_id) values(3,2);
insert into playlist_tags (playlist_id, tags_id) values(3,3);
insert into playlist_tags (playlist_id, tags_id) values(3,4);
insert into playlist_tags (playlist_id, tags_id) values(3,6);
insert into playlist_tags (playlist_id, tags_id) values(3,8);
insert into playlist_tags (playlist_id, tags_id) values(1,5);
insert into playlist_tags (playlist_id, tags_id) values(3,5);

