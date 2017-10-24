select co.contest_id, co.hacker_id, co.name, sum(ifnull(t1.total_submissions, 0)), sum(ifnull(t1.total_accepted_submissions, 0)), sum(ifnull(t2.total_views, 0)), sum(ifnull(t2.total_unique_views, 0))
from contests co
join colleges cl on co.contest_id = cl.contest_id
left join (
	select ch.college_id, sum(ss.total_submissions) total_submissions, sum(ss.total_accepted_submissions) total_accepted_submissions
	from challenges ch
	join submission_stats ss on ss.challenge_id = ch.challenge_id
	group by ch.college_id ) t1
on cl.college_id = t1.college_id
left join (
	select ch.college_id, sum(vs.total_views) total_views, sum(vs.total_unique_views) total_unique_views
	from challenges ch
	join view_stats vs on vs.challenge_id = ch.challenge_id
	group by ch.college_id) t2
on cl.college_id = t2.college_id
where t1.total_submissions > 0 or t1.total_accepted_submissions > 0 or t2.total_views > 0 or t2.total_unique_views > 0
group by co.contest_id, co.hacker_id, co.name
order by co.contest_id