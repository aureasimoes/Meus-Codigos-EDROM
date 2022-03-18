package Behavior;


import Thread.EdromSensors;
import Motors.EdromMotor; 
import Motors.EdromBasicMotor; 
import Definicores.*;
import robo.EV3;
import Moviments.MovEdrom;
import MovColors.AlineColor;
import Movements_Arena.Rampa; 


public class BehaviorMovimentacao {

 

    public void WalkCollectionArea() { 

        EV3.step();

        while ((EdromSensors.GetCorL() != Colors.White || EdromSensors.GetCorR() != Colors.White) && EV3.step() != -1){ 
    
       //     System.out.println("Cor:" + EdromSensors.GetCorL() + EdromSensors.GetCorR()); 
            MovEdrom.Straight(-10);
          } 
          
            MovEdrom.StopBould(); 
            System.out.println("alinhamento");
            MovEdrom.AlineSentido(-1);
            Alinhar(Colors.White, Colors.Black);  
            MovEdrom.ResetAline();          
        }
    
    public void WalkRamp() {  
 
      System.out.println("WalkRamp"); 
        while (EdromSensors.GetCorC() != Colors.Green && EdromSensors.GetCorL() != Colors.Green && EdromSensors.GetCorR() != Colors.Green && EV3.step() != -1
               /*&& EdromSensors.GetCorC() != Colors.InterSek && EdromSensors.GetCorL() != Colors.InterSek && EdromSensors.GetCorR() != Colors.InterSek*/){   
          //System.out.println(EdromSensors.GetCorL()); 
          //System.out.println(EdromSensors.GetCorR()); 
          //System.out.println(EdromSensors.GetCorC()); 
          MovEdrom.Straight(-10);
        }
          System.out.println("Vi verde!"); 
          MovEdrom.StopBould(); 
          Rampa.Descer();  
          System.out.println("Desceu");
     
      }
    public void WalkGasoduto() {   
          
          
   //    System.out.println("cor" + EdromSensors.GetCorL() + EdromSensors.GetCorR());
       System.out.println("alinhamento");
       MovEdrom.FowerdDist(-0.2, 10); 
       MovEdrom.TurnRight(); 
       System.out.println("_____________________________________________________________");
       while ((EdromSensors.GetCorL() == Colors.Blue || EdromSensors.GetCorR() == Colors.Blue)&& EV3.step() != -1){ 
       
      //  System.out.println("Cor:" + EdromSensors.GetCorL() + EdromSensors.GetCorR()); 
        MovEdrom.Straight(-6); 
        
         
   }    
            
       MovEdrom.ResetAline(); 
       MovEdrom.StopBould(); 
       MovEdrom.SetErroMin(100.0);
       MovEdrom.SetVelMin(3.0, 3.0);
       MovEdrom.AlineSentido(1);
       MovEdrom.ColorAline(Colors.Blue2, Colors.Hole2);
       MovEdrom.StopBould();  
       System.out.println("Caiu 2");
       MovEdrom.FowerdDist(0.1, 10);
       MovEdrom.ResetAline();
       MovEdrom.TurnRight(); 
       AlinhamentoFinal(); 
     
    }
    public void Alinhar (Colors Cor1, Colors Cor2) {

      System.out.println("Cor:" + Cor1 + Cor2); 
      System.out.println("Cor:" + EdromSensors.GetCorL() + EdromSensors.GetCorR()); 
        MovEdrom.FowerdDist(-0.05, 10);
        System.out.println("alinhamento");
        MovEdrom.ColorAline(Cor1, Cor2);
        System.out.println("alinhamento2");
        MovEdrom.StopBould();  
    }
         
    public void  MudarDirecao() {

        MovEdrom.FowerdDist(0.15, 10);
        MovEdrom.TurnLeft();
        
    while ((EdromSensors.GetCorL() != Colors.Hole || EdromSensors.GetCorR() != Colors.Hole )&& EV3.step() != -1){ 
       
     //    System.out.println("Cor:" + EdromSensors.GetCorL() + EdromSensors.GetCorR()); 
         MovEdrom.Straight(-10); 
    } 
        MovEdrom.StopBould(); 
        MovEdrom.SetErroMin(5.0);
        MovEdrom.ResetAline();

    }
 
    public void AlinhamentoFinal(){
        
        
        while (EdromSensors.GetInFFre() >= 0.45 && EV3.step() != -1){  
    
    System.out.println("distancia" + EdromSensors.GetInFFre()); 
      MovEdrom.Straight(8); 
   
      }
      
      MovEdrom.StopBould();   
      MovEdrom.TurnLeft(); 
      
while ((EdromSensors.GetCorL() == Colors.Blue || EdromSensors.GetCorR() == Colors.Blue)&& EV3.step() != -1){ 
       
 //   System.out.println("Cor:" + EdromSensors.GetCorL() + EdromSensors.GetCorR()); 
        MovEdrom.Straight(-6); 
           
   }  
   
      MovEdrom.ResetAline();
      MovEdrom.StopBould(); 
      MovEdrom.SetErroMin(80.0); 
      MovEdrom.SetVelMin(3.0, 3.0);
      MovEdrom.AlineSentido(1);
      MovEdrom.ColorAline(Colors.Blue2, Colors.Hole2);
      MovEdrom.StopBould();  
      System.out.println("Caiu 3");
      MovEdrom.ResetAline();
    }
     
    public void Posicionar(){
     

    MovEdrom.ResetAline();
     WalkCollectionArea();
     WalkRamp();
     WalkGasoduto();
     MovEdrom.ResetAline();
    }
} 
