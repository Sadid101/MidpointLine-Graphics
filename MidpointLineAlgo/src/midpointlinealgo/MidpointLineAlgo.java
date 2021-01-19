package midpointlinealgo;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class MidpointLineAlgo implements GLEventListener{
        
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
    //drawing 8
      
      MidpointLineAlgo(gl, 8,8,24,8);
      MidpointLineAlgo(gl, 12,24,28,24);
      MidpointLineAlgo(gl, 16,40,32,40);
      MidpointLineAlgo(gl, 8,8,16,40);
      MidpointLineAlgo(gl, 24,8,32,40);
    //drawing 3
      MidpointLineAlgo(gl, 40,8,56,8);
      MidpointLineAlgo(gl, 44,24,60,24);
      MidpointLineAlgo(gl, 48,40,64,40);
      MidpointLineAlgo(gl, 56,8,64,40);
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
   }

   

   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
   
   public void MidpointLineAlgo(GL2 gl, float x1, float y1, float x2, float y2) {
       gl.glPointSize(3.0f);
       gl.glColor3d(1, 0, 0);
       gl.glBegin(GL2.GL_POINTS);
       gl.glVertex2d(x1,y1);
       System.out.println("x1 "+x1);
       System.out.println("x2 "+x2);
       System.out.println("y1 "+y1);
       System.out.println("y2 "+y2);
       int zone=0;
       zone=findZone(zone, x1, y1, x2, y2);
       System.out.println("zoneee "+zone);
       //convertZone(zone, x1, y1, x2, y2);
       if(zone==0){
            
        }
        else if(zone==1){
           float temp=0; 
           temp=x1;
           System.out.println(x1);
           x1=y1;
           System.out.println(x1);
           y1=temp;
           
           temp=x2;
           x2=y2;
           y2=temp;
        }
        else if(zone==2){
           float temp=0; 
           temp=x1;
           x1=-y1;
           y1=temp; 
           
           temp=0; 
           temp=x2;
           x2=-y2;
           y2=temp;
        }
        else if(zone==3){
            x1=-x1;
            
            x2=-x2;
        }
        else if(zone==4){
            x1=-x1;
            y1=-y1;
            
            x2=-x2;
            y2=-y2;
        }
        else if(zone==5){
           float temp=0; 
           temp=x1;
           x1=-y1;
           y1=-temp;
           
           temp=0; 
           temp=x2;
           x2=-y2;
           y2=-temp;
        }
        else if(zone==6){
           float temp=0; 
           temp=x1;
           x1=y1;
           y1=-temp;
           
           temp=0; 
           temp=x2;
           x2=y2;
           y2=-temp;
           
        }
        else if(zone==7){
            y1=-y1;
            
            y2=-y2;
        }
        
       System.out.println("x1 "+x1);
       System.out.println("x2 "+x2);
       System.out.println("y1 "+y1);
       System.out.println("y2 "+y2);
       
       
       
       drawLine(gl, zone, x1, y1, x2, y2);
       gl.glEnd();
    }
    public int findZone(int zone, float x1, float y1, float x2, float y2){
        float dy=y2-y1;
        float dx=x2-x1;
        if(Math.abs(dx)>Math.abs(dy)){
            if(dx>0 && dy>0){
                zone=0;
            }
            else if(dx>0 && dy<0){
                zone=3;
            }
            else if(dx>0 && dy<0){
                zone=7;
            }
            else if(dx<0 && dy<0){
                zone=4;
            }
        }
        if(Math.abs(dy)>Math.abs(dx)){
            if(dx>0 && dy>0){
                zone=1;
            }
            else if(dx>0 && dy<0){
                zone=6;
            }
            else if(dx<0 && dy>0){
                zone=2;
            }
            else if(dx<0 && dy<0){
                zone=5;
            }
        }
        System.out.println("zone: "+zone);
        return zone;
        
    }
   
   
   
