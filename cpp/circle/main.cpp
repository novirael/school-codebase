#include "Circle.h"
#include "Point.h"

#include <iostream>


using namespace std;


int main()
{
    cout << "Circle and Point!\n";
    Point p1, p2;
    p1 = Point(1,2);
    p2 = Point(2,5.5);

    Circle c1;
    c1 = Circle(p1, 5);
    cout << c1.distance_from(p2) << '\n';

    return 0;
}
