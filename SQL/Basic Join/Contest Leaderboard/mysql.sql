select h.hacker_id, h.name, sum(score) score
from (
    select hacker_id, challenge_id, max(score) score
    from submissions
    group by hacker_id, challenge_id) a
join hackers h on h.hacker_id = a.hacker_id
group by h.hacker_id, h.name
having score > 0
order by score desc, h.hacker_id asc