#ifndef _POINT_H_
#define _POINT_H_

#include <iostream>

using namespace std;


class Point {

friend class Circle;
public:
    Point();
    Point(double px, double py);

    double get_x();
    double get_y();

private:
    double x, y;
    double distance(Point d);
};

#endif
