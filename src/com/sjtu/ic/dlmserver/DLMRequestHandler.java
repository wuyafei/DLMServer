package com.sjtu.ic.dlmserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DLMRequestHandler implements Runnable {

	private Socket socket=null;
	public DLMRequestHandler(Socket s){
		socket=s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			processGetRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processGetRequest() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line=br.readLine();
        System.out.println(line);

        while( (line = br.readLine()) != null) {
            //System.out.println(line);
            
            if(line.equals("")) 
            	break;
        }
        String signupMsg=br.readLine();
        System.out.println(signupMsg);
        
        PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/plain;charset=x-user-defined");
        pw.println();
        pw.println("Signup OK!");
        
        br.close();
        pw.close();
        socket.close();
	}

}

