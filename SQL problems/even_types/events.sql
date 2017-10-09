

create table events (
      event_type integer not null,
      value integer not null,
      time timestamp not null,
      unique(event_type, time)
  );
insert into events values (2,5,'2015-05-09 12:42:00');
insert into events values (4,-42, '2015-05-09 13:19:57');
insert into events values (2,2, '2015-05-09 14:48:30');
  insert into events values (2,7,'2015-05-09 12:54:39');
    insert into events values (3, 16, '2015-05-09 13:19:57');
      insert into events values (3, 20, '2015-05-09 15:01:09');

-----------------------------------------------------------------------------------

  select e10.event_type, 
  (
  select 
  e2.value
  from events e2
  where 
    e2.event_type = e10.event_type
    order by e2.event_type, e2.time desc
    limit 1

  ) - 

   (
   select e3.value
   from events e3
   where 
   e3.time <> (
    select 
  e2.time
  from events e2
  where e2.event_type = e10.event_type 
    order by e2.time desc
    limit 1
    )
     and e3.event_type = e10.event_type
    order by e3.time desc
    limit 1
     ) as value

     from events e10
     where e10.event_type
     in (

      select event_type e1
      from events e1
      where(
         select count(e2.event_type)
          from events e2
         where e2.event_type = e1.event_type
         group by e2.event_type
         having count(e2.event_type) > 1

      )
      group by e1.event_type
  )
   group by e10.event_type
   order by e10.event_type
