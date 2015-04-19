#ifndef _CIRCLE_H_
#define _CIRCLE_H_

#include "Point.h"
#include <iostream>

using namespace std;


class Circle {

public:
    Circle();
    Circle(Point p, double rad);
    double distance_from(Point p);

private:
    Point center;
    double radius;
};

#endif
