#include <iostream>
#define maxp 9999999
using namespace std;
int n;
int max_find,min_find;
int a[maxp];
void enter(){
    cin>>n;
    cin>>min_find>>max_find;
    for(int i=1;i<=n;i++){
        a[i]=rand()%51;
        cout<<a[i]<<" ";
    }
    cout<<endl;
}
bool check(int x){
    if (x<=1) return false;
    if (x==2) return true;
    for (int i=2;i<=trunc(sqrt(x));i++){
        if (x%i ==0) return false;
    }
    return true;
}
void solve(){
    cout<<"cac so trong min va max:";
    for(int i=1;i<=n;i++){
        if ((a[i]<=max_find)&&(a[i]>=a[i])){
            cout<<a[i]<<" ";
        }
    }
    cout<<endl;
    cout<<"cac so nguyen to :";
    for(int i=1;i<=n;i++){
        if (check(a[i])) cout<<a[i]<<" ";
    }

}
int main()
{
    enter();
    solve();
    return 0;
}
