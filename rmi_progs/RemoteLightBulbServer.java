package rmi_progs;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RemoteLightBulbServer {
    public static void main(String[] args) {
        try {
            RemoteLightBulbImpl bulb = new RemoteLightBulbImpl();
            Naming.rebind("rmi://localhost/RemoteLightBulb", bulb);
        } catch (RemoteException e) {
            System.out.println("RemoteException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
