use Assignment_Report;

insert into timesheet(checkwork,overtime) value (?,?);

insert into [Bonus-Punish-AdvancePayment](bonus,punish,adpayment) value (?,?,?);

select count(checkwork) from timesheet where checkwork like'W' and eid=?;
select count(checkwork) from timesheet where checkwork like'KP' and eid=?;
select count(checkwork) from timesheet where checkwork like'P' and eid=?;

select sum(overtime) from timesheet  where eid=?;

insert into salary(payday,payOvT) value (?,?);

