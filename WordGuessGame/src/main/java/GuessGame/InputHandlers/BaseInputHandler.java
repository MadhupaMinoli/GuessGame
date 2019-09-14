/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.InputHandlers;
/**
 *
 * @author User
 */
public interface BaseInputHandler {
    public void initiateInputHanler(); //Any input event initiate 
    public void subscribeInput(CatchInput subscriber, String key);
    public void unSubscribeInput(String key);
    public void onInput(char pressedKey);
    public void removeInputHandler();
}
