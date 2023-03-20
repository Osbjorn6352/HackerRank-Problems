#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    string inp, out;
    while (getline(cin, inp)) { //with STDIN as inp
        inp.erase(remove(inp.begin(), inp.end(), '\r'), inp.end());
        out = "";
        char op = inp[0];
        char type = inp[2];
        for (int i = 4; i < inp.size(); i++) { //start the loop after the second semicolon
            if (op == 'C') { //case combine
                if (i == 4 && type == 'C') { // if the item is a class we capitalize the first letter
                    out += toupper(inp[i]);
                    continue;
                }
                if(inp[i] == ' ') continue;
                if (i != 4 && inp[i-1] == ' ') { // in case there was a space before the char
                    out += toupper(inp[i]);
                    continue;
                }
                out += inp[i]; //add the char in the input string if none of the special cases are met
            }
            else { //case split
                if (inp[i] == '(') break; //methods will never have spaces, so if we need to split, we can stop reading from STDIN at ()
                if (isupper(inp[i]) && i != 4) { //in case there is an upper case character in the middle of the input string
                    out += " ";                  //divide words using spaces when we reach capital letters
                    out += (char) (inp[i] + 32); //add 32 to get lowercase version (ascii)
                    continue;
                }
                if (type == 'C' && i == 4) { // Class types start with a capital
                    out += (char) (inp[i] + 32); //convert first letter to lower case
                    continue;
                }
                out += inp[i];
            }
        }
        if (op == 'C' && type == 'M') {
            cout<<out + "()" <<endl; 
        }
        else {
            cout<<out<<endl;
        }
        
    }  
    return 0;
}
