package com.lenovo.managerapp.controlapp.view.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class LatestVersionBean implements Serializable {
    public ArrayList<Gate> gate;

    public LatestVersionBean(ArrayList<Gate> gate) {
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
        public String latest_version;

        public Gate(String name, String current_version) {
            this.name = name;
            this.latest_version = current_version;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLatest_Version() {
            return latest_version;
        }

        public void setLatest_Version(String current_version) {
            this.latest_version = current_version;
        }
    }
}
