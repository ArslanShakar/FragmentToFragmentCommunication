package com.practice.coding.fragmenttofragmentcommunication;

public interface Communicator {
    //by default interface methods are public but when implements and override then must write public ...
    // for more read notes getting better understanding
    void respond(String data);
}
