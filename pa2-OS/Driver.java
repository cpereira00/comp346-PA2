

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

        Server serverThread = new Server("Thread1");                        /* Start the server */
        serverThread.start();
        Server serverThread2 = new Server("Thread2");                        /* Start the server */
        serverThread2.start();

        Client clientSendThread = new Client("sending");          /* Start the sending client thread */
        clientSendThread.start();
        Client clientReceiveThread = new Client("receiving");        /* Start the receiving client thread */
        clientReceiveThread.start();

        /*..............................................................................................................................................................*/
       
    }
    
 }
// server has 2 concurrent threads to update the accounts
// the synchro of network buffers are using busy-wait so we need to to block a thread when a buffer is full or empty.
//