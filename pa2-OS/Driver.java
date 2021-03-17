

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	Network objNetwork = new Network( );            /* Activate the network */
        objNetwork.start();

        Server serverThread1 = new Server("Thread1");                        /* Start the server */
        serverThread1.start();
        Server serverThread2 = new Server("Thread2");                        /* Start the server */
        serverThread2.start();

        Client clientSendThread = new Client("sending");          /* Start the sending client thread */
        clientSendThread.start();
        Client clientReceiveThread = new Client("receiving");        /* Start the receiving client thread */
        clientReceiveThread.start();

        /*..............................................................................................................................................................*/
       
    }
    
 }
//busy waiting is better for the performance of individual threads. Overall however, it should result in a longer run time
//in a system with many threads as many many cpu cycles are waisted checking to see if a given thread should stop yielding.
//with as few threads as we have here, however, busy waiting proves to be faster, as the individual performance seems to
//outway the overall effect, seeing as though the overall system is comprised of few threads/
