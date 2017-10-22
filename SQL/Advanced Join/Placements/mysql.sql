select s.name
from students s
join packages p1 on p1.id = s.id
join friends f on f.id = s.id
join packages p2 on p2.id = f.friend_id
where p1.salary < p2.salary
order by p2.salary