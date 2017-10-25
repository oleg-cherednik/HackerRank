select t5.submission_date, t5.total, t5.hacker_id, h.name
from (
	select
		t4.submission_date,
		total,
		(select hacker_id
		 from submissions
		 where submission_date = t4.submission_date
		 group by submission_date, hacker_id
		 order by submission_date, count(submission_id) desc, hacker_id
		 limit 1) hacker_id
	from (
		select t3.submission_date, count(t3.hacker_id) total
		from (
			select
				submission_date,
				hacker_id,
				(select count(distinct submission_date) from submissions where hacker_id = t1.hacker_id and submission_date <= t1.submission_date) total
				from (select distinct submission_date, hacker_id from submissions order by submission_date, hacker_id) t1
			having day(submission_date) = total) t3
		group by t3.submission_date) t4) t5
join hackers h on h.hacker_id = t5.hacker_id
order by submission_date
        