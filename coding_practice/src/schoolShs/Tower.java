package schoolShs;
class Tower
{
int arr[][];
int a,p,b,q,c,r,k,n,count;
public Tower()
{
a=1;p=0;b=2;q=0;c=3;r=0;k=0;n=0;count=1;
    }
public void input(int nn)
{
n=nn;
arr=new int[4][n+1];
for (int i=0;i<4;i++) 
arr[i][0]=99999;
for (int i=1;i<=n;i++)
arr[1][i]=n-i+1;
p=n;
display();
while(r!=n)
{
if(k==0)
{
if(arr[a][p]<arr[b][q])
{
arr[b][q+1]=arr[a][p];
arr[a][p]=0;
p--; q++;
display();
    }
    else if(arr[a][p]<arr[c][r])
    {
        arr[c][r+1]=arr[a][p];
        arr[a][p]=0;
        p--; r++;
        display();
    }
    else if(arr[b][q]<arr[c][r])
    {
        arr[c][r+1]=arr[b][q];
        arr[b][q]=0;
        q--; r++;
        display();
    }
    else if(arr[b][q]<arr[a][p] && q%2==0)
    {
        arr[a][p+1]=arr[b][q];
        arr[b][q]=0;
        q--; p++;
        k=1;
        display();
    }
    else
     k=1;
}
else if(k==1)
{
if(arr[c][r]<arr[b][q])
{
arr[b][q+1]=arr[c][r];
arr[c][r]=0;
r--;q++;
display();
    }
    else if(arr[c][r]<arr[a][p])
    {
        arr[a][p+1]=arr[c][r];
        arr[c][r]=0;
        r--;p++;
        display();
    }
    else if(arr[b][q]<arr[a][p])
    {
        arr[a][p+1]=arr[b][q];
        arr[b][q]=0;
        q--;p++;
        display();
    }
    else if(arr[b][q]<arr[c][r] && q%2==1)
    {
        arr[c][r+1]=arr[b][q];
        arr[b][q]=0;
        q--;r++;
        display();
        k=0;
    }
    else
    k=0;
}
    }
}
void display()
{
System.out.println("Step "+count++ +" --->");
for (int i=n;i>=1;i--)
{
for (int j=1;j<=3;j++)
{
if(arr[j][i]==0)
System.out.print("\t");
else
System.out.print(arr[j][i]+"\t");
    }
    System.out.println();
}
}}