package Pookimon.duelable;

import Pookimon.display.Display;

public interface Duelable {
    public String getName();
    /// 어택
    public boolean attack(Duelable attacked);
    public boolean attacked(Monster attack);
    public void init();
}
