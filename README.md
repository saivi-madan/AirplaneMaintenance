Questions that I had:

    - Question: Are duplicates possible?

    - Do we have a max on number of mechanics we have access to

    - Is it possible to find a sub-optimal solution? and How would I find the optimal one

    - Is it possible for the list to be empty? What should I return in that case?

    - Is the input list sorted in any way?


Assumptions that I made:

    - The first assumption that I made was that each mechanic does not need a break
    I am assuming here that they are physically capable of working on one aircraft for 5
    hours and going straight into working on another aircraft

    - The next assumption that I made was that the list is guarenteed to be valid. I am
    assuming that no error was made on the users behalf when inputting airplane times. I
    also assume that all schedules fall within the 24 hour time period.

    - In relation to the questions I asked earlier, I assumed that duplicates are possible, 
    we can have as many mechanics as we need, and that if the list is empty I will return 0. 
    I am also assuming that our parameter list is not sorted in any way.

Thought Process(Alternate solution)

    My intial thought when looking at this problem was to use a hashmap to store expanded 
    intervals as my keys with each interval pointing to a list of airplane schedules that 
    did not overlap. Then I would simply return the size of my map to get the number of mechanics 
    needed. While this sounds simple, I found implementing it to be quite difficult and not be 
    efficient in terms of space and time. I found that for every schedule, I would have to loop 
    through my hashmap and potentially every single element in each list associated with my 
    values of my hashmap My outer loop would run for each airplane in the list(n) and my inner 
    loop would iterate through existing intervals in my map worst case going through all of them. 
    This runtime would be at least O(n^2) which is not very efficient
    
Thought Process(Implemented solution)

    Instead, I decided to find a new, more efficient approach. This time I decided to calculate 
    it by creating a count mechanics and by utilizing sorting. If I found a way to sort my 
    intervals by start and end time, I could then calculate all the number of mechanics I 
    would need at each time interval. The maximum amount of mechanics needed at any time within 
    my sorted list is what I need to return. I decided the best way is to split up my intervals into
    starting and ending times and use an integer to denote which was which. I chose 1 for starting
    times since each additional starting time causes our mechanic count to increase by 1 and -1 for
    ending times since each ending time needs to have my mechanic count decrease by 1(or increase
    by -1). The subtle case that I need to consider is how to sort ties when one is starting and
    the other is ending. According to the spec, end times are exclusive and start times are 
    inclusive, thus I must order ties with end times coming first. If I do not, I will overestimate
    the amount of mechanics needed. The runtime of my solution is O(nlogn) as that is the time it
    takes for the sort to occur. The space complexity is O(N) because of the size of the "breakdown"
    list.

Also Considered

    - Creating a Pair class to pair time with either start or end instead of using 1, -1. Chose not
    to do because the 1 and -1 was useful to me later

    - Using a priority queue instead and creating a class to determine priority for my schedule. Chose
    not to do because required overwriting the comparator method when the Collections.sort has one for
    integers already.

