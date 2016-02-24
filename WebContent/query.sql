Select * from ResultRecord;
Select * from TRAINING_TOOL_USERS;
Delete  ResultRecord;
Desc RESULTRECORD;
desc COURSE_DETAILS_RECORD;

Select * from COURSE_DETAILS_RECORD;

select  sum(M_TL_EL),
        sum(M_TL_PO),
        sum(M_TL_AD),
        sum(M_TL_AS),
        sum(M_TM_EL ),
        sum(M_TM_PO ),
        sum(M_TM_AD),
        sum(M_TM_AS  ) from COURSE_DETAILS_RECORD;
        
        select count(cname) from COURSE_DETAILS_RECORD;
        
        
Select * from ResultRecord;
Select * from TRAINING_TOOL_USERS;
Delete  ResultRecord;
select a.userid,a.name,a.email,a.user_role,a.user_sub_role,b.cid from 
TRAINING_TOOL_USERS a 
left outer join 
ResultRecord b on (a.email=b.userid) order by userid;

select userid,name,user_role,user_sub_role,count(cid) from 
(select a.userid,a.name,a.email,a.user_role,a.user_sub_role,b.cid from 
TRAINING_TOOL_USERS a 
left outer join 
ResultRecord b on (a.email=b.userid) order by userid) group by userid,name,user_role,user_sub_role order by userid;


select a.userid,a.name,a.email,a.user_role,a.user_sub_role,b.cid,c.M_TL_EL,
c.M_TL_PO,
c.M_TL_AD,
c.M_TL_AS, 
c.M_TM_EL,
c.M_TM_PO, 
c.M_TM_AD, 
c.M_TM_AS   from 
TRAINING_TOOL_USERS a 
left outer join 
ResultRecord b on (a.email=b.userid)
left outer join
COURSE_DETAILS_RECORD c on (b.cid=c.cid)
order by userid;


