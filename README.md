# Multi-Threaded Stock Exchange
 A platform where buyers and sellers can access the same catalog at the same time using multithreading.
 
## Problem
Suppose We have decided to build our own online selling platform known as Amazing.com. We have multiple sellers and buyers registered with Amazing.com. It has open access for both buyers and sellers. The sellers add the items to the catalog and once the buyers make a purchase from the catalog, the corresponding item is removed from the catalog. For the sake of simplicity, we may assume all the items are of a single type such as books or shoes. We listed some sellers as “preferred” sellers who have donated We some money. The preferred sellers have been given a priority order based on the amount they have donated us. When buyers make a purchase, they would always be delivered an item listed by a seller who is higher in the priority order. For example assume sellers s1, s2, and s3 have listed their books in the catalog. Also assume the priority order as s1 > s2 > s3 (s1 is most preferred). Now buyers have to first purchase all the items listed by s1 before making a purchase from other sellers. Further, consider a situation where a buyer is buying
from s2 after all the items listed by s1 exhausted. In the meantime s1 again adds some items to the catalog. Once the current purchase from s2 completes, the next buyer must buy the item(s) listed by s1 before buying from any other seller. We may assume that the priorities are unique (no duplicates) and non-negative. In the starter code, the  priorities are given as simple integers. Assume the lower number to be of higher priority. Being a student We’re on a budget and can’t afford expensive infrastructure. As a result, We have very limited space for the catalog. At any time at most N items can be stored in the catalog. If the catalog is already full, then the sellers need to wait for some buyers to buy items before they can add their product to the catalog. Also, if the catalog is empty, then the buyers need to wait until a seller adds their items to the catalog. Our task is to implement the Seller and Buyer classes using Java Threads.

Here inventory is a queue from where sellers take products and enqueue that products to catalog queue. The catalog dequeues the products to the buyers according to the priority of the sellers who enqueues that product in the catalog.


## solution
### Implementation of a Circular Queue
For inventory queue, we implement a circular queue, in which we create two variables front and rear. Instead of shifting the nodes of the queue after each dequeue and enqueue, we move the position of front and rear for the sake of time effiency, we use this method to enqueue and dequeue elements from a queue.The main reason of creating a circular queue instead of a straight queue is to save memory and consume less space of the memory.

### Implementation of Priority Queue
For catalog queue, we must dequeue the element from the queue with the highest priority(i.e. lowest priority value).
enqueue function is same as circular queue. In dequeue function, we first compare the priority values of all the elements and return the element with the lowest priority value.

### Buyer class
In this class, function buy() has been implementated. Thread, which is working on this class waits untill the catalog (PriorityQueue) is empty. when the function in seller class sends the signal that some seller has put his product in catalog from inventory, This thread starts and consumes one item from catalog.And it sends the signal to all the threads of seller class that now catalog has some space of 1 item to put in from inventory. It also gives output "Consumed : (the priority value of the seller of that item) ". Finally the thread sleeps for some time.

### Seller class
In this class, function sell() has been implementated. The main work of this class is to fill the catalog so that buyers can buy products from catalog queue.. Thread, which is working on this class waits untill the catalog (Circular Queue) is full. when the function in Buyer class sends the signal that some buyer has consumed a product from catalog, this thread starts, take one item from inventory and put it in the catalog. It sends the signal to all the threads of Buyer class that now catalog is not empty. Finally the thread sleeps for some time.


Thanks 
Manoj Kumar
cs5180411@cse.iitd.ac.in

