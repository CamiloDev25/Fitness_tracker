package org.surotec.finalprojectfitnesstracker.domain.exceptio;

public class ServiceException extends Exception{

    //custom exception
    public ServiceException(String message) {
        super(message);
    }
}
