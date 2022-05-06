package MQTT;

import org.eclipse.paho.client.mqttv3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Scanner;

public class PubSubController {

    public static void main(String[] args) {
        MqttClient client;
        String broker = "tcp://localhost:1883";
        String clientId = MqttClient.generateClientId();
        String pubTopic = "home/controllers/temp";
        String subTopicArray  [] = new String[] {"home/sensors/light", "home/sensors/temp"};
        int subQosArray [] = new int[] {1,2};
        int pubQos = 2;

        int sum[];

        Queue q = Queue.getInstance();

        // input stream initialization (from user keyboard)
        //BufferedReader inFromUser =
        //        new BufferedReader(new InputStreamReader(System.in));

        try {
            client = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(false); // false = the broker stores all subscriptions for the client and all missed messages for the client that subscribed with a Qos level 1 or 2

            // Connect the client
            System.out.println(clientId + " Connecting Broker " + broker);
            client.connect(connOpts);
            System.out.println(clientId + " Connected " + Thread.currentThread().getId());

            // Callback
            client.setCallback(new MqttCallback() {

                public void messageArrived(String topic, MqttMessage message) throws MqttException {
                    // Called when a message arrives from the server that matches any subscription made by the client
                    String time = new Timestamp(System.currentTimeMillis()).toString();
                    String receivedMessage = new String(message.getPayload());
                    System.out.println(clientId +" Received a Message! - Callback - Thread PID: " + Thread.currentThread().getId() +
                            "\n\tTime:    " + time +
                            "\n\tTopic:   " + topic +
                            "\n\tMessage: " + receivedMessage +
                            "\n\tQoS:     " + message.getQos() + "\n");

                    if(topic.equals("home/sensors/temp")){
                        // This make all crash
                        //q.Add(Integer.parseInt(receivedMessage));
                        System.out.println("in Queue");
                    }


                    /*
                    System.out.println("\n ***  Press 1 to send to HEATER *** \n");

                    int a;
                    // read a line from the user
                    try {
                        a = Integer.parseInt(inFromUser.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    if(a == 1){
                        // pass client, client id, pubqos
                        SendMessageToHeater(client, clientId, pubQos, pubTopic);
                    }

                     */

                }

                public void connectionLost(Throwable cause) {
                    System.out.println(clientId + " Connectionlost! cause:" + cause.getMessage()+ "-  Thread PID: " + Thread.currentThread().getId());
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    if (token.isComplete()) {
                        System.out.println(clientId + " Message delivered - Thread PID: " + Thread.currentThread().getId());
                    }
                }

            });

            System.out.println(clientId + " Subscribing ... - Thread PID: " + Thread.currentThread().getId());
            client.subscribe(subTopicArray,subQosArray);
            System.out.println(clientId + " Subscribed to topics : " +  Arrays.toString(subTopicArray));

            System.out.println("\n ***  Press a random key to send to heater if average > 20 *** \n");
            Scanner cmd = new Scanner(System.in);
            cmd.nextLine();


            // I can do all my stuff here
            System.out.println("\n ***  Press a random key to SEND TO HEATER *** \n");
            Scanner command = new Scanner(System.in);
            command.nextLine();

            // Send message to Heater
            int average = Queue.getInstance().AverageLastFive();
            if(average>20){
                // send OFF msg to Heater
                String payload = "off";
                MqttMessage message = new MqttMessage(payload.getBytes());
                // Set the QoS on the Message
                message.setQos(pubQos);
                System.out.println(clientId + " Publishing message: " + payload + " ...");
                client.publish(pubTopic, message);
                System.out.println(clientId + " Message published - Thread PID: " + Thread.currentThread().getId());
            } else {
                // send ON msg to Heater
                String payload = "on";
                MqttMessage message = new MqttMessage(payload.getBytes());
                // Set the QoS on the Message
                message.setQos(pubQos);
                System.out.println(clientId + " Publishing message: " + payload + " ...");
                client.publish(pubTopic, message);
                System.out.println(clientId + " Message published - Thread PID: " + Thread.currentThread().getId());
            }

            //client.disconnect();



        } catch (MqttException me ) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }

    }

    /*
    private static void SendMessageToHeater(MqttClient client, String clientId, int pubQos, String pubTopic) throws MqttException {
        // Send message to Heater
        int average = Queue.getInstance().AverageLastFive();
        if(average>20){
            // send OFF msg to Heater
            String payload = "off";
            MqttMessage message = new MqttMessage(payload.getBytes());
            // Set the QoS on the Message
            message.setQos(pubQos);
            System.out.println(clientId + " Publishing message: " + payload + " ...");
            client.publish(pubTopic, message);
            System.out.println(clientId + " Message published - Thread PID: " + Thread.currentThread().getId());
        } else {
            // send ON msg to Heater
            String payload = "on";
            MqttMessage message = new MqttMessage(payload.getBytes());
            // Set the QoS on the Message
            message.setQos(pubQos);
            System.out.println(clientId + " Publishing message: " + payload + " ...");
            client.publish(pubTopic, message);
            System.out.println(clientId + " Message published - Thread PID: " + Thread.currentThread().getId());
        }
    }


     */
}
