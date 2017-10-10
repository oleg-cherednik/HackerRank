set @g := 0, @prv := 0; 
select min(a.start_date) min, max(a.end_date) max
from (
    select
        p1.task_id,
        p1.start_date,
        p1.end_date,
        case
            when @prv + 1 = to_days(p1.end_date) then @g
            else @g := @g + 1
        end as g,
        @prv := to_days(p1.end_date)
    from (select * from projects order by end_date) p1) a
group by a.g
order by count(*) asc, min asc
