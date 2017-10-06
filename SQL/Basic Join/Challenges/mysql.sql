set @max := (
    select count(challenge_id) totalChallenge
    from challenges
    group by hacker_id
    order by totalChallenge desc
    limit 1);

select h.hacker_id, h.name, count(c.challenge_id) totalChallenge
from hackers h
join challenges c on c.hacker_id = h.hacker_id
group by h.hacker_id, h.name
having
    totalChallenge = @max 
    or totalChallenge in (
        select totalChallenge
        from (
            select totalChallenge, count(hacker_id) totalHacker
            from (
                select hacker_id, count(challenge_id) totalChallenge
                from challenges
                group by hacker_id
                order by totalChallenge desc) a
            group by totalChallenge
            having totalHacker = 1) b)
order by totalChallenge desc, h.hacker_id asc