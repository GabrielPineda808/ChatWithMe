package com.chat.ChatWithMe.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration //WebSocket is a live connection between the front end and the server and STOMP organizes and structure our messages
@EnableWebSocketMessageBroker //Tells spring that this app will use websocket ot handle real time communication
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //Message broker - like a middle man for web socket communications like where they go and who they are from

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:5173")
                .withSockJS(); //defining an end point in our app for web sock connections allowing only http://localhost:1234
        // to send messages and with sock js means to support clients that dont support websock
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //set message broker
        registry.enableSimpleBroker("/topic"); //whoever is subsribed to /topic will receive a broadcast from our server /chat like /app/topic/room1 whoever is in this room 
        //tells server to process any request coming from /chat
        registry.setApplicationDestinationPrefixes("/app");
    }
}
