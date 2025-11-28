package playing.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {
    Engine engine;
    public void setEngine(Engine engine){
        this.engine = engine;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        String key = switch (e.getKeyCode()){
            case KeyEvent.VK_W,KeyEvent.VK_UP -> "UP";
            case KeyEvent.VK_A,KeyEvent.VK_LEFT -> "LEFT";
            case KeyEvent.VK_S,KeyEvent.VK_DOWN -> "DOWN";
            case KeyEvent.VK_D,KeyEvent.VK_RIGHT-> "RIGHT";
            default -> "NULL";
        };
        if (!"NULL".equals(key)) {
            engine.keyPress(key);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
