package com.aldebaran.qimessaging.helpers;

import com.aldebaran.qimessaging.Session;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALModule {

    protected com.aldebaran.qimessaging.Object service;
    protected boolean isAsynchronous = false;
    protected ALInterface alInterface;

    public ALModule(Session session) {
        try {
            service = session.service(getClass().getSimpleName());
            if(alInterface != null)
                alInterface.onALModuleReady();
        } catch (Exception e) {
            if(alInterface != null)
                alInterface.onALModuleException(e);
        }
    }

    public boolean isAsynchronous() {
        return isAsynchronous;
    }

    public void setAsynchronous(boolean isAsynchronous) {
        this.isAsynchronous = isAsynchronous;
    }

    public ALInterface getAlInterface() {
        return alInterface;
    }

    public void setAlInterface(ALInterface alInterface) {
        this.alInterface = alInterface;
    }
}
