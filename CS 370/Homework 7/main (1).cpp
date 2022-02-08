#include <windows.h>
#include <iostream>
#include <math.h>
#include <GL/gl.h>
#include <GL/glu.h>
#include <GL/glut.h>

GLint winWidth=800, winHeight=600;
GLfloat theta=270.0, phi=180.0;
GLfloat r=8.0;
float posX=0.0, posY=0.0, posZ=0.0, targetX=0, targetY=0, targetZ=0, upX=0, upY=1, upZ=0;

void display(void)
{
  glClear(GL_COLOR_BUFFER_BIT);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60.0, 4.0/3.0, 2, 10);

  // Position camera
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  gluLookAt(posX, posY, posZ, targetX, targetY, targetZ, upX, upY, upZ);

  // draw axes
  glBegin(GL_LINES);
     glColor3f(1,0,0); glVertex3f(0,0,0); glVertex3f(4,0,0);
     glColor3f(0,1,0); glVertex3f(0,0,0); glVertex3f(0,4,0);
     glColor3f(0,0,1); glVertex3f(0,0,0); glVertex3f(0,0,4);
  glEnd();

  // draw teapot
  glColor3f(1.0,1.0,1.0);
  glutWireTeapot(1.5);

  glFlush();
}

void eyePosition( void ) {
   // Spherical to Cartesian conversion.
   posX = r * sin(theta*0.0174532) * sin(phi*0.0174532);
   posY = r * cos(theta*0.0174532);
   posZ = r * sin(theta*0.0174532) * cos(phi*0.0174532);
   // Reduce theta slightly to obtain another point on the same longitude line on the sphere.
   GLfloat dt=1.0;
   GLfloat eyeXtemp = r * sin(theta*0.0174532-dt) * sin(phi*0.0174532);
   GLfloat eyeYtemp = r * cos(theta*0.0174532-dt);
   GLfloat eyeZtemp = r * sin(theta*0.0174532-dt) * cos(phi*0.0174532);
   upX=eyeXtemp-posX;
   upY=eyeYtemp-posY;
   upZ=eyeZtemp-posZ;
   glutPostRedisplay();
}

void onMouseMove(int x, int y) {
   // Mouse point to angle conversion
   theta = (360.0/(double)winHeight)*(double)y*3.0; //3.0 rotations possible
   phi = (360.0/(double)winWidth)*(double)x*3.0;
   // Restrict the angles within 0~360 degrees
   if (theta > 360) theta = fmod((double)theta,360.0);
   if (phi > 360) phi = fmod((double)phi,360.0);
   eyePosition();
}

void KeyboardFunc(unsigned char key, int X, int Y)
{
  switch (key) {
    case 'q':
    case 'Q': exit(0);
  }
  glutPostRedisplay();
}

void usage()
{
  std::cout<<"\n\n\
       q,Q: Quit\n\n";
  std::cout.flush();
}

int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
  glutInitWindowSize(winWidth, winHeight);
  glutInitWindowPosition(400,200);
  glutCreateWindow("View a teapot");
  usage();
  glutDisplayFunc(display);
  glutKeyboardFunc(&KeyboardFunc);
  glutPassiveMotionFunc(onMouseMove);
  glutMainLoop();
}
