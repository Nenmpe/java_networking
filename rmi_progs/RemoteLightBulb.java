package rmi_progs;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteLightBulb extends Remote {
    public void turnOn() throws RemoteException;
    public void turnOff() throws RemoteException;
    public boolean isOn() throws RemoteException;
}
