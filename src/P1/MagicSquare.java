package P1;

import java.util.*;
import java.io.*;

public class MagicSquare {
    public static int[][] MSquare = new int[300][300];

    public static void main(String[] args) throws IOException {
        System.out.println(String.valueOf(isMagicSquare("src\\P1\\txt\\1.txt")));
        System.out.println(String.valueOf(isMagicSquare("src\\P1\\txt\\2.txt")));
        System.out.println(String.valueOf(isMagicSquare("src\\P1\\txt\\3.txt")));
        System.out.println(String.valueOf(isMagicSquare("src\\P1\\txt\\4.txt")));
        System.out.println(String.valueOf(isMagicSquare("src\\P1\\txt\\5.txt")));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateMagicSquare(n);
        sc.close();
        System.out.println(String.valueOf(isMagicSquare("src\\P1\\txt\\6.txt")));
        
    }

    public static boolean isMagicSquare(String fileName) throws IOException {
        int num0=0;
        int num1=0;
        boolean[] vis=new boolean[400001];
        try {
            File fP= new File(fileName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fP));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            String[] sp = line.split("\t");
            num0=sp.length;
            int row=0;
            while (line != null) {
                String[] sp1 = line.split("\t");
                num1=sp1.length;
                if(num1==num0)
                {
                    for(int i=0;i<num1;i++)
                    {
                        try{
                            MSquare[row][i]=Integer.valueOf(sp1[i]);
                            if (vis[MSquare[row][i]]==true)
                            {
                                System.out.println("Contain Same Number");
                                br.close();
                                return false;
                            }
                        }catch (Exception e)
                        {
                            System.out.println("data is not illegal");
                            br.close();
                            return false;
                        }

                    }
                    row++;
                    line = br.readLine();
                }
                else
                {
                    System.out.println("Not Square");
                    br.close();
                    return false;
                }

            }
            br.close();
            if(row!=num0)
            {
                System.out.println("Not Square");
                return false;
            }
            int sum=0;
            int sum1=0;
            for(int i=0;i<num0;i++)
            {
                sum+=MSquare[i][i];
                sum1+=MSquare[num0-1-i][i];
            }
            if(sum1!=sum)
            {
                System.out.println("sum diff");
                return false;
            }
            for(int i=0;i<num0;i++)
            {
                int tsum=0;
                int tsum1=0;
                for (int j=0;j<num0;j++)
                {
                    tsum +=MSquare[i][j];
                    tsum1 +=MSquare[j][i];
                }
                if(tsum!=sum||tsum1!=sum)
                {
                    System.out.println("sum diff");
                    return false;
                }
            }
            return true;

        } catch (Exception e) {
            System.out.println("IO exception, this file is empty");
            return false;
        }
    }

    public static boolean generateMagicSquare(int n) throws IOException
    {
        if(n<=0||n%2==0)
        {
            System.out.println("n is illegal");
            File file=new File("src\\P1\\txt\\6.txt");
            PrintWriter output = new PrintWriter(file);
            output.close();
            return false;
        }
        int magic[][] = new int[n][n];
        int row =0,col= n/2,i,j,square = n*n;

        for(i=1;i<=square;i++)
        {
            magic[row][col]=i;
            if(i%n==0)
            {
                row++;
            }
            else {
                if(row==0)
                    row=n-1;
                else
                    row--;
                if(col==(n-1))
                    col=0;
                else
                    col++;
            }
        }
        File file=new File("src\\P1\\txt\\6.txt");
        PrintWriter output = new PrintWriter(file);
        
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                output.print(magic[i][j] + "\t");
            output.println();
        }
        output.close();
        return true;
    }

}
