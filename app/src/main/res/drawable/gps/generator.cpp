#include <iostream>
#include <fstream>
#include <cstdlib>
using namespace std;
#define __TEST__
#define MAXSIZE 100

typedef struct Point{
  int x, y;
}point;

point direction[8] = {{-1, -1}, {1, -1}, {1, -1}, {1, 0},
                      {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

int puzzle[MAXSIZE][MAXSIZE], check[MAXSIZE][MAXSIZE];

int Gen(int width, int height, point pos, int cnt, int N){
  int i;
  point next;

  if(cnt == N)  return 1;

  for(i = 0; i < 8; i++){
    next.x = pos.x + direction[i].x;
    next.y = pos.y + direction[i].y;

    if(next.x >= 0 && next.x < width &&
       next.y >= 0 && next.y < height &&
       check[next.x][next.y] != 1 &&
       puzzle[next.x][next.y] != 0){
         check[next.x][next.y] = 1;
         puzzle[next.x][next.y] = cnt+1;

         if(Gen(width, height, next, cnt+1, N))  return 1;

         check[next.x][next.y] = 0;
       }
  }
  return 0;
}

int main(){
  ifstream input;
  input.open("input.txt");

  int width, height;
  input >> width >> height;
  point start;
  do{
    start.x = rand() % width;
    start.y = rand() % height;
  }while(puzzle[start.x][start.y] != 0);
  int N = 0;
  for(int i = 0; i < width; i++){
    for(int j = 0; j < height; j++){
      input >> puzzle[i][j];
      if(puzzle[i][j] == 1) N++;
      check[i][j] = 0;
    }
  }
  check[start.x][start.y] = 1;
  puzzle[start.x][start.y] = 1;

  #ifdef __TEST__
  cout << "**********before**********" << endl;
  cout << "width : " << width << " , height : " << height << endl;
  for(int i = 0; i < width; i++){
    for(int j = 0; j < height; j++){
      cout << puzzle[i][j] << "\t";
    }
    cout << endl;
  }
  cout << "N : " << N << endl;
  cout << "start : " << start.x << ", " << start.y << endl;
  #endif

  Gen(width, height, start, 1, N);
  #ifdef __TEST__
  cout << "**********after**********" << endl;
  cout << "width : " << width << " , height : " << height << endl;
  for(int i = 0; i < width; i++){
    for(int j = 0; j < height; j++){
      cout << puzzle[i][j] << "\t";
    }
    cout << endl;
  }
  cout << "N : " << N << endl;
  #endif

}
