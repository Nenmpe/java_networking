package rmi_progs;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteLightBulbImpl extends UnicastRemoteObject implements RemoteLightBulb {
    boolean turnedOn;

    public RemoteLightBulbImpl() throws RemoteException {
        super();
        turnedOn = false; 
    }


    public void turnOn() throws RemoteException {
        turnedOn = true;
    }

    public void turnOff() throws RemoteException {
        turnedOn = false;
    }

    public boolean isOn() throws RemoteException {
        return turnedOn;
    }
}
