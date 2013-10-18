package com.sjtu.ic.dlmserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DLMServer {
	private static final int PORT=8099;
	private ServerSocket ss=null;
	
	public DLMServer() throws IOException{
		ss=new ServerSocket(PORT);
	}
	
	public void service(){
		while(true){
			try {
				Socket s=ss.accept();
				DLMRequestHandler wrh=new DLMRequestHandler(s);
				Thread t=new Thread(wrh);
				t.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		DLMServer ws = null;
		try {
			ws = new DLMServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws.service();
	}
}
