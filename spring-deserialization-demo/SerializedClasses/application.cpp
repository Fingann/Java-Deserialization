#include <iostream>
#include <fstream>
using namespace std;

int main() {
  // Create and open a text file
  ofstream MyFile("hacked.txt");

  // Write to the file
  MyFile << "This file has been created by a Java Deserialization Vulnerability";

  // Close the file
  MyFile.close();
}
