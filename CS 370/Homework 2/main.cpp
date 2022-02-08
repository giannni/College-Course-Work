#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <OpenGL/gl.h>
#include <OpenGl/glu.h>
#include <GLUT/glut.h>

void initGL()
{
    //black background and opaque
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    
}

void display()
{
    //Clear the buffer
    glClear(GL_COLOR_BUFFER_BIT);
    //Draw blue triangle
    glBegin(GL_TRIANGLES);
    glColor3f(0.0f, 0.0f, 1.0f);
    glVertex2f(-0.3f, 0.3f);
    glVertex2f(-0.3f, -0.3f);
    glVertex2f(0.0f, 0.0f);
    glEnd();
    //Draw blue polygon
    glBegin(GL_POLYGON);
    glColor3f(0.0f, 0.0f, 1.0f);
    glVertex2f(0.0f, 0.3f);
    glVertex2f(0.0f, -0.3f);
    glVertex2f(0.5f, -0.3f);
    glVertex2f(0.7f, 0.0f);
    glVertex2f(0.5f, 0.3f);
    glEnd();
    glFlush();
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowPosition(50, 50);
    glutInitWindowSize(400,400);
    glutCreateWindow("Space ship");
    glutDisplayFunc(display);
    initGL();
    glutMainLoop();
}
