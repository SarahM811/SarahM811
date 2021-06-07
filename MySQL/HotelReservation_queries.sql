use mydb;

select reservation.customerid
from reservation
inner join customer as c on reservation.customerid = c.customerid;

select *
from addonrate;

select rp.rateperiodId, r.reservationid
from reservation as r
inner join reservationdate as rd on rd.date between r.checkindate and r.checkoutdate
inner join rateperiod as rp on rd.date between rp.startdate and rp.enddate
group by rp.rateperiodId, r.reservationid;

select *
from invoice;

select *
from promotion;

select *
from addontotal;

select *
from bill;

select *
from reservation;

select *
from guest;

select concat(g.firstname, ' ', g.lastname), r.reservationid
from reservation as r
left join guest as g on r.reservationid = g.reservationid;

-- showing all dates
-- ----------------------------
select
	r.reservationId as reservationId, 
    rd.roomNum as roomNumber,
    rp.rateperiodid as rateperiodId,
    (rr.Price) as RoomPrice, 
    rd.date as Date
FROM Reservation as r
	inner JOIN ReservationDate as rd ON rd.ReservationID = r.ReservationID
	inner JOIN Room as rm ON rm.RoomId = rd.RoomNum
    inner join roomtype as rt on rm.roomtypeid = rt.roomtypeid
	inner JOIN RoomRate as rr ON rr.roomtypeid = rt.roomtypeid
	inner JOIN RatePeriod as rp ON rr.RateperiodId = rp.RateperiodId and rd.date between rp.startdate and rp.enddate     
GROUP BY r.ReservationID, rd.roomNum, rd.date;

-- get amenities by room------------------
-- -----------------------
select
	r.reservationid as reservationid,
    rd.roomNum as roomNumber,
    a.name as amenity
from reservation as r
	join reservationdate as rd on rd.reservationid = r.reservationid
    join room as rm on rd.roomnum = rm.roomid
    join roomamenity as ra on rm.roomid = ra.roomnum
    join amenity as a on ra.amenityid = a.amenityid
group by r.reservationid, rd.roomnum, a.name;
