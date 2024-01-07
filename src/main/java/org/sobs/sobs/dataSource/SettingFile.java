package org.sobs.sobs.dataSource;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SettingFile implements Externalizable {
    String text = "";
    public SettingFile(String text) {
        this.text = text;
    }

    public SettingFile() {
    }
    public String toString() {
        return text;
    }

    @Override
    public void writeExternal(ObjectOutput out) {
        try {
            out.writeObject(this.text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readExternal(ObjectInput in) {
        try {
            text = (String) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}
