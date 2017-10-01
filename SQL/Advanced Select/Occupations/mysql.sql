set @d=0, @p=0, @s=0, @a=0;
select min(Doctor), min(Professor), min(Singer), min(Actor)
from (
    select
        case
            when occupation = 'Doctor' then (@d:=@d+1)
            when occupation = 'Professor' then (@p:=@p+1)
            when occupation = 'Singer' then (@s:=@s+1)
            when occupation = 'Actor' then (@a:=@a+1)
        end as id,
        case when occupation = 'Doctor' then name end as Doctor,
        case when occupation = 'Professor' then name end as Professor,
        case when occupation = 'Singer' then name end as Singer,
        case when occupation = 'Actor' then name end as Actor
    from occupations
    order by name
) tmp
group by id