package commm;


/*
*
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
* 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37）
* ，因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
* */
public class Solution29 {

    static int x=0;
    static int y=0;
    public static int movingCount(int threshold, int rows, int cols)
    {

        int[][] Bol=new int[rows][cols];//存放某点坐标是否已经走过
        return movingCountInter(threshold,rows,cols,0,0,Bol);
    }

    /*
    * x:当前坐标的横坐标
    * y:当前坐标的纵坐标
    *
    * */
    public static int movingCountInter(int threshold, int rows, int cols,int x,int y,int[][] Bol)
    {
        int result=0;
        /*判断当前位置是否可取*/
        if((x>=0&&x<=rows-1)&&(y>=0&&y<=cols-1)&&Bol[x][y]!=1&&sum(x,y)<=threshold){
            result++;
            Bol[x][y]=1;
            /*向右走*/
            result+= movingCountInter(threshold,rows,cols,x,y+1,Bol);
            /*向下走*/

            result+=movingCountInter(threshold,rows,cols,x+1,y,Bol);
            /*向左走*/

            result+=movingCountInter(threshold,rows,cols,x,y-1,Bol);
            /*向上走*/
            result+=movingCountInter(threshold,rows,cols,x-1,y,Bol);
        }else{
            return 0;
        }
        return  result;
    }

    /*计算坐标处的行坐标和列坐标的数位之和*/

    public static  int sum(int X,int Y){
        int total=0;
        while (X!=0){

            total+=X%10;
            X=X/10;
        }
        while (Y!=0){

            total+=Y%10;
            Y=Y/10;
        }
        return  total;

    }
    public static void main(String[] args) {

        int result=movingCount(5,10,10);
        System.out.println(result);//21

    }
}
