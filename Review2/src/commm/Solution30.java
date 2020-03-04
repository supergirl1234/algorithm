package commm;

/*
*
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
* 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
* 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
* 例如
a b c e
s f c s
a d	e e
矩阵中包含一条字符串"bcced"的路径，
但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
* */
public class Solution30 {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        boolean result=false;
        char[][] chars=new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                chars[i][j]=matrix[i*cols+j];
            }

        }
        boolean[][] bol=new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                /*    if (chars[i][j] == str[0]&&!bol[i][j]) {
                        bol[i][j] = true;
                        result= hasPathInner(chars,rows,cols,str,1,i,j+1,bol)||
                                hasPathInner(chars,rows,cols,str,1,i,j-1,bol)||
                                hasPathInner(chars,rows,cols,str,1,i+1,j,bol)||
                                hasPathInner(chars,rows,cols,str,1,i-1,j,bol);
                    }*/
                    result= hasPathInner(chars,rows,cols,str,0,i,j,bol);
                    if(result){
                       return  true;
                    }
                }


        }

        return  false;
    }


    public boolean hasPathInner(char[][] chars, int rows,int cols,char[] str,int index,int x,int y,boolean[][] bol){

        if(index>=str.length){
            return  true;
        }

        if(x<0||x>=rows||y<0||y>=cols||chars[x][y]!=str[index]||bol[x][y]==true){

            return  false;
        }
      /*  if((x>=0&&x<rows)&&(y>=0&&y<cols)){


            if(chars[x][y]==str[index]&&bol[x][y]==false){

                return true;
            }
        }*/

      bol[x][y]=true;
        boolean result=  hasPathInner(chars,rows,cols,str,index+1,x,y+1,bol)||
                hasPathInner(chars,rows,cols,str,index+1,x,y-1,bol)||
                hasPathInner(chars,rows,cols,str,index+1,x+1,y,bol)||
                hasPathInner(chars,rows,cols,str,index+1,x-1,y,bol);
        bol[x][y]=false;

        return  result;
    }
    public static void main(String[] args) {

    }
}
