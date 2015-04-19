#include <iostream>


struct IncorrectValueException : public exception
{
   IncorrectValueException() {}
   ~IncorrectValueException() throw () {}
   const char* what() const throw() { 
       return "Expect small letters which belongs to hexadecimal alphabet"; 
   }
};
