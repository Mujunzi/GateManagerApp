package com.lenovo.managerapp.controlapp.view.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class GateBean implements Serializable {
    public ArrayList<Gate> gate;

    public GateBean(ArrayList<Gate> gate) {
        this.gate = gate;
    }

    public ArrayList<Gate> getGate() {
        return gate;
    }

    public void setGate(ArrayList<Gate> gate) {
        this.gate = gate;
    }

    public static class Gate implements Serializable {
        public String name;
        public boolean state;
        public String current_version;

        public Gate(String name, boolean state, String current_version) {
            this.name = name;
            this.state = state;
            this.current_version = current_version;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public String getCurrent_version() {
            return current_version;
        }

        public void setCurrent_version(String current_version) {
            this.current_version = current_version;
        }
    }
}
