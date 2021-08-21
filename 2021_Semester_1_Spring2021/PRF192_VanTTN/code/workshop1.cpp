#include <iostream>
#define maxp 9999999
using namespace std;
int n;
int a[maxp];
void enter(){
    cin>>n;
    for(int i=1;i<=n;i++){
        a[i]=rand()%51;
        cout<<a[i]<<" ";
    }
    cout<<endl;

}
void solve(){
    int maxc=-1,pos_max,pos_min;
    int minc=99999999;
    int sum=0;
    for(int i=1;i<=n;i++){
        if (a[i]>maxc){
            pos_max=i;
            maxc=a[i];
        }
        if (a[i]<minc){
            pos_min=i;
            minc=a[i];
        }
        sum+=a[i];
    }
    cout<<maxc<<" "<<pos_max<<endl;
    cout<<minc<<" "<<pos_min<<endl;
    cout<<sum<<" "<<sum/n;
}
int main()
{
    enter();
    solve();
    return 0;
}
