#include "Point.h"

#include <iostream>
#include <math.h>


using namespace std;


Point::Point() {
    x = 0;
    y = 0;
}
Point::Point(double px, double py) {
    x = px;
    y = py;
}

double Point::get_x() {
    return x;
}
double Point::get_y() {
    return y;
}


double Point::distance(Point p) {
    return sqrt(pow(x - p.get_x(), 2) + pow(y - p.get_y(), 2));
}