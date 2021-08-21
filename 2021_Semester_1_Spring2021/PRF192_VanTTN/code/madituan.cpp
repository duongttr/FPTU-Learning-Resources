#include <iostream>
#include <cstring>
using namespace std;

// `N × N` chessboard
#define N 8

// Below arrays detail all eight possible movements for a knight.
// It is important to avoid changing the sequence of the below arrays
int row[] = { 2, 1, -1, -2, -2, -1, 1, 2 , 2 };
int col[] = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };

// Check if `(x, y)` is valid chessboard coordinates.
// Note that a knight cannot go out of the chessboard
bool isValid(int x, int y)
{
    if (x < 0 || y < 0 || x >= N || y >= N) {
        return false;
    }

    return true;
}

// Recursive function to perform the knight's tour using backtracking
void knightTour(int visited[N][N], int x, int y, int pos)
{
    // mark the current square as visited
    visited[x][y] = pos;

    // if all squares are visited, print the solution
    if (pos >= N*N)
    {
      if(x == 7 && y == 7){
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++) {
                cout << visited[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;
      }
        // backtrack before returning
        visited[x][y] = 0;
        return;
    }

    // check for all eight possible movements for a knight
    // and recur for each valid movement
    for (int k = 0; k < 8; k++)
    {
        // get the new position of the knight from the current
        // position on the chessboard
        int newX = x + row[k];
        int newY = y + col[k];

        // if the new position is valid and not visited yet
        if (isValid(newX, newY) && !visited[newX][newY]) {
            knightTour(visited, newX, newY, pos + 1);
        }
    }

    // backtrack from the current square and remove it from the current path
    visited[x][y] = 0;
}

int main()
{
    // `visited[][]` serves two purposes:
    // 1. It keeps track of squares involved in the knight's tour.
    // 2. It stores the order in which the squares are visited.
    int visited[N][N];

    // initialize `visited[][]` by 0 (unvisited)
    memset(visited, 0, sizeof visited);

    int pos = 1;

    // start knight tour from corner square `(0, 0)`
    knightTour(visited, 0, 0, pos);

    return 0;
}
