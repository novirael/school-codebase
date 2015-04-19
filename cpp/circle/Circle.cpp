#include "Circle.h"
#include "Point.h"

#include <iostream>


using namespace std;


Circle::Circle() {
    center = Point();
    radius = 0;
}
Circle::Circle(Point p, double rad) {
    center = p;
    radius = rad;
}

double Circle::distance_from(Point p) {
    return center.distance(p);
}
