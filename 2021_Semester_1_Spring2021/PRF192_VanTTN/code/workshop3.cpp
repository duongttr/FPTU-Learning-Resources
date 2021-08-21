#include <iostream>
using namespace std;
int n,m,k,a[999999],b[999999],c[999999];
void enter(){
    cout<<"nhap chiu dai day a:";
    cin>>n;
    a[0]=-1;
    b[0]=-1;
    c[0]=-1;
    cout<<"day vua tao: ";
    for(int i=1;i<=n;i++){
        a[i]=rand()%91+10;
        cout<<a[i]<<" ";
    }
    cout<<endl;
    cout<<"nhap chieu dai mang b: ";
    cin>>m;
    for(int i=1;i<=m;i++){
        cin>>b[i];
    }
    cout<<"nhap vi tri chen b: ";
    cin>>k;

}
void insert_at(int k){
    for(int i=1;i<=k;i++){
        c[i]=a[i];
    }
    for(int i=1;i<=m;i++){
        c[k+i]=b[i];
    }
    for(int i=1;i<=n-k;i++){
        c[m+k+i]=a[k+i];
    }
}
int main()
{
    //cout << "Hello world!" << endl;
    enter();

    if ((k<0)||(k>n)){cout<<"ngu vl";}
    else {
        insert_at(k);
        for(int i=1;i<=n+m;i++){
            cout<<c[i]<<" ";
        }
    }
    return 0;
}
