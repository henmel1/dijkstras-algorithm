Visual representation of Dijkstras shortest path algorithm as described in detail here: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/ 

The program uses simple circles and lines to represent nodes and the distances represented by a set matrix of numbers.
The lines' visual lengths are randomized; however, the actual length values in the matrix are not. This is to give a unique visual representation of the same data set each time the program is run.
The algorithm keeps track of which "paths" were used to get the shortest distance between the first node (node 0) and the other nodes. These paths are highlighted in blue.
The lines' lengths are displayed with numbers above the midpoint of the respective line.

How the matrix is converted to nodes and distances:

Each array within the matrix represents 1 node. The integers within the array are represented of the distance from that node to the node of the index, given a single line connects them directly. If there is no direct connection between the nodes, the index is filled with -1.
Essentially, the row of the matrix represents a node's direct connections to the other nodes, and the column of the matrix represents the distance of the connection between the node of index of the row and the node of the index of the column.

To use: 
Download dijkstras.jar and run.
