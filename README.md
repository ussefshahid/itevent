# itevent
SQLI E-challenge 2018 - Session 2

 * This exercise is about organizing an IT event. If you attended the Devoxx Morocco event that was organized this week, the problem we are trying to solve will sound familiar to you ;)
 * Our objective is to provide event organizers a small tool to help them manage hotel reservations for attendees, speakers and staff.
 * Here are some important information and some rules to follow :
 *  - The event last 3 days, the first day for 2 hours sessions (called deep dive), while the second and third days are for sessions of 50 minutes at most.
 *  - All attendees can buy one of these 3 offers :
 *       -- Conference days : they can only attend the second and third days
 *       -- Deep Dive : they can only attend the first day
 *       -- Tringa : they can attend the entire three days
 *  - All reservations are done in the same Hotel.
 *  - All rooms are individual; The hotel capacity is as such:
 *       -- Standard room, (room numbers between 1 and 100)
 *       -- Suites, (room numbers between 101 and 200)
 *       -- Apartments, (room numbers between 201 and 300)
 *  - All attendees and staff members book standard rooms by default; If there are no more standard room, they book apartments instead.
 *  - Suites are for Speakers only.
