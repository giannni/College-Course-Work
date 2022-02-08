#include <windows.h>
#include <iostream>
#include <math.h>
#include <GL/gl.h>
#include <GL/glu.h>
#include <GL\glut.h>


float posX=4, posY=6, posZ=5, targetX=0, targetY=0, targetZ=0, upX=0, upY=1, upZ=0;
float rotateAngle = 0.0;

// Clears the window and draw the teapot
void display() {

  glClear(GL_COLOR_BUFFER_BIT);

  // Set the camera lens to have a 60 degree (vertical) field of view, an
  // aspect ratio of 4/3, and have everything closer than 1 unit to the
  // camera and greater than 40 units distant clipped away.
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(60.0, 4.0/3.0, 1, 40);

  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();

 // Position camera
  gluLookAt(posX, posY, posZ, targetX, targetY, targetZ, upX, upY, upZ);

  // Draw a teapot
  glColor3f(1.0, 1.0, 1.0);
  glRotatef(rotateAngle, 0, 1, 0);
  glutWireTeapot(1.5);

  glFlush();
}

void usage(){
    //keyboard keys to perform
    std::cout<< "\n\n\
          a,A: Display Front View\n\
          w,W: Display Top View\n\
          d,D: Display Side View\n\
          s,S: Display Perspective View\n\
          r,R: Rotate teapot\n\n\n";
          std::cout.flush();
}

void KeyboardFunc (unsigned char key, int eyeX, int eyeY){
    switch (key){
       case 'a':
       case 'A': posX=0.0; posY=0.0; posZ=6.0;
                 upX=0; upY=1.0; upZ=0.0;
                 break;
       case 'w':
       case 'W': posX=0.0; posY=6.0; posZ=0.0;
                 upX=0; upY=0.0; upZ=-1.0;
                 break;
       case 'd':
       case 'D': posX=6.0; posY=0.0; posZ=0.0;
                 upX=0.0; upY=1.0; upZ=0.0;
                 break;
       case 's':
       case 'S': posX=4.0; posY=6.0; posZ=5.0;
                 upX=0; upY=1.0; upZ=0.0;
                 break;
        case 'r':
	    case 'R':
		         rotateAngle += 1.0;
		         break;
    }
    glutPostRedisplay();
}

void init() {
  // Set the current clear color to black and the current drawing color to white
  glClearColor(0.0, 0.0, 0.0, 1.0);
  glColor3f(1.0, 1.0, 1.0);
  usage();
}

// Initializes GLUT, the display mode, and main window; registers callbacks; enter  main event loop.
int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
  glutInitWindowPosition(300,250);
  glutInitWindowSize(800, 600);
  glutCreateWindow("Different Perspectives");
  init();
  glutDisplayFunc(display);
  glutKeyboardFunc(&KeyboardFunc); //input keyboard keys for drawing
  glutMainLoop();
}
