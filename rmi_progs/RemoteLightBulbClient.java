package rmi_progs;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RemoteLightBulbClient {
    public static void main(String[] args) {
        try {
            String register = "rmi://localhost/RemoteLightBulb";
            RemoteLightBulb bulb = (RemoteLightBulb) Naming.lookup(register);

            System.out.println("Connected to RemoteLightBulb service.");

            boolean status = bulb.isOn();
            System.out.println("Initial bulb status: " + (status ? "ON" : "OFF"));

            if (!status) {
                System.out.println("Turning bulb ON...");
                bulb.turnOn();

                status = bulb.isOn();
                if (status) {
                    System.out.println("Bulb successfully turned ON.");
                } else {
                    System.out.println("Failed to turn ON the bulb.");
                }
            } else {
                System.out.println("Bulb is already ON.");
            }

        } catch (NotBoundException e) {
            System.err.println("The specified name is not currently bound in the registry.");
            e.printStackTrace();
        } catch (RemoteException e) {
            System.err.println("RemoteException occurred while communicating with the remote object.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}
