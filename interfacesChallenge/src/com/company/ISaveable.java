package com.company;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
     void write(List<Player> tobesavevalue);
     void read(ArrayList<Player> player);

}
