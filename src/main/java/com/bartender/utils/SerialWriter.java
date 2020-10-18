package com.bartender.utils;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;

public class SerialWriter {
    private static SerialPort sp;
    private static boolean serialOpened = false;
    public static void openPort(String portName) throws IOException {
        if(serialOpened) {
            return;
        }
        sp = SerialPort.getCommPort(portName);
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        if (sp.openPort(2000)) {
            System.out.println("Port is opened " + sp.getSystemPortName());
            serialOpened = true;
        } else {
            System.out.println("Port is not opened " + sp.getSystemPortName());
            serialOpened = false;
        }
    }
    public static void sendStringToSerialPort(String msg) {
            if (sp.isOpen()) {
                sp.writeBytes(msg.getBytes(), msg.length());
                System.out.println("Data " + msg + " is sended");

            } else {
                System.out.println("Port is not opened " + sp.getSystemPortName());
                serialOpened = false;
            }

    }
}
