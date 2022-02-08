#include <windows.h>
#include <GL/gl.h>
#include <GL/glu.h>
#include <GL/glut.h>
#include <iostream>
#include <stdio.h>

using namespace std;

const int milliseconds_per_frame = 50;  // Time you would LIKE per frame
                                        // The actual time can be longer

int width;   // Current width of window
int height;  // Current height of window

float rotateX = 0.0;   // Amount of x-axis rotation of the entire scene
float rotateY = 0.0;   // Amount of y-axis rotation of the entire scene

bool ortho = false;     // True is orthographic, false is perspective

bool animating = false;

void init()
{
   glEnable(GL_BLEND);
   glEnable(GL_LINE_SMOOTH);
   glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
}

void timer(int id)
{
   rotateX += 7;  // The x and y rotation for the scene
   rotateY += 3;
   glutPostRedisplay();
}

void initTransformation()
{
   glMatrixMode(GL_PROJECTION);
   glLoadIdentity();
   double aspect = ((double)height)/((double)width);
   if (ortho) {
      if (aspect >= 1)
         glOrtho(-16,16,-16*aspect,16*aspect,30,70);
      else
         glOrtho(-16/aspect,16/aspect,-16,16,30,70);
   }
   else {
      if (aspect >= 1)
         glFrustum(-10,10,-10*aspect,10*aspect,30,70);
      else
         glFrustum(-10/aspect,10/aspect,-10,10,30,70);
   }
   glMatrixMode(GL_MODELVIEW);
   glLoadIdentity();
   gluLookAt(0,0,50,0,0,0,0,1,0);
   glRotatef(rotateX,1,0,0);  // Rotation of whole scene
   glRotatef(rotateY,0,1,0);
}

void drawObjects()
{
   glColor3f(1,1,1);
   glPushMatrix();
     glTranslatef(0,0,-8);
     glLineWidth(2);
     glLineWidth(1);
   glPopMatrix();

   glScalef(3,3,3);
   glColor3f(1,0,0);
   glPushMatrix();
     glScalef(5,1,2);
     glLineWidth(2);
     glutWireCube(1);
     glLineWidth(1);
   glPopMatrix();

   glPushMatrix();
     glTranslatef(0.5,0.75,0);
     glScalef(2,0.5,1.8);
     glLineWidth(2);
     glutWireCube(1);
     glLineWidth(1);
   glPopMatrix();

   glColor3f(0.4,0.4,1);
   glPushMatrix();
     glTranslatef(2.3,-0.4,1.3);
     glutWireTorus(0.2,0.33,24,12);
   glPopMatrix();

   glPushMatrix();
     glTranslatef(2.3,-0.4,-1.3);
     glutWireTorus(0.2,0.33,24,12);
   glPopMatrix();

   glPushMatrix();
     glTranslatef(-2.3,-0.4,1.3);
     glutWireTorus(0.2,0.33,24,12);
   glPopMatrix();

   glPushMatrix();
     glTranslatef(-2.3,-0.4,-1.3);
     glutWireTorus(0.2,0.33,24,12);
   glPopMatrix();

   glColor3f(0.8,0.8,0);
   glPushMatrix();
     glTranslatef(-2.5,0,-.6);
     glScalef(0.1,0.3,0.3);
     glutWireSphere(1,12,12);
   glPopMatrix();

   glPushMatrix();
     glTranslatef(-2.5,0,.6);
     glScalef(0.1,0.3,0.3);
     glutWireSphere(1,12,12);
   glPopMatrix();
}

void display()
{
   if (animating) {
      glutTimerFunc(milliseconds_per_frame,timer,1);
   }
   glClearColor(0,0,0,1);
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   initTransformation();  // Setup projection and view
   drawObjects();
   glFlush();
   glutSwapBuffers();
}

void reshape(int new_width, int new_height)
{
   glViewport(0,0,new_width,new_height);
   height = new_height;
   width = new_width;
}

void keyboard(unsigned char key, int x, int y)
{
   if (key == 27)
      exit(0);
   else if (key == 'a' || key == 'A') {
      animating = !animating;
      glutPostRedisplay();
   }
   else if (key == 'p' || key == 'P') {
      ortho = !ortho;
      if (!animating)
         glutPostRedisplay();
   }
}

void special(int key, int x, int y) {
   if (animating) return;

   switch (key) {
      case GLUT_KEY_LEFT :  rotateY -= 15;
                            break;
      case GLUT_KEY_RIGHT : rotateY += 15;
                            break;
      case GLUT_KEY_DOWN :  rotateX -= 15;
                            break;
      case GLUT_KEY_UP :    rotateX += 15;
                            break;
      case GLUT_KEY_INSERT : rotateY = 0;
                             rotateX =0;
                             animating = false;
    }
    glutPostRedisplay();
}

int main(int argc, char **argv) {

   cout << "\nInstructions:\n";
   cout << "   Arrow Keys rotate the object.\n";
   cout << "   The Insert key restores the object to its default orientation.\n";
   cout << "   The 'A' key starts and stops an animation.\n";
   cout << "   The 'P' key switches between perspective and orthographic projection.\n";
   cout << "   The Escape key ends the program.\n\n";

   glutInit(&argc,argv);
   glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH);
   glutInitWindowSize(500,500);
   glutInitWindowPosition(150,50);
   glutCreateWindow("Program Six");

   glutDisplayFunc(display);
   glutReshapeFunc(reshape);

   glutKeyboardFunc(keyboard);
   glutSpecialFunc(special);

   init();
   glutMainLoop();
}
