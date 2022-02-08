//
//  main.cpp
//  MatrixMultiplication
//
//  Created by Gianni Esposito on 1/24/19.
//  Copyright © 2019 Gianni Esposito. All rights reserved.
//

#include <iostream>
#include <stdio.h>
void enterMatrixData(int firstMatrix[][10], int secondMatrix[][10], int row1, int row2, int column1, int column2);
void multiplyMatrix(int multipliedMatrix[][10], int firstMatrix[][10], int secondMatrix[][10], int row1, int row2, int column1, int column2);
void displayMatrix(int multipliedMatrix[][10], int row1, int column2);
int main()
{
    int row1, row2, column1, column2, i, j, k;
    int firstMatrix[10][10], secondMatrix[10][10];
    int multipliedMatrix[10][10];
    
    std::cout << "Enter rows and column for first matrix: ";
    std::cin >> row1 >> column1;
    
    std::cout << "Enter rows and column for second matrix: ";
    std::cin >> row2 >> column2;
    
	//if column 1 doesn't equal row 2 then you can do matrix multiplication
    if(column1 != row2)
    {
        std::cout << "Column of first matrix does not equal the row of the second matrix." << std::endl;

		std::cout << "Enter rows and column for first matrix: ";
		std::cin >> row1 >> column1;

		std::cout << "Enter rows and column for second matrix: ";
		std::cin >> row2 >> column2;
    }
    
	//Execute all functions in the proper order
    enterMatrixData(firstMatrix, secondMatrix, row1, row2, column1, column2);
    multiplyMatrix(multipliedMatrix, firstMatrix, secondMatrix, row1, row2, column1, column1);
    displayMatrix(multipliedMatrix, row1, column2);

	//pausing before exiting allows us to see the output without the window closing right away
	system("pause");
    return 0;
}

void enterMatrixData(int firstMatrix[][10], int secondMatrix[][10], int row1, int row2, int column1, int column2)
{
    int i,j;
    
    std::cout << std::endl << "Enter elements for matrix 1: " << std::endl;
    for(int i = 0; i < row1; i++)
    {
        for(int j = 0; j < column1; j++)
        {
            std::cout << "Enter elements a"<< i + 1 << j + 1 << ": ";
            std::cin >> firstMatrix[i][j];
        }
    }
    
    std::cout << std::endl << "Enter elements for matrix 2: " << std::endl;
    for(int i = 0; i < row2; i++)
    {
        for(int j = 0; j < column2; j++)
        {
            std::cout << "Enter elements b" << i + 1 << j + 1 << ": ";
            std::cin >> secondMatrix[i][j];
        }
    }
}

void multiplyMatrix(int multipliedMatrix[][10], int firstMatrix[][10], int secondMatrix[][10], int row1, int row2, int column1, int column2)
{
    int i,j,k;
    //set the multiplied matrix to 0
    for(int i = 0; i < row1; i++)
    {
        for(int j = 0; j < column2; j++)
        {
            multipliedMatrix[i][j] = 0;
        }
    }
    
    //multiply first and second matrix and then store into the multipied matrix
    for(int i = 0; i < row1; i++)
    {
        for(int j = 0; j < column2; j++)
        {
            for(int k = 0; k < column1; k++)
            {
                multipliedMatrix[i][j] = firstMatrix[i][j] * secondMatrix[k][j];
            }
        }
    }
}

void displayMatrix(int multipliedMatrix[][10], int row1, int column2)
{
    int i, j;
    
    std::cout << "Output Matrix:" << std::endl;
    for(i = 0; i < row1; i++)
    {
        for(j = 0; j < column2; j++)
        {
            std::cout << multipliedMatrix[i][j] << " ";
            if(j == column2 - 1)
                std::cout << std::endl << std::endl;
        }
    }
}