set @max := (select count(challenge_id) challenge from challenges group by hacker_id order by challenge desc limit 1);

select h.hacker_id, h.name, count(c.challenge_id) challenge
from hackers h
join challenges c on c.hacker_id = h.hacker_id
group by h.hacker_id, h.name
having
    challenge = @max 
    or challenge in (
        select challenge
        from (
            select challenge, count(hacker_id) total
            from (
                select hacker_id, count(challenge_id) challenge
                from challenges
                group by hacker_id
                order by challenge desc) a
            group by challenge
            having total = 1) b)
order by challenge desc, h.hacker_id asc