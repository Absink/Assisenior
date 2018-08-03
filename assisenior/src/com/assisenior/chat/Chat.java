package com.assisenior.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class Chat 
{

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException 
	{
		synchronized(clients)
		{
			for(Session client : clients)	//recupere les sessions ouvertes
			{								//et les messages envoyes
				if (!client.equals(session))
				{
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

	@OnOpen
	public void onOpen (Session session) 
	{
		// Add session to the connected sessions set
		//System.out.println("Open SESSION");
		clients.add(session);
	}

	@OnClose
	public void onClose (Session session) 
	{
		// Remove session from the connected sessions set
		//System.out.println("Close SESSION");
		clients.remove(session);
	}

}