//    public void convertZone(int zone, float x1, float y1, float x2, float y2){
//        if(zone==0){
//            
//        }
//        else if(zone==1){
//           float temp=0; 
//           temp=x1;
//           System.out.println(x1);
//           x1=y1;
//           System.out.println(x1);
//           y1=temp;
//           
//           temp=x2;
//           x2=y2;
//           y2=temp;
//        }
//        else if(zone==2){
//           float temp=0; 
//           temp=x1;
//           x1=-y1;
//           y1=temp; 
//           
//           temp=0; 
//           temp=x2;
//           x2=-y2;
//           y2=temp;
//        }
//        else if(zone==3){
//            x1=-x1;
//            
//            x2=-x2;
//        }
//        else if(zone==4){
//            x1=-x1;
//            y1=-y1;
//            
//            x2=-x2;
//            y2=-y2;
//        }
//        else if(zone==5){
//           float temp=0; 
//           temp=x1;
//           x1=-y1;
//           y1=-temp;
//           
//           temp=0; 
//           temp=x2;
//           x2=-y2;
//           y2=-temp;
//        }
//        else if(zone==6){
//           float temp=0; 
//           temp=x1;
//           x1=y1;
//           y1=-temp;
//           
//           temp=0; 
//           temp=x2;
//           x2=y2;
//           y2=-temp;
//           
//        }
//        else if(zone==7){
//            y1=-y1;
//            
//            y2=-y2;
//        }
//        
//       System.out.println("ZONEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//       System.out.println("x1 "+x1);
//       System.out.println("x2 "+x2);
//       System.out.println("y1 "+y1);
//       System.out.println("y2 "+y2);
//    }
    
    
    
    
//    public void convertZoneBack(int zone, float x1, float y1, float x2, float y2){
//        
//        if(zone==0){
//            x2=x1;
//            y2=y1;
//        }
//        else if(zone==1){
//            x2=y1;
//            y2=x1;
//        }
//        else if(zone==2){
//            x2=-y1;
//            y2=x1;
//        }
//        else if(zone==3){
//            x2=-x1;
//            y2=y1;
//        }
//        else if(zone==4){
//            x2=-x1;
//            y2=-y1;
//        }
//        else if(zone==5){
//            x2=-y1;
//            y2=-x1;
//        }
//        else if(zone==6){
//            x2=y1;
//            y2=-x1;
//        }
//        else if(zone==7){
//            x2=x1;
//            y2=-y1;
//        }
//        
//   }
    
    
    
    public void drawLine(GL2 gl, int zone, float x1, float y1, float x2, float y2){
        System.out.println("Here");
        float dy=y2-y1;
        float dx=x2-x1;
        float dinit=2*dy-dx;
        float dne=2*dy-2*dx;
        float de=2*dy;
        float d=dinit;
        float xnew=0;
        float ynew=0;
        while(x1<x2 || y1<y2){
            System.out.println("d: "+d);
            if(d<=0){
                System.out.println("dE");
                d+=de;
                x1+=1;
            }
            else{
                System.out.println("dNE");
                d+=dne;
                x1+=1;
                y1+=1;
            }
            //convertZoneBack(zone,x1,y1,xnew,ynew);
            if(zone==0){
            xnew=x1;
            ynew=y1;
        }
        else if(zone==1){
            xnew=y1;
            ynew=x1;
        }
        else if(zone==2){
            xnew=-y1;
            ynew=x1;
        }
        else if(zone==3){
            xnew=-x1;
            ynew=y1;
        }
        else if(zone==4){
            xnew=-x1;
            ynew=-y1;
        }
        else if(zone==5){
            xnew=-y1;
            ynew=-x1;
        }
        else if(zone==6){
            xnew=y1;
            ynew=-x1;
        }
        else if(zone==7){
            xnew=x1;
            ynew=-y1;
        }
            System.out.println("xnew "+xnew);
            System.out.println("ynew "+ynew);
            gl.glVertex2d(xnew, ynew);
        }
    }

   
   
   
   
   
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      MidpointLineAlgo l = new MidpointLineAlgo();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;