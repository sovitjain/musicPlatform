select * from user;

select * from playlist;

select * from tags;

select * from playlist_tags;

/*problem statement 1 - Auto suggest tag*/
select count(p.id), t.tag_name  from playlist p, tags t, playlist_tags pt  where p.id = pt.playlist_id and t.id = pt.tags_id  group by t.id having t.tag_name like 'i%' order by count(p.id) desc;

/*problem statement 2 - Display suggested tag*/
select t.tag_Name, t.id, count(t.id) from tags t, playlist p, playlist_tags pt where t.id= pt.tags_id and p.id = pt.playlist_id and p.id in(
select p.id from tags t, playlist p, playlist_tags pt where t.id= pt.tags_id and p.id = pt.playlist_id and t.tag_Name='indie rock') group by t.tag_name order by count(t.tag_name) desc;

/*problem statement 3 - display playlist in desc order of view along with the tags*/
select p.playlist_name, t.tag_name from tags t, playlist p, playlist_tags pt where t.id= pt.tags_id and p.id = pt.playlist_id order by p.views desc;