#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <set>
#include <string.h>
#include <sstream>

#define empty ""
#define nosolution "No solution."

using namespace std;
map<string, vector<string>> graph;

int main() {
    //Credit to many people for input stuff... Somehow was the hardest part of all of this.
    //in needs to be larger so that it can store 2 words later on
    char in[34];
    //Array of vectors - one for each possible length
    //Size = 16+1 because zero will never be used
    vector<string> dictionary[17];
    while (true) {
        gets(in);
        if (strcmp(in, empty) == 0) break;
        dictionary[strlen(in)].push_back(in);
    }

    int flush = 0;
    //17 for the same reason as the dictionary
    bool lengthsCalculated[17] = {false};
    while (gets(in) != NULL) {
        flush++;
        //Flush the output stream after the first doublet so nothing is repeated
        if (flush > 1) cout << endl;
        string start, end;
        stringstream s(in);
        s >> start >> end;

        //Make sure it can even have a doublet
        if (start.length() != end.length()) {
            cout << nosolution << endl;
        } else {
            if (!lengthsCalculated[start.length()]) {
                lengthsCalculated[start.length()] = true;
                vector<string> words = dictionary[start.length()];
                //Connect the adjacent nodes on the graph
                for (int i = 0; i < words.size(); i++) {
                    for (int j = i + 1; j < words.size(); j++) {
                        string wordOne = words[i];
                        string wordTwo = words[j];
                        int difference = 0;
                        for (int i = 0; i < wordOne.length(); i++) {
                            //Strings being arrays is nice
                            if (wordOne[i] != wordTwo[i]) difference++;
                        }
                        if (difference <= 1) {
                            graph[words[i]].push_back(words[j]);
                            graph[words[j]].push_back(words[i]);
                        }
                    }
                }
            }
            //BFS algorithm
            //Thanks Wikipedia
            map<string, string> parents;
            queue<string> visiting;
            visiting.push(start);
            parents[start] = "";
            bool foundPath = false;
            while (visiting.size() != 0) {
                //Pop doesn't just return the front of the queue so this is necessary
                string parent = visiting.front();
                visiting.pop();

                for (int i = 0; i < graph[parent].size(); i++) {
                    if (parents.find(graph[parent][i]) == parents.end()) {
                        visiting.push(graph[parent][i]);
                        parents[graph[parent][i]] = parent;
                        //Check if the current node is the same as what is needed
                        if (graph[parent][i] == end) {
                            foundPath = true;
                            break;
                        }
                    }
                }
                if (foundPath) {
                    break;
                }
            }
            //Construct the path to print or print nothing if a path isn't found
            vector<string> shortestPath;
            if (!foundPath) {
                cout << nosolution << endl;
                continue;
            }

            string nextParent = end;
            do {
                shortestPath.push_back(nextParent);
                nextParent = parents[nextParent];
            } while (shortestPath.back() != start);

            for (int i = shortestPath.size()-1; i >= 0; i--) {
                cout << shortestPath[i] << endl;
            }
        }
    }
}
