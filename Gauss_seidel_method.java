package com.mytrails.java;

import java.util.Scanner;

class Dominant 
{
    int a11, a12, a13, a21, a22, a23, a31, a32, a33, d1, d2, d3;

    void dominantcheck() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coefficients of equation-1 : ");
        System.out.print("X-coefficient : ");
        a11 = sc.nextInt();
        System.out.print("Y-coefficient : ");
        a12 = sc.nextInt();
        System.out.print("Z-coefficient : ");
        a13 = sc.nextInt();
        System.out.print("d1 = ");
        d1 = sc.nextInt();

        System.out.println();

        System.out.println("Enter the coefficient of equation-2 : ");
        System.out.print("X-coefficient : ");
        a21 = sc.nextInt();
        System.out.print("Y-coefficient : ");
        a22 = sc.nextInt();
        System.out.print("Z-coefficient : ");
        a23 = sc.nextInt();
        System.out.print("d2 = ");
        d2 = sc.nextInt();

        System.out.println();

        System.out.println("Enter the coefficient of equation-3 : ");
        System.out.print("X-coefficient : ");
        a31 = sc.nextInt();
        System.out.print("Y-coefficient : ");
        a32 = sc.nextInt();
        System.out.print("Z-coefficient : ");
        a33 = sc.nextInt();
        System.out.print("d3 = ");
        d3 = sc.nextInt();
        System.out.println();
        sc.close();

        if ((a11 > (a12 + a13)) && (a22 > (a21 + a23)) && (a33 > (a31 + a32))) 
        {
            System.out.println("The given system of equations is diagonally dominant");
        } 
        else 
        {
            System.out.printf("The given system is not diagonally dominant\n");
        }
    }

    void rewriting() 
    {
        double x = 0, y = 0, z = 0;
        double prevX, prevY, prevZ;
        int iterations = 0;
        System.out.println("We can rewrite the given system of equations as : \n");
        do 
        {
            prevX = x;
            prevY = y;
            prevZ = z;

            x = (d1 - a12 * prevY - a13 * prevZ) / a11;
            y = (d2 - a21 * x - a23 * prevZ) / a22;
            z = (d3 - a31 * x - a32 * y) / a33;

            iterations++;

            System.out.println("Iteration - " + iterations);
            System.out.printf("x = %.4f\ny = %.4f\nz = %.4f\n\n", x, y, z);

            // Check for convergence
            if (Math.abs(x - prevX) < 0.0001 && Math.abs(y - prevY) < 0.0001 && Math.abs(z - prevZ) < 0.0001) 
            {
                break;
            }
        } while (true);
    }
}

public class Gauss_seidel_method 
{
    public static void main(String[] args) 
    {
        System.out.println("Enter the values in the below format : ");
        System.out.printf("a11 x + a12 y + a13 z = d1---(i)\na21 x + a22 y + a23 z = d2---(ii)\na31 x + a32 y + a33 z = d3---(iii)\n\n");
        Dominant d = new Dominant();
        d.dominantcheck();
        d.rewriting();
    }
}