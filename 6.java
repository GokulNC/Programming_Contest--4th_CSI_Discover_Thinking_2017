This is not a binary tree, so we can't just use inorder traversal results to compare.

Instead, we're maintaining the list of all children of a node..

So, we should check if each corresponding levels of the 2 trees level by level..

We need to start from the bottomost level of the two trees.

We compare the children of all nodes in that level to check if they are somewhere equal..
We could use HashSet to check if a node in a tree is present in the other..
(Put into Set for first tree's node's children (names of employee) and check if all the  node's children in the other tree are present in Set; if not, it implies trees are not identical)

This idea can be recursively implemented, starting from bottom-most level to the first level of the 2 trees to be compared..

Sorry, but I don't know if there's any standard CS algorithm that can be used to solve this problem.

I am very eager to know if any :)