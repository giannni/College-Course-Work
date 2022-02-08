/*
* Space Invader
*/
#include <windows.h>
#include <iostream>
#include <GL/gl.h>
#include <GL/glu.h>
#include <GL\glut.h>

class MyPoints {
public: GLfloat x, y;
};

float posX = 0.0, posY = 0.0;
float cannonScale = .2;
float bunkerScale = .3;
float shipScale = .25;
float rotate = 0.0;

MyPoints bunker[6] =
{   {-0.5f,-0.5f}, {0.5,-0.5f},   {0.5f,0.5f},
    {0.4f,0.6f},   {-0.4,0.6f},   {-0.5f,0.5f}
};

MyPoints cannon[8] =
{
    {-0.5f,-0.3f}, {0.5,-0.3f},   {0.5f,0.3f}, {-0.5f,0.3f},
    {0.2f,0.3f},   {0.1f,0.55f},   {-0.1f,0.55f}, {0.1f,0.3f}
};

MyPoints ship[6] =
{
    {-0.5f,-0.3f}, {0.5,-0.3f},   {0.0f,0.0f},
    {0.5f,0.3f}, {-0.5f,0.3f}, {-1.0f,0.0f}
};


void drawBunker()
{
    glColor3f (0.0, 0.0, 1.0);
    glBegin(GL_POLYGON);
       for (GLint k=0; k<6; k++) {
           glVertex2f(bunker[k].x, bunker[k].y);
       };
    glEnd();
}

void drawCannon()
{
    glColor3f (1.0, 0.0, 0.0);
    glBegin(GL_POLYGON);
       for (GLint k=0; k<8; k++) {
           glVertex2f(cannon[k].x, cannon[k].y);
       };
    glEnd();
}

void drawShip()
{
    glColor3f (0.0, 1.0, 0.0);
    glBegin(GL_POLYGON);
       for (GLint k=0; k<6; k++) {
           glVertex2f(ship[k].x, ship[k].y);
       };
    glEnd();
}

// Function called to update rendering
void DisplayFunc(void)
{
    glClear(GL_COLOR_BUFFER_BIT);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(-1.0, 1.0, -1.0, 1.0);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    // draw bunkers
    for (int i=0; i<4; i++){
        glPushMatrix();
        glTranslatef(-.75+(i*0.5), 0, 0);
        glScalef (bunkerScale, bunkerScale, 0);
        drawBunker();
        glPopMatrix();
    }

    // draw cannon
    glLoadIdentity();
    glPushMatrix();
    glTranslatef(posX, posY-0.4f, 0);
    glScalef (cannonScale, cannonScale, 0);
    drawCannon();
    glPopMatrix();

    // draw ship
    glLoadIdentity();
    glPushMatrix();
    glTranslatef(0, 0.6, 0);
    glScalef (shipScale, shipScale, 0);
    glRotatef(rotate, 0.0f, 0.0f, 1.0f);
    drawShip();
    glPopMatrix();

    glFlush(); //
}

void KeyboardFunc(unsigned char key, int x, int y)
{
  switch (key)
  {
    case 'a':
    case 'A': posX -= 0.1f;
              break;
    case 'd':
    case 'D': posX += 0.1f;
              break;
    case 's':
    case 'S':
              break;
    case 'w':
    case 'W':
              break;
    case 'r':
    case 'R': rotate += 2;
              break;
    case 'q':
    case 'Q': exit(0);
              break;
  }
  glutPostRedisplay();
}

void init()
{
    glClearColor(1, 1, 1, 0);  // white background
}

void usage ()
{
  std::cout << "\n\n\
   a,A:  Move Left\n\
   d,D:  Move Right\n\
   s,S:  \n\
   w,W:  \n\
   r,R:  Rotate Ship\n\
   q,Q:  Quit\n\n";
  std::cout.flush();
}

int	main(int argc, char **argv)
{
  usage();  // Explain how to use program

  /* Creation of the window */
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);
  glutInitWindowSize(500, 400);
  glutInitWindowPosition(500,100);
  glutCreateWindow("Transformation Examples");

  /* Declaration of the callbacks */
  glutDisplayFunc(&DisplayFunc);
  glutKeyboardFunc(&KeyboardFunc);

  init();
  glutMainLoop();
}
