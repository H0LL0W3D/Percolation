/******************************************************************************
 *  Name:     
 *  Jacob Olson
 *  Hours to complete assignment (optional): ~40 hours
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates? This should be something like 3-5 sentences.
 *****************************************************************************/
Initailly, I figured the best choice of testing would be to run the program to
see if I encountered any runtime or syntax errors.

Next, I manually constructed a simple matrix, guarantee a situation for it to
percolate, and let intelliJ do the run.

Finally, I did several randomized automated runs with PercolationStats.
Visualizer seems 'buggy', so I avoided utilizing that.


/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to at most a few
 *  minutes. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be double the size of the preceding data point
 *****************************************************************************/

(keep T constant; n doubles)


 n          time (seconds)
------------------------------
10          0.258
20          0.429
40          0.860
80          2.784
when T = 50


(keep n constant; T doubles)

 T          time (seconds)
------------------------------
100         2.128
200         3.762
400         5.160
800        10.512
when n = 50

/******************************************************************************
 *  Using the empirical data from the above two tables, give an estimate
 *  of the running time of PercolationStats.java as function of both n and 
 *  T, using asymptotic notation, like:
 *
 *       O( n^5.0 * T^1.5 )
 *
 *  Recall that with asymptotic notation, you are interested in the
 *  growth rate of run time as input sizes grow - you drop lower-order
 *  terms and constant factors. In class, we've discussed a way to 
 *  estimate polynomial factors from empirical run times.
 *
 *  How does this estimate compare to the theoretical run time growth
 *  rate, according to analysis of your code?
 *
 *****************************************************************************/
I do not recall going over any measuring of big O notation from empirical data...

O ( N^(~4.27) * T^(~2.84)   )
I calculated rough estimates just by formula using wolframalpha.
I am completely prepared for incorrectly applying the formula and having incorrect
results.



/******************************************************************************
 *  Repeat the previous three questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant; n doubles)


 n          time (seconds)
------------------------------
10          0.219
20          0.484
40          0.842
80          2.009
when T = 50


(keep n constant; T doubles)

 T          time (seconds)
------------------------------
100         1.889
200         2.863
400         4.806
800        10.365
when n = 50




Run time estimate:
O ( N^(~8.86) * T^(~1.90)   )
Yeah, these proportions are definitely not right, lol.





 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Visualizer class is untested.



/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
 
 Special thanks for Travis for providing the stubs and meta direction for this
 assignment.

I encountered a slight logic error, where I assigned the union class to an
array of objects that hold arrays, rather than an object that has an array.
I discussed this with my brother, Daniel Olson, and he seemed to have a better
understanding of what it was that I was doing, and by that, I eventually
discovered my logic error, and explained it further with my brother.

I also discussed with Doug (the instructor) on how I should go about testing
my program if I am no longer encountering syntax or linguistic errors, but
am still concerned about logical errors, and recommended I do test runs of the
methods whith predictable and simple outcomes.


Doug also gave advise when I was struggling to understand how to impliment the
different statistical methods in PercolationStats, as my thinking was too
sophisticated, and probably not even possible, and the advice he gave was to
measure the number of open sites, rather than the indexes of those sites.


Lastly, I had help from Doug on a few math related problems (What exactly is
mean / standard deviation / conf invervals, how to properly represent formulas
for them)

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Getting corners or adjacent placements were a slight tackle. Out of range
index values were also kinda difficult to manage without an appropriate try catch
statement.




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed (or hated) doing it.                                             
 *****************************************************************************/


I enjoyed certain portions of this assignment more than others. Personally, I
am not very much so interested in getting 'measurables' out of a program, but I
do see the value in having them. Most of what I did on this project was done
in a previous manner (although not to quite this scale, and was done so in a
more spread out manner). In an application sense, this assignment was definitely
important; that I understand. I only wish I could've had more time to self-ruminate
and make progress independently.


