/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.InputHandlers;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class KeyBoardInputHandler implements BaseInputHandler,KeyEventDispatcher{
    private final HashMap<String, CatchInput> subscribers;
    
    public KeyBoardInputHandler() {
        this.subscribers = new HashMap<>();
    }

    @Override
    public void initiateInputHanler() {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_TYPED) {
        char pressedKey = e.getKeyChar();
       
        onInput(pressedKey);

      }
        return false;
    }

    @Override
    public void subscribeInput(CatchInput subscriber, String key) {
        this.subscribers.put(key, subscriber);
    }

    @Override
    public void unSubscribeInput(String key) {
        this.subscribers.remove(key);
    }

    @Override
    public void removeInputHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInput(char pressedKey) {
        this.subscribers.entrySet().forEach((Map.Entry<String, CatchInput> entry) -> {
            entry.getValue().onInput(pressedKey);  
           
        });
    }
    
}